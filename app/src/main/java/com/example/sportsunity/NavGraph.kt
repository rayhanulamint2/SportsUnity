package com.example.sportsunity

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(modifier:Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MYPROFILE"){
        composable(route = "LOGIN"){
            Login(navController,modifier)
        }
        composable(route = "SIGNUP"){
            SignUp(navController,modifier)
        }
        composable(route = "HOME"){
            Home(navController,modifier)
        }
        composable(route = "CREATETOURNAMENT"){
            CreateTournament(navController,modifier)
        }
        composable(route = "CREATETOURNAMENTCHESS"){
            CreateTournamentChess(navController,modifier)
        }
        composable(route = "AFTERSIGNUP"){
            AfterSignUp(navController = navController, modifier = modifier)
        }
        composable(route = "MYPROFILE"){
            MyProfile(navController = navController, modifier = modifier)
        }

    }
}