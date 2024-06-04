package com.example.sportsunity.SharedViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sportsunity.model.PlayerId
import com.example.sportsunity.model.SportID
import com.example.sportsunity.model.TournamentID
import com.example.sportsunity.model.UserID
import com.example.sportsunity.model.WinnerList2
import com.example.sportsunity.model.teams
import com.example.sportsunity.model.winnerList1
import com.google.firebase.Firebase
import com.google.firebase.firestore.core.ListenSequence
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await


class SharedViewModel: ViewModel() {
    var userEmail = ""
    var userPassword = ""
    var logInDone = false
    var player1 = ""
    var player2 = ""
    var round = ""
    var today = ""
    var topBar = "HOME"
    var user = "user"
    var sport = "Chess"
    var recentTournament = TournamentID()
    val userDetails = UserID()
    var allUser: List<UserID> = emptyList()
    var tournaments = arrayListOf<TournamentID>()
    var runningTournaments:List<TournamentID> = emptyList()
    var myTournaments: List<TournamentID> = emptyList()
    var myVolunteerTournaments: List<TournamentID> = emptyList()
    var allSports: List<SportID> = emptyList()
    var allWinnerList: List<winnerList1> = emptyList()
    var recentSport = SportID()
    var teamName = "Tanvir's Team"
    var allTeams: List<teams> = emptyList()
    var team1 = ""
    var team2 = ""
    var team1Details = teams()
    var team2Details = teams()
    var team1PlayerId: List<PlayerId> = emptyList()
    var team2PlayerId: List<PlayerId> = emptyList()
    var allPlayerId: List<PlayerId> = emptyList()
    var allWinnerList2: List<WinnerList2> = emptyList()
    var recentWinnerList2 = WinnerList2()
    var tt: List<TournamentID> = emptyList()


    // Declare as MutableList
    fun updatePlayerList(playerList:List<String>){
        val db = Firebase.firestore
        val washingtonRef = recentSport.sportsId?.let { db.collection("sports").document(it) }
        recentSport.sportsId?.let { Log.d("tasnuva", it) }
// Set the "isCapital" field of the city 'DC'
        if (washingtonRef != null) {
            washingtonRef
                .update("playerList", playerList)
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully updated!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error updating document", e) }
        }
    }

    suspend fun findTournamentsDetails(date: String,viewModel: SharedViewModel){
        val db = Firebase.firestore
        runningTournaments = emptyList()
        println(runningTournaments)

        val documents = db.collection("tournaments")
            .whereGreaterThan("endDate", date)
            .get()
            .await()

                for (document in documents) {
                    var tournamentDetails = TournamentID()
                    tournamentDetails.organizerEmail = userDetails.email
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
                    Log.d("success5","$viewModel.tournaments")
                    Log.d("success8", "${document.id} => $tournamentDetails")
                }
                Log.d("success4","$runningTournaments")
//                viewModel.runningTournaments = runningTournaments
                Log.d("success9","${viewModel.runningTournaments}")

        Log.d("success2","${viewModel.runningTournaments}")

    }

    suspend fun findMyTournament(date: String?) {
        val db=Firebase.firestore
        myTournaments = emptyList()
        val documents = db.collection("tournaments")
            .whereEqualTo("organizerEmail", userDetails.email)
            .get()
            .await()

        for (document in documents) {
            var tournamentDetails = TournamentID()
            tournamentDetails.organizerEmail = document.getString("organizerEmail")
            tournamentDetails.name = document.getString("name")
            tournamentDetails.description = document.getString("description")
            tournamentDetails.startDate = document.getString("startDate")
            tournamentDetails.endDate = document.getString("endDate")
            tournamentDetails.sports = document.get("sports") as? List<String>
            tournamentDetails.volunteers = document.get("volunteers") as? List<String>
            tournamentDetails.tournamentId = document.id

            if (date != null) {
                if(date< tournamentDetails.endDate.toString())myTournaments+=tournamentDetails
            }
            Log.d("success8", "${document.id} => $tournamentDetails")
        }
    }
    fun findMyVoulunteerTounaments(){
        myVolunteerTournaments = emptyList()
        for(tournament in runningTournaments){
            val volunteerList = tournament.volunteers
            if (volunteerList != null) {
                for(volunteer in volunteerList){
                    if(volunteer==userDetails.name){
                        myVolunteerTournaments+=tournament
                        break
                    }
                }
            }
            Log.d("myvolunteer","$myVolunteerTournaments")
        }
    }
//    suspend fun findMyVoulunteerTournaments(date: String?) {
//        val db=Firebase.firestore
//        myVolunteerTournaments = emptyList()
//        val documents = db.collection("tournaments")
//            .get()
//            .await()
//
//        for (document in documents) {
//            val volunteerList = document.get("volunteers") as? List<String>
//            if (volunteerList != null) {
//                volunteerList.forEachIndexed { index, s ->
//                    if(s==userDetails.name){
//                        var tournamentDetails = TournamentID()
//                        tournamentDetails.organizerEmail = document.getString("organizerEmail")
//                        tournamentDetails.name = document.getString("name")
//                        tournamentDetails.description = document.getString("description")
//                        tournamentDetails.startDate = document.getString("startDate")
//                        tournamentDetails.endDate = document.getString("endDate")
//                        tournamentDetails.sports = document.get("sports") as? List<String>
//                        tournamentDetails.volunteers = document.get("volunteers") as? List<String>
//                        tournamentDetails.tournamentId = document.id
//
//                        if (date != null) {
//                            if(date< tournamentDetails.endDate.toString())myTournaments+=tournamentDetails
//                        }
//                        Log.d("success8", "${document.id} => $tournamentDetails")
//                    }
//                }
//            }
//        }
//    }


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
                    userDetails.registrationNo = document.getString("registrationNo")
                    userDetails.contact = document.getString("contact")
                    userDetails.email = document.getString("email")
                    userDetails.password = document.getString("password")
                    userDetails.asParticipant = document.get("asParticipant") as? List<String>
                    userDetails.isSubscribed = document.get("isSubscribed") as Boolean?
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
        registrationNo: String,
        contact: String,
        email: String,
        password: String
    ) {
        val db = Firebase.firestore
        val list = emptyList<String>()
        val user = hashMapOf(
            "name" to name,
            "university" to university,
            "registrationNo" to registrationNo,
            "contact" to contact,
            "email" to email,
            "password" to password,
            "isSubscribed" to false
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
            "organizerEmail" to userDetails.email,
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
    fun winnerListUpdate(
        tournamentName: String,
        round: String,
        winnerName: String,
        losserName: String,
        sportName: String
    ) {
        val db = Firebase.firestore
        val tournament = hashMapOf(
            "tournamentName" to tournamentName,
            "round" to round,
            "winnerName" to winnerName,
            "losserName" to losserName,
            "sportName" to sportName
        )

        // Add a new document with a generated ID
        db.collection("winnerlist")
            .add(tournament)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }
    suspend fun findAllWinnerList1(){
        val db = Firebase.firestore
        allWinnerList = emptyList()

        val documents = db.collection("winnerlist")
            .get()
            .await()

        for (document in documents) {
            val winnerlist11 = winnerList1(
                winnerListId = document.id,
                tournamentName = document.getString("tournamentName"),
                round = document.getString("round"),
                sportName = document.getString("sportName"),
                winnerName = document.getString("winnerName"),
                losserName = document.getString("losserName")
            )
            allWinnerList+=winnerlist11
            Log.d("allwinnerList","$allWinnerList")
        }
    }

    suspend fun findAllSports(){
        val db = Firebase.firestore
        allSports = emptyList()

        val documents = db.collection("sports")
            .get()
            .await()

        for (document in documents) {
            val sportId = SportID(
                sportName = document.getString("sportName"),
                tournamentName = document.getString("tournamentName"),
                playerList = document.get("playerList") as? List<String>,
                winnerList = document.get("winnerList") as? List<String>,
                sportsId = document.id
            )
            allSports+=sportId

        }
    }
    suspend fun findAllUsers(){
        val db = Firebase.firestore
        allUser = emptyList()

        val documents = db.collection("users")
            .get()
            .await()

        for (document in documents) {
            val userId = UserID(
                documentId = document.id,
                name = document.getString("name"),
                email = document.getString("email"),
                password = document.getString("password"),
                university = document.getString("university"),
                contact = document.getString("contact"),
                registrationNo = document.getString("registrationNo")
            )
            allUser+=userId
        }
    }

    fun sportsUpdate(
        sports: List<String>,
        tournamentName: String
    ) {
        val db = Firebase.firestore
        for(sportName in sports){
            val tournament = hashMapOf(
                "tournamentName" to tournamentName,
                "sportName" to sportName,
                "playerList" to emptyList<String>(),
                "winnerList" to emptyList<String>()
            )

            // Add a new document with a generated ID
            db.collection("sports")
                .add(tournament)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }

    }
    suspend fun findAllTeams(){
        val db = Firebase.firestore
        allTeams = emptyList()

        val documents = db.collection("teams")
            .get()
            .await()

        for (document in documents) {
            val team = teams(
                tournamentName = document.getString("tournamentName"),
                playerList = document.get("playerList") as? List<String>,
                teamsId = document.id,
                name  =  document.getString("teamName")
            )
            allTeams+=team

        }
    }
    fun teamsUpdate(
        tournamentName: String,
        teamName: String,
        playerList: List<String>,
    ) {
        val db = Firebase.firestore
        val tournament = hashMapOf(
            "tournamentName" to tournamentName,
            "teamName" to teamName,
            "playerList" to playerList
        )

        // Add a new document with a generated ID
        db.collection("teams")
            .add(tournament)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }
    suspend fun findAllPlayerId(){
        val db = Firebase.firestore
        allPlayerId = emptyList()

        val documents = db.collection("playerId")
            .get()
            .await()

        for (document in documents) {
            val player = PlayerId(
                tournamentName = document.getString("tournamentName"),
                playerIdId = document.id,
                playerName  =  document.getString("playerName"),
                goal = document.getString("goal"),
                assist = document.getString("assist"),
                round = document.getString("round"),
                teamName = document.getString("teamName")
            )
            allPlayerId+=player

        }
    }
    fun PlayerIdUpdate(team:String){
        Log.d("team1playeridkjdf","$team1")
        Log.d("team2playeridkjdf","$team2")
        var teamName = if(team=="team1"){
            team1
        }
        else{
            team2
        }
        Log.d("teamName","$teamName")
        val playerIdList: List<PlayerId> = if(team=="team1"){
            team1PlayerId

        }
        else team2PlayerId

        Log.d("team1playerid","${team1PlayerId.size}")
        Log.d("team2playerid","${team2PlayerId.size}")
        for(playerId in playerIdList){
            val db = Firebase.firestore
            val tournament = hashMapOf(
                "tournamentName" to playerId.tournamentName,
                "playerName" to playerId.playerName,
                "goal" to playerId.goal,
                "assist" to playerId.assist,
                "round" to round,
                "teamName" to teamName
            )

            // Add a new document with a generated ID
            db.collection("playerId")
                .add(tournament)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }
    suspend fun findAllWinnerList2(){
        val db = Firebase.firestore
        allWinnerList2 = emptyList()

        val documents = db.collection("winnerlist2")
            .get()
            .await()

        for (document in documents) {
            val player = WinnerList2(
                tournamentName = document.getString("tournamentName"),
                winnerTeamGoal = document.getString("winnerTeamGoal"),
                round = document.getString("round"),
                WinnerListId = document.id,
                winnerTeamName = document.getString("winnerTeamName"),
                losserTeamGoal = document.getString("losserTeamGoal"),
                losserTeamName = document.getString("losserTeamName")
            )
            allWinnerList2+=player

        }
    }
    fun winnerList2Update(
        tournamentName: String,
        winnerTeamName: String,
        losserTeamName: String,
        winnerTeamGoal: String,
        losserTeamGoal: String,
    ) {
        val db = Firebase.firestore
        val tournament = hashMapOf(
            "tournamentName" to tournamentName,
            "winnerTeamName" to winnerTeamName,
            "winnerTeamGoal" to winnerTeamGoal,
            "losserTeamName" to losserTeamName,
            "losserTeamGoal" to losserTeamGoal,
            "round" to round
        )

        // Add a new document with a generated ID
        db.collection("winnerlist2")
            .add(tournament)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }
    fun updatePersonalDetails(name:String,university: String,contact: String,isSubscribed: Boolean = false){
        val db = Firebase.firestore
        val washingtonRef = userDetails.documentId?.let { db.collection("users").document(it) }
// Set the "isCapital" field of the city 'DC'

        washingtonRef?.update(
            mapOf(
                "name" to name,
                "university" to university,
                "contact" to contact,
                "isSubscribed" to isSubscribed
            )
        )?.addOnSuccessListener {
            Log.d(TAG, "DocumentSnapshot successfully updated!")
        }?.addOnFailureListener { e ->
            Log.w(TAG, "Error updating document", e)
        }

    }
    fun updateParticipantList(playerList:List<String>){
        val db = Firebase.firestore
        val washingtonRef = userDetails.documentId?.let { db.collection("users").document(it) }

// Set the "isCapital" field of the city 'DC'
        if (washingtonRef != null) {
            washingtonRef
                .update("asParticipant", playerList)
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully updated!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error updating document", e) }
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

//    fun getTopBar(): String {
//        return topBar
//    }

//    fun setTopBar(TopBar: String) {
//        topBar = TopBar
//    }
}
