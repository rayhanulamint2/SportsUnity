package com.example.sportsunity

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsListForOrganaizer(navController: NavController,viewModel: SharedViewModel,modifier: Modifier = Modifier){
    val paddingValues = 10.dp
    Scaffold(
        topBar = {
//            TopBarSportsList(navController = navController)
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = viewModel.topBar,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            if(viewModel.user=="user") {
                                navController.navigate("HOME")
                            }
                            else navController.navigate("MYTOURNAMENTS")
                        }) {
                            //                                 Icon(
                            //                                     imageVector = Icons.Default.Menu,
                            //                                     contentDescription = null,
                            //                                     tint = Color.White
                            //                                 )
                            Image(
                                painter = painterResource(id = R.drawable.back_button),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(Color.Black)
                )
                Image(
                    painter = painterResource(id = R.drawable.blue_line),
                    contentDescription = "Blue Line",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                )
            }
                 },
        content = {innerpadding->
//            myContent(navController,innerpadding)
            myContentSportsListForOrganaizer(navController = navController,viewModel = viewModel, innerpadding = innerpadding )
        }
    )

}


@Composable
fun myContentSportsListForOrganaizer(navController: NavController,viewModel: SharedViewModel,innerpadding:PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        viewModel.recentTournament.sports?.let { SportsList(navController = navController,viewModel = viewModel, sportlist = it) }
    }
}

@Composable
fun SportsList(
    navController: NavController,
    sportlist: List<String>,
    modifier: Modifier = Modifier,
    viewModel: SharedViewModel
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Text(
//            text = "SPORTS LIST",
//            color = Color.White,
//            fontSize = 36.sp,
//
//            )
        LazyColumn(modifier = modifier.padding(top = 50.dp)) {
            items(sportlist) { mysport ->
                SportListCard(
                    navController = navController,
                    sportlist = mysport,
                    modifier = Modifier.padding(8.dp),
                    viewModel = viewModel
                )
            }
        }
    }
}
@Composable
fun SportListCard(navController: NavController, viewModel: SharedViewModel, sportlist: String, modifier:Modifier = Modifier){
    Card(
        modifier = modifier
            .fillMaxWidth(.5f)
            .clickable {
                viewModel.sport = sportlist
                viewModel.topBar = sportlist
                Log.d("tanvir",viewModel.topBar)
                for(sports in viewModel.allSports){
                    if(sports.sportName==viewModel.sport&&sports.tournamentName==viewModel.recentTournament.name){
                        viewModel.recentSport = sports
                        break
                    }
                }
                if(viewModel.user=="organaizer"){
                    navController.navigate("CREATETOURNAMENTCHESS")
                }
                else if(viewModel.user=="user"){
                    if(sportlist=="FOOTBALL"){
                        navController.navigate("TEAMWISEWINNER")
                    }
                    else{
                        navController.navigate("WINNERLIST")
                    }
                }
                else{
                    navController.navigate("NEWMATCHCREATION")
                }
            },
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))

    ){


        Text(
            text = sportlist,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
//                .align(Alignment.Center)
                .padding(10.dp)
//                            style = MaterialTheme.typography.headlineSmall
        )

    }

}