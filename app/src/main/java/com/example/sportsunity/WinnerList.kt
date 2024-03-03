package com.example.sportsunity

import android.icu.text.LocaleDisplayNames
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.data.DataSourceForWinnerList
import com.example.sportsunity.model.WinnerList
import com.example.sportsunity.ui.theme.BackButtonFromNewMatchCreation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WinnerList(navController: NavController,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
//            TopBarWinnerList(navController)
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = "Winner List",
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate("SPORTSLISTFORORGANAIZER")
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
            myContentWinnerList(navController,innerpadding)
        }
    )
}
@Composable
fun TopBarWinnerList(navController: NavController){
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
        ){
            BackButtonFromWinnerList {
                navController.navigate("SPORTSLISTFORORGANAIZER")
            }
            Text(
                text = "WINNER LIST",
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
fun BackButtonFromWinnerList(onClick: () -> Unit) {
    val image: Painter = painterResource(id = R.drawable.back_button)
    Image(
        painter = image,
        contentDescription = "Back Button",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(40.dp)
            .padding(top = 5.dp, bottom = 5.dp)
            .absoluteOffset(x = (-80).dp, y = 4.dp)
//                    .align(Alignment.Start)
            .clickable { onClick() }
    )
}
@Composable
fun myContentWinnerList(navController: NavController,innerpadding:PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        ListForWinnerList(navController = navController, winnerlist = DataSourceForWinnerList().loadWinnerList())
    }
}
@Composable
fun ListForWinnerList(navController: NavController, winnerlist: List<WinnerList>, modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.fillMaxSize().border(border = BorderStroke(2.dp, color = Color.White), // Set border stroke to 2dp with Black color
//            shape = MaterialTheme.shapes.medium)
    ) {
//        val win = WinnerList(R.string.name, R.string.round)
//        WinnerListCard(navController = navController, winnerlist = win)
        LazyColumn(modifier = modifier.padding(top = 20.dp)) {
            items(winnerlist) { winnerlist ->
                WinnerListCard(
                    navController = navController,
                    winnerlist = winnerlist,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
@Composable
fun WinnerListCard(navController: NavController,winnerlist: WinnerList,modifier: Modifier = Modifier){
    Card(
        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ){
            Column(
                modifier = Modifier.weight(.8f)
            ) {
                Text(
                    text = "Name:",
                    fontSize = 13.sp,
                    color = Color.White
                )
                Text(
                    text = stringResource(winnerlist.stringResourceId1),
                    color = Color.White,
                    fontSize = 17.sp,
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
                    text = stringResource(id = winnerlist.stringResourceId2),
                    color = Color.White,
                    fontSize = 17.sp
                    //                modifier = Modifier.fillMaxWidth(.2f)
                )
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun WinnerListCard(navController: NavController, winnerlist: WinnerList, modifier:Modifier = Modifier){
////    Text(
////        text = LocalContext.current.getString(winnerlist.stringResourceId),
////        color = Color.Black,
////        fontSize = 20.sp,
////        modifier = Modifier.padding(top = 10.dp, start = 16.dp),
////        //                style = MaterialTheme.typography.headlineSmall
////    )
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(2.dp)
//    ) {
//        var text by rememberSaveable {
//            mutableStateOf("")
//        }
//        var round by rememberSaveable {
//            mutableStateOf("")
//        }
//        Text(
//            text = LocalContext.current.getString(winnerlist.stringResourceId1),
//            color = Color.White,
//            modifier = Modifier
//                .padding(10.dp)
//                .weight(.7f),
//        )
//        Text(
//            text = LocalContext.current.getString(winnerlist.stringResourceId2),
//            color = Color.White,
//            modifier = Modifier
//                .padding(10.dp)
//                .weight(.7f)
//        )
////        OutlinedTextField(
////            value = LocalContext.current.getString(winnerlist.stringResourceId1),
////            onValueChange = {text = it},
////            enabled = true,
////            shape = RoundedCornerShape(30),
////            colors = TextFieldDefaults.outlinedTextFieldColors(
////                textColor = androidx.compose.ui.graphics.Color.White,
////                focusedBorderColor = androidx.compose.ui.graphics.Color(0xFF87CEEB),
////                cursorColor = androidx.compose.ui.graphics.Color.Black,
////                containerColor = colorResource(id = R.color.maastricht_Blue)
////
////            ),
////            modifier = Modifier.padding(10.dp).weight(.7f)
////        )
////        OutlinedTextField(
////            value = LocalContext.current.getString(winnerlist.stringResourceId2),
////            onValueChange = {text = it},
////            enabled = true,
////            shape = RoundedCornerShape(30),
////            colors = TextFieldDefaults.outlinedTextFieldColors(
////                textColor = androidx.compose.ui.graphics.Color.White,
////                focusedBorderColor = androidx.compose.ui.graphics.Color(0xFF87CEEB),
////                cursorColor = androidx.compose.ui.graphics.Color.Black,
////                containerColor = colorResource(id = R.color.maastricht_Blue)
////
////            ),
////            modifier = Modifier.padding(10.dp).weight(.3f)
////        )
//    }
//
//
//}
