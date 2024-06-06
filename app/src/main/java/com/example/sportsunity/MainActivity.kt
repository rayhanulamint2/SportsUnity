package com.example.sportsunity

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.ui.theme.SportsUnityTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity(),MainActivityCallback {
    private lateinit var auth: FirebaseAuth
    var mainActivityCallBack = this
    var hello = false

    override fun createAccount(email:String,password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
    //                updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
    //                updateUI(null)
                }
        }
    }
    override fun login(email: String, password: String,navController: NavController) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Login successful
                    val user = auth.currentUser
                    Toast.makeText(
                        baseContext,
                        "Log In Successful.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    hello = true
                    navController.navigate("HOME")
                } else {
                    // Login failed
                    Log.w("Login", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Your Email or Password is incorrect.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        FirebaseApp.initializeApp(this)
        auth = Firebase.auth
        setContent {
            SportsUnityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel: SharedViewModel = viewModel()
                    Nav(mainActivityCallback = mainActivityCallBack,viewModel = viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    SportsUnityTheme {
//        Nav()
    }
}