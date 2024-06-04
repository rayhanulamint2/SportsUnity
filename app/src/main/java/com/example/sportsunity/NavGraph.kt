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
fun Nav(mainActivityCallback: MainActivityCallback,viewModel: SharedViewModel,user: FirebaseUser,modifier:Modifier = Modifier){
    val navController = rememberNavController()

    val text = "tanvir"
    val sportName = "Chess"
    val footballTeam = ""
    val topBar = viewModel.topBar
    NavHost(navController = navController, startDestination = "LOGIN"){

        composable(route = "LOGIN"){
            Login(mainActivityCallback = mainActivityCallback,viewModel = viewModel,navController,modifier)
        }
        composable(route = "SIGNUP"){
            SignUp(mainActivityCallback = mainActivityCallback,viewModel = viewModel,navController,modifier)
        }
        composable(route = "HOME"){
            viewModel.topBar="SPORTSUNITY"
            Home(navController,viewModel,modifier)
        }
        composable(route = "CREATETOURNAMENT"){
            viewModel.topBar = "Create Tournament"
            CreateTournament(navController,viewModel,modifier)
        }
        composable(route = "CREATETOURNAMENTCHESS"){
            CreateTournamentChess(navController,viewModel,modifier)
        }

        composable(route = "AFTERSIGNUP"){
            AfterSignUp(navController = navController, modifier = modifier)
        }
        composable(route = "MYPROFILE"){
            viewModel.topBar="My Profile"
            MyProfile(navController = navController, viewModel = viewModel, modifier = modifier)
        }


        composable(route = "CONFIRMATION"){
            Confirmation(navController = navController,modifier)
        }
        composable(route = "PERSONALINFO"){
            PersonalInfo(navController = navController,viewModel = viewModel,modifier)
        }

        composable(route = "PARTICIPATIONS"){
            Participations(navController = navController,viewModel = viewModel,modifier)
        }

        composable(route = "MYTOURNAMENTS"){
            viewModel.topBar=("My Tournaments")
            MyTournaments(navController = navController, viewModel = viewModel,modifier)
        }
        composable(route = "SPORTSLISTFORORGANAIZER"){
            viewModel.topBar=("Sports List")
            SportsListForOrganaizer(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "NEWMATCHCREATION"){
            viewModel.topBar = (sportName)
            NewMatchCreation(text,navController = navController, viewModel = viewModel,modifier = modifier)
        }
        composable(route = "WINNERLIST"){
            viewModel.topBar = ("Winner List")
            WinnerList(navController = navController, viewModel = viewModel,modifier = modifier)
        }
        composable(route = "WINNERSELECTION"){
            viewModel.topBar = (sportName)
            WinnerSelection(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "FOOTBALL"){
            viewModel.topBar = ("Football")
            FootBall(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "TEAMWISEWINNER"){
            viewModel.topBar = ("Football")
            TeamWiseWinner(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "INDIVIDUALTEAM"){
            viewModel.topBar = (footballTeam)
            IndividualTeam(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "FOOTBALLUPDATE"){
            viewModel.topBar = ("Football")
            FootBallUpdate(navController = navController,viewModel = viewModel,modifier = modifier)
        }
        composable(route = "OTP"){
            Otp(navController = navController,viewModel = viewModel,modifier = modifier)
        }
//        composable(route = "OTPMAIN"){
//            OTP(navController = navController,viewModel = viewModel)
//        }
    }
}