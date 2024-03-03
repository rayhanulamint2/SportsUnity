package com.example.sportsunity

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.ui.theme.NewMatchCreation
import com.google.firebase.auth.FirebaseUser

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Nav(mainActivityCallback: MainActivityCallback,user: FirebaseUser,modifier:Modifier = Modifier){
    val navController = rememberNavController()
    val text = "tanvir"
    val viewModel: SharedViewModel = viewModel()
    val topBar = viewModel.getTopBar()
    NavHost(navController = navController, startDestination = "TEAMWISEWINNER"){

        composable(route = "LOGIN"){
            Login(mainActivityCallback = mainActivityCallback,navController,modifier)
        }
        composable(route = "SIGNUP"){
            SignUp(mainActivityCallback = mainActivityCallback,navController,modifier)
        }
        composable(route = "HOME"){
            viewModel.setTopBar("SPORTSUNITY")
            Home(navController,viewModel,modifier)
        }
        composable(route = "CREATETOURNAMENT"){
            viewModel.setTopBar("Create Tournament")
            CreateTournament(navController,viewModel,modifier)
        }
        composable(route = "CREATETOURNAMENTCHESS"){
            CreateTournamentChess(navController,viewModel,modifier)
        }

        composable(route = "AFTERSIGNUP"){
            AfterSignUp(navController = navController, modifier = modifier)
        }
        composable(route = "MYPROFILE"){
            MyProfile(navController = navController, modifier = modifier)
        }


        composable(route = "CONFIRMATION"){
            Confirmation(navController = navController,modifier)
        }
        composable(route = "PERSONALINFO"){
            PersonalInfo(navController = navController,modifier)
        }

        composable(route = "PARTICIPATIONS"){
            Participations(navController = navController,modifier)
        }

        composable(route = "MYTOURNAMENTS"){
            MyTournaments(navController = navController,modifier)
        }
        composable(route = "SPORTSLISTFORORGANAIZER"){
            viewModel.setTopBar("Sports List")
            SportsListForOrganaizer(navController = navController,viewModel,modifier = modifier)
        }
        composable(route = "NEWMATCHCREATION"){
            NewMatchCreation(text,navController = navController,modifier = modifier)
        }
        composable(route = "WINNERLIST"){
            WinnerList(navController = navController,modifier = modifier)
        }
        composable(route = "WINNERSELECTION"){
            WinnerSelection(navController = navController,modifier = modifier)
        }
        composable(route = "FOOTBALL"){
            FootBall(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "TEAMWISEWINNER"){
            TeamWiseWinner(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "INDIVIDUALTEAM"){
            IndividualTeam(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "FOOTBALLUPDATE"){
            FootBallUpdate(navController = navController,viewModel = viewModel,modifier = modifier)
        }


    }
}