package com.example.sportsunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.data.DataSourceTeamWiseWinner
import com.example.sportsunity.model.TeamWiseWinner
import com.example.sportsunity.model.WinnerList
import kotlin.io.path.createTempDirectory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamWiseWinner(navController: NavController,viewModel: SharedViewModel,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
            TopBarDesignWithBack(navController = navController, navigation = "SPORTSLISTFORORGANAIZER", header = "Football" )
        },
        content = {innerpadding->
            myContentTeamWiseWinner(navController,viewModel,innerpadding)
        }
    )
}

@Composable
fun myContentTeamWiseWinner(navController: NavController,viewModel: SharedViewModel,innerpadding: PaddingValues){

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        ListForTeamWiseWinner(navController = navController, teamwisewinner = DataSourceTeamWiseWinner().loadTeamWiseWinner())
    }

}

@Composable
fun ListForTeamWiseWinner(navController: NavController, teamwisewinner: List<TeamWiseWinner>, modifier: Modifier = Modifier){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.fillMaxSize().border(border = BorderStroke(2.dp, color = Color.White), // Set border stroke to 2dp with Black color
//            shape = MaterialTheme.shapes.medium)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
//        val win = WinnerList(R.string.name, R.string.round)
//        WinnerListCard(navController = navController, winnerlist = win)
        LazyColumn(modifier = modifier.padding(top = 20.dp)) {
            items(teamwisewinner) { teamwisewinner ->
                TeamWiseWinnerCard(navController = navController, teamwisewinner = teamwisewinner)
            }
        }
    }
}
@Composable
fun TeamWiseWinnerCard(navController: NavController, teamwisewinner: TeamWiseWinner, modifier: Modifier = Modifier){
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
                    text = "Winner Team:",
                    fontSize = 13.sp,
                    color = Color.White
                )
                Text(
                    text = stringResource(teamwisewinner.stringResourceId1),
                    color = Color.White,
                    fontSize = 17.sp,
                )
                Text(
                    text = "Losser Team:",
                    fontSize = 13.sp,
                    color = Color.White
                )
                Text(
                    text = stringResource(teamwisewinner.stringResourceId2),
                    color = Color.White,
                    fontSize = 17.sp,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(.2f)
            ) {
                Text(
                    text = "Result:",
                    fontSize = 13.sp,
                    color = Color.White

                )
                Text(
                    text = stringResource(id = teamwisewinner.goal_team1)+"-"+stringResource(id = teamwisewinner.goal_team2),
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
                    text = "Round:",
                    fontSize = 13.sp,
                    color = Color.White

                )
                Text(
                    text = stringResource(id = teamwisewinner.stringResourceId3),
                    color = Color.White,
                    fontSize = 17.sp
                    //                modifier = Modifier.fillMaxWidth(.2f)
                )
            }
        }
    }
}

