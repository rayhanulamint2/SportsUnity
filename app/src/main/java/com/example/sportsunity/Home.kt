package com.example.sportsunity

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController,modifier: Modifier = Modifier) {
    val paddingValues = 10.dp
    Scaffold(
        topBar = { TopBar(navController) },
        content = {innerpadding->
            myContent(navController,innerpadding)
        }
    )

}

@Composable
fun TopBar(navController: NavController,modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
    ){
        Text(
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myContent(navController: NavController,innerpadding: PaddingValues) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.rectangle_13),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(380.dp),
                    alignment = Alignment.Center
                )
                Column(modifier = Modifier.align(Alignment.Center)){
                    var text = ""
                    TextField(
                        value = text,
                        shape = RoundedCornerShape(30),
                        label = {
                                Text(
                                    text = "RUNNING TOURNAMENTS",
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontSize = 21.sp
                                )
                        },
//                        colors = TextFieldDefaults.textFieldColors(0xFF002434),
//                        placeholder = {
//                            Text(
//                                text = "RUNNING TOURNAMENTS",
//                                textAlign = TextAlign.Center,
//                                color = Color.White,
//                                fontSize = 21.sp
//                            )
//                        },
//                        color = TextFieldDefaults.textFieldColors(0x002434),
                        onValueChange = { text = it },
                        enabled = false,
//                        colors = Color(0xFF001C3D),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .fillMaxWidth()
                            .padding(start = 32.dp, bottom = 40.dp, end = 32.dp)
                            .background(Color(0xFF001C3D))

                    )

                    Text(text = stringResource(id = R.string.no_tournaments),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = { navController.navigate("CREATETOURNAMENT") }) {
                Text(text = " CREATE NEW" + "\nTOURNAMENT",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
