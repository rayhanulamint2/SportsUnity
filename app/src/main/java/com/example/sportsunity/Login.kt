package com.example.sportsunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun Login(navController: NavHostController,modifier: Modifier = Modifier) {
    Box (modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_3),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
//            Image(
//                painter = painterResource(id = R.drawable.sportsunity),
//                contentDescription = null,
//                modifier = Modifier.fillMaxSize()
//            )
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
            Box(
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle_7),
                    contentDescription = "background",
                    contentScale = ContentScale.Crop,
                    alpha = .4f,
                    modifier = Modifier.width(410.dp)
                )
                Column() {
                    var email by remember {
                        mutableStateOf("")
                    }
                    var password by remember {
                        mutableStateOf("")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    CreateTextField(
                        label = "Enter your email",
                        keyboardType = KeyboardType.Text,
                        imeaction = ImeAction.Next,
                        icon = Icons.Filled.Email
                    )
                    CreateTextField(
                        label = "Enter your password",
                        keyboardType = KeyboardType.Password,
                        imeaction = ImeAction.Go,
                        icon = Icons.Filled.Lock
                    )
                    Button(
                        onClick = { navController.navigate("HOME") },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp)

                    ) {
                        Text(text = "log in")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Don't have an account?",
                        color = Color.White,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Button(
                        onClick = { navController.navigate("SIGNUP") },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp)

                    ) {
                        Text(text = "Sign up")

                    }
                }
            }
        }
    }
}
