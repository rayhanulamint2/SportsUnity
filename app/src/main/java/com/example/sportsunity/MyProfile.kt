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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
            var tanvir by rememberSaveable {
                mutableStateOf(1)
            }
            if(tanvir==2){
                myContentMyProfile(navController, viewModel = viewModel,innerpadding)
            }
            else{
                loading()
                LaunchedEffect(Unit){
                    viewModel.userDetails.email?.let { viewModel.userDetails.password?.let { it1 -> viewModel.findUserDetails(email = it, password = it1) } }
                    tanvir = 2
                }
            }

        }
    )
}




@Composable
fun myContentMyProfile(navController: NavController, viewModel: SharedViewModel,innerpadding: PaddingValues){
    var showPopup by rememberSaveable { mutableStateOf(false) }
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

                Column(
                ) {
                    var k = viewModel.userDetails.isSubscribed
                    // we accept bdapps api
                    if(k!=viewModel.subscriptionStatus){
                        k = viewModel.subscriptionStatus
                        viewModel.userDetails.isSubscribed = k
                        viewModel.updateSubscriptionDetails()
                    }
                    viewModel.userDetails.name?.let {
                        Text(
                            text = it,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp, bottom = 10.dp, start = 24.dp, end = 24.dp),
                            style = TextStyle(fontSize = 20.sp)
                        )
                    }
                    Text(
                        text = if (k == false) {
                            "not subscribed"
                        }
                        else {
                            "subscribed"
                        },
                        color = if(k == false){
                            Color.White
                        }
                        else{
                            Color.Green
                            },
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showPopup = true }
                            .padding(top = 5.dp, start = 24.dp, bottom = 24.dp, end = 24.dp),
                        style = TextStyle(fontSize = 15.sp)
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
    if (showPopup) { // Check if popup should be shown
        AlertDialog(
            onDismissRequest = { showPopup = false }, // Dismiss the popup when clicked outside
            title = {
                Text(text = "Confirm") // Title of the popup
            },
            text = {
                if(viewModel.subscriptionStatus){
                    Text("You are going to unsubscribe.") // Message of the popup
                }
                else{
                    Text(text = "You are going to subscribe.")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showPopup = false
                        if(viewModel.subscriptionStatus){
                            viewModel.subscriptionOff()
                            viewModel.subscriptionStatus = false
                            viewModel.updateSubscriptionDetails()
                        }
                        else{
                            viewModel.subscriptionOn()
                            viewModel.subscriptionStatus = true
                            viewModel.updateSubscriptionDetails()
                            navController.navigate("HOME")
                        }
                    } // Dismiss the popup when button is clicked
                ) {
                    Text("Submit") // Text on the button
                }
            }
        )
    }
}