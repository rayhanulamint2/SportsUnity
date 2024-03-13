package com.example.sportsunity.SharedViewModel

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import com.example.sportsunity.model.TournamentID
import com.example.sportsunity.model.UserID
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class SharedViewModel: ViewModel() {
    var logInDone = false
    var today = ""
    private var topBar = "HOME"
    var user = "user"
    var userId = ""
    var tournamentId = ""
    val userDetails = UserID()
    val tournamentDetails = TournamentID()
    var tournaments = arrayListOf<TournamentID>()
    var runningTournaments:List<TournamentID> = emptyList()
    var tt: List<TournamentID> = emptyList()


    // Declare as MutableList


    suspend fun findTournamentsDetails(date: String,viewModel: SharedViewModel){
        val db = Firebase.firestore
        runningTournaments = emptyList()
        println(runningTournaments)

        val documents = db.collection("tournaments")
            .whereGreaterThan("endDate", date)
            .get()
            .await()

                for (document in documents) {
                    tournamentDetails.name = document.getString("name")
                    tournamentDetails.description = document.getString("description")
                    tournamentDetails.startDate = document.getString("startDate")
                    tournamentDetails.endDate = document.getString("endDate")
                    tournamentDetails.sports = document.get("sports") as? List<String>
                    tournamentDetails.volunteers = document.get("volunteers") as? List<String>
                    tournamentDetails.tournamentId = document.id

                    viewModel.tournaments.add(tournamentDetails)
                    runningTournaments+=tournamentDetails
//                    viewModel.runningTournaments = addInListTournaments(viewModel.runningTournaments,tournamentDetails)
                    Log.d("success1","$tournamentDetails")
                    Log.d("success3","$runningTournaments")
                    Log.d(TAG, "${document.id} => $tournamentDetails")
                }
                Log.d("success4","$runningTournaments")
                viewModel.runningTournaments = runningTournaments
                Log.d("success9","${viewModel.runningTournaments}")

        Log.d("success2","${viewModel.runningTournaments}")

    }


    fun findUserDetails(email: String, password: String) {
        val db = Firebase.firestore
        db.collection("users")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    userDetails.documentId = document.id
                    userDetails.name = document.getString("name")
                    userDetails.university = document.getString("university")
                    userDetails.contact = document.getString("contact")
                    userDetails.email = document.getString("email")
                    userDetails.password = document.getString("password")
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }

    fun userUpdate(
        name: String,
        university: String,
        contact: String,
        email: String,
        password: String
    ) {
        val db = Firebase.firestore
        val user = hashMapOf(
            "name" to name,
            "university" to university,
            "contact" to contact,
            "email" to email,
            "password" to password
        )

        // Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    fun tournamentUpdate(
        name: String,
        description: String,
        sports: List<String>,
        volunteers: List<String>,
        startDate: String?,
        endDate: String?
    ) {
        val db = Firebase.firestore
        val tournament = hashMapOf(
            "name" to name,
            "description" to description,
            "sports" to sports,
            "volunteers" to volunteers,
            "startDate" to startDate,
            "endDate" to endDate
        )

        // Add a new document with a generated ID
        db.collection("tournaments")
            .add(tournament)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }
    fun addInListTournaments(list: List<TournamentID>?, item: TournamentID): List<TournamentID> {
        if (list == null) {
            return listOf(item)
        }
        return list + item
    }
    fun addInList(list: List<String>, string: String): List<String> {
//    list.add(string)
        return list + string
    }

    fun getTopBar(): String {
        return topBar
    }

    fun setTopBar(TopBar: String) {
        topBar = TopBar
    }
}
