package com.example.sportsunity

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.model.TournamentID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTournaments(navController:NavController,viewModel: SharedViewModel, modifier: Modifier) {

    Scaffold(
        topBar = {
//            TopBarMyTournaments(navController)
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = "My Tournaments",
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate("HOME")
                        }) {
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
            var x by remember {
                mutableStateOf(1)
            }
            if(x==2){
                myContentMyTournaments(navController, viewModel = viewModel,innerpadding)
            }
            else if(x==3){
                Log.d("mytournaments","${viewModel.runningTournaments}")
                Log.d("myvolunteer1","$viewModel.myVolunteerTournaments")
                myContent(navController, innerpadding)
            }
            else {
                loading()
                LaunchedEffect(Unit) {
                    viewModel.findAllSports()
                    viewModel.findMyTournament(viewModel.today)
                    viewModel.findMyVoulunteerTounaments()
                    if(viewModel.myTournaments.size==0&&viewModel.myVolunteerTournaments.size==0)x = 3
                    else x = 2
                }

            }

        }
    )
}


@Composable
fun myContentMyTournaments(navController: NavController, viewModel: SharedViewModel,innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Log.d("mytournaments","${viewModel.myTournaments}")
        viewModel.findMyVoulunteerTounaments()
        Log.d("myvolunteer1","$viewModel.myVolunteerTournaments")
        MyTournamentList(navController = navController,viewModel = viewModel, mytournamentList = viewModel.myTournaments,myVolunteerTournamentList = viewModel.myVolunteerTournaments )

    }
}
@Composable
fun MyTournamentList(
    navController: NavController,
    mytournamentList: List<TournamentID>,
    modifier: Modifier = Modifier,
    viewModel: SharedViewModel,
    myVolunteerTournamentList: List<TournamentID>
){

    LazyColumn(modifier = modifier.padding(top = 25.dp)){
        items(mytournamentList){ mytournament ->
            MyTournamentCard(
                navController = navController,
                mytournament = mytournament,
                modifier = Modifier.padding(8.dp),
                viewModel = viewModel
            )
        }
        items(myVolunteerTournamentList){ myvolunteertournament ->
            MyVolunteerTournamentCard(
                navController = navController,
                mytournament = myvolunteertournament,
                modifier = Modifier.padding(8.dp),
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun MyTournamentCard(
    navController: NavController,
    mytournament: TournamentID,
    modifier: Modifier = Modifier,
    viewModel: SharedViewModel
){
    Card(
        modifier = modifier.clickable {
            viewModel.recentTournament = mytournament
            viewModel.user = "organaizer"
            navController.navigate("SPORTSLISTFORORGANAIZER")
        },
        colors = CardDefaults.cardColors(containerColor = Color.Black)

    ){


//        Box(modifier = modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.indoor_eee),
            contentDescription = "bannar",
            modifier = Modifier
                .fillMaxWidth()
                .height(194.dp),
            contentScale = ContentScale.Crop
        )
        Row(modifier = Modifier.padding(top = 10.dp, start = 16.dp),){
            mytournament.name?.let {
                Text(
                    text = it,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(.8f)
                    //                style = MaterialTheme.typography.headlineSmall
                )
            }
            Column(
                modifier = Modifier.weight(.2f)
            ) {
                Text(
                    text = "End Date",
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                )

                mytournament.endDate?.let {
                    Text(
                        text = it,
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier
                    )
                }
            }
        }

//        }
        Spacer(modifier = Modifier.height(10.dp))
        mytournament.description?.let {
            Text(
                text = it,
                color = Color.White,
                fontSize = 10.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}


@Composable
fun MyVolunteerTournamentCard(
    navController: NavController,
    mytournament: TournamentID,
    modifier: Modifier = Modifier,
    viewModel: SharedViewModel
){
    Card(
        modifier = modifier.clickable {
            viewModel.recentTournament = mytournament
            viewModel.user = "volunteer"
            navController.navigate("SPORTSLISTFORORGANAIZER")
        },
        colors = CardDefaults.cardColors(containerColor = Color.Black)

    ){


//        Box(modifier = modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.indoor_eee),
            contentDescription = "bannar",
            modifier = Modifier
                .fillMaxWidth()
                .height(194.dp),
            contentScale = ContentScale.Crop
        )
        Row(modifier = Modifier.padding(top = 10.dp, start = 16.dp),){
            mytournament.name?.let {
                Text(
                    text = it,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(.8f)
                    //                style = MaterialTheme.typography.headlineSmall
                )
            }
            Column(
                modifier = Modifier.weight(.2f)
            ) {
                Text(
                    text = "End Date",
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                )

                mytournament.endDate?.let {
                    Text(
                        text = it,
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier
                    )
                }
            }
        }

//        }
        Spacer(modifier = Modifier.height(10.dp))
        mytournament.description?.let {
            Text(
                text = it,
                color = Color.White,
                fontSize = 10.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}