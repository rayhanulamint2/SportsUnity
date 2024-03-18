package com.example.sportsunity

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
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfile(navController:NavController,viewModel: SharedViewModel, modifier: Modifier) {
    Scaffold(
        topBar = {
//            TopBarMyProfile(navController)
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = "My Profile",
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate("HOME")
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
            myContentMyProfile(navController, viewModel = viewModel,innerpadding)
        }
    )
}

@Composable
fun TopBarMyProfile(navController: NavController){
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
        ) {
            NavigationFromMyProfile {
                navController.navigate("LOGIN")
            }
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
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
fun NavigationFromMyProfile(onClick: () -> Unit) {
    val image: Painter = painterResource(id = R.drawable.back_button)
    Image(
        painter = image,
        contentDescription = "Back Button",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(40.dp)
            .padding(top = 0.dp, bottom = 5.dp)
            .absoluteOffset(x = (-90).dp, y = 4.dp)
//                    .align(Alignment.Start)
            .clickable { onClick() }
    )
}

@Composable
fun myContentMyProfile(navController: NavController, viewModel: SharedViewModel,innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, bottom = 40.dp, end = 32.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.rectangle_13),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(380.dp)
                        .height(480.dp)
                        .clip(shape = RoundedCornerShape(16.dp)),
                    alignment = Alignment.Center
                )

                Image(
                    painter = painterResource(id = R.drawable.pro_pic_not_set),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(bottom = 230.dp)
                        .width(130.dp)
                        .height(130.dp),
//                        .clip(shape = RoundedCornerShape(16.dp)),
                    alignment = Alignment.TopCenter
                )

                viewModel.userDetails.name?.let {
                    Text(
                        text = it,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        style = TextStyle(fontSize = 20.sp)
                    )
                }

                Button(
                    onClick = { navController.navigate("PERSONALINFO") },
                    modifier = Modifier
                        .size(width = 226.dp, height = 183.dp)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 126.dp)
                ) {
                    Text(
                        text = "Personal Information",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                }

                Button(
                    onClick = { navController.navigate("PARTICIPATIONS") },
                    modifier = Modifier
                        .size(width = 226.dp, height = 107.dp)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 50.dp)
                ) {
                    Text(
                        text = "Participations",
                        textAlign = TextAlign.Center,
                        fontSize = 17.sp
                    )
                }
            }
        }
    }
}