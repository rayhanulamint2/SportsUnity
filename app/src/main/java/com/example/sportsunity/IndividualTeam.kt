package com.example.sportsunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.data.DataSourceIndividualTeam
import com.example.sportsunity.model.IndividualTeam
import com.example.sportsunity.model.WinnerList
import androidx.compose.ui.res.colorResource as colorResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndividualTeam(navController: NavController,viewModel: SharedViewModel,modifier:Modifier = Modifier){
    Scaffold(
        topBar = {
            TopBarDesignWithBack(navController = navController, navigation = "TEAMWISEWINNER", header = "Football" )
        },
        content = {innerpadding->
            myContentIndividualTeam(navController,viewModel,innerpadding)
        }
    )
}
@Composable
fun myContentIndividualTeam(navController: NavController,viewModel: SharedViewModel,innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
    ListForIndividualTeam(navController = navController, individualteam = DataSourceIndividualTeam().loadIndividualTeam())
}

@Composable
fun ListForIndividualTeam(navController: NavController, individualteam: List<IndividualTeam>, modifier: Modifier = Modifier) {
    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(.5f)
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Card(
                modifier = Modifier.padding(top = 5.dp, start = 30.dp, end = 30.dp, bottom = 5.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
            ) {
                Row(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Team 1",
                        color = Color.White
                    )
                }
            }
            LazyColumn(modifier = modifier.padding(top = 20.dp)) {
                items(individualteam) { individualteam ->
                    IndividualTeamCard(
                        navController = navController,
                        individualteam = individualteam,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(.5f)
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Card(
                modifier = Modifier.padding(top = 5.dp, start = 30.dp, end = 30.dp, bottom = 5.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
            ) {
                Row(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Team 2",
                        color = Color.White
                    )
                }
            }
            LazyColumn(modifier = modifier.padding(top = 20.dp)) {
                items(individualteam) { individualteam ->
                    IndividualTeamCard(
                        navController = navController,
                        individualteam = individualteam,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}




@Composable
fun IndividualTeamCard(navController: NavController, individualteam: IndividualTeam, modifier: Modifier = Modifier){
    Card(
        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ){
            Column(
                modifier = Modifier.weight(.6f)
            ) {
                Text(
                    text = "Player:",
                    fontSize = 13.sp,
                    color = Color.White
                )
                Text(
                    text = stringResource(individualteam.stringResourceId1),
                    color = Color.White,
                    fontSize = 17.sp,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(.2f)
            ) {
                Text(
                    text = "Goal:",
                    fontSize = 13.sp,
                    color = Color.White

                )
                Text(
                    text = individualteam.goal_team1.toString(),
                    color = Color.White,
                    fontSize = 17.sp
                    //                modifier = Modifier.fillMaxWidth(.2f)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(.2f)
            ) {
                Text(
                    text = "Assist:",
                    fontSize = 13.sp,
                    color = Color.White

                )
                Text(
                    text = individualteam.goal_team2.toString(),
                    color = Color.White,
                    fontSize = 17.sp
                    //                modifier = Modifier.fillMaxWidth(.2f)
                )
            }
        }
    }
}
