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
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTournaments(navController:NavController, modifier: Modifier) {
    Scaffold(
        topBar = { TopBarMyTournaments(navController) },
        content = {innerpadding->
            myContentMyTournaments(navController,innerpadding)
        }
    )
}

@Composable
fun TopBarMyTournaments(navController: NavController){
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
        ){
            BackButtonFromMyTournaments {
                navController.navigate("HOME")
            }
            Text(
                text = stringResource(R.string.mytournaments_title),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 5.dp)
                    .absoluteOffset(x = (-15).dp, y = 1.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.blue_line),
            contentDescription = "Blue Line",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
        )
    }
}


@Composable
fun BackButtonFromMyTournaments(onClick: () -> Unit) {
    val image: Painter = painterResource(id = R.drawable.back_button)
    Image(
        painter = image,
        contentDescription = "Back Button",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(40.dp)
            .padding(top = 5.dp, bottom = 5.dp)
            .absoluteOffset(x = (-85).dp, y = 4.dp)
//                    .align(Alignment.Start)
            .clickable { onClick() }
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
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, bottom = 40.dp, end = 32.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle_13),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .width(380.dp)
                        .height(380.dp)
                        .clip(shape = RoundedCornerShape(16.dp)),
                    alignment = Alignment.TopCenter
                )
                FilledTonalButtonExample {
//                    navController.navigate("SportsTypePage")

                }
            }
        }
    }
}

@Composable
fun FilledTonalButtonExample(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text("Indoor 2024(organized by CSE Society,SUST)")
    }
}
