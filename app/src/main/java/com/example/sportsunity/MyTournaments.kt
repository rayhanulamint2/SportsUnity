package com.example.sportsunity

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.data.DataSource
import com.example.sportsunity.data.DataSourceForMyTournament
import com.example.sportsunity.model.RunningTournament

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTournaments(navController:NavController, modifier: Modifier) {
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
            myContentMyTournaments(navController,innerpadding)
        }
    )
}


@Composable
fun myContentMyTournaments(navController: NavController, innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        MyTournamentList(navController = navController, mytournamentList = DataSourceForMyTournament().loadMyTournament())
    }
}
@Composable
fun MyTournamentList(navController: NavController,mytournamentList: List<RunningTournament>,modifier: Modifier = Modifier){

    LazyColumn(modifier = modifier.padding(top = 50.dp)){
        items(mytournamentList){ mytournament ->
            MyTournamentCard(
                navController = navController,
                mytournament = mytournament,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun MyTournamentCard(navController: NavController, mytournament: RunningTournament, modifier:Modifier = Modifier){
    Card(
        modifier = modifier.clickable {
            navController.navigate("SPORTSLISTFORORGANAIZER")
        },
        colors = CardDefaults.cardColors(containerColor = Color.Black)

    ){


//        Box(modifier = modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = mytournament.imageResourceId),
            contentDescription = stringResource(id = mytournament.stringResourceId),
            modifier = Modifier
                .fillMaxWidth()
                .height(194.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = LocalContext.current.getString(mytournament.stringResourceId),
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp, start = 16.dp),
            //                style = MaterialTheme.typography.headlineSmall
        )

//        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = LocalContext.current.getString(mytournament.stringResourceId2),
            color = Color.White,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }

}


