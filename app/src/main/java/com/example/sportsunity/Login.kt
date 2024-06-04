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
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.twotone.Warning
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sportsunity.SharedViewModel.SharedViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(mainActivityCallback: MainActivityCallback,viewModel: SharedViewModel,navController: NavHostController,modifier: Modifier = Modifier) {
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
                    var selected by rememberSaveable {
                        mutableStateOf(false)
                    }
                    var icon = if(selected){
                        painterResource(id = R.drawable.baseline_visibility_off_24)
                    }
                    else {
                        painterResource(id = R.drawable.baseline_visibility_24)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    email = CreateTextField(
                        label = "Enter your email",
                        keyboardType = KeyboardType.Text,
                        imeaction = ImeAction.Next,
                        icon = Icons.Filled.Email
                    )
//                    password = CreateTextField(
//                        label = "Enter your password",
//                        keyboardType = KeyboardType.Password,
//                        imeaction = ImeAction.Go,
//                        icon = Icons.Filled.Lock
//                    )
                    var text by rememberSaveable { mutableStateOf("") }
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(start = 5.dp, end = 5.dp, top = 2.dp, bottom = 2.dp),
                        value = password,
                        onValueChange = { password = it },
                        label = {
                            Text(text = "Enter your password")

                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        leadingIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                            }
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                selected = !selected
                            }) {
                                Icon(
                                    painter = icon,
                                    contentDescription = "visibility"
                                )
                            }
                        },
                        visualTransformation = if(selected)VisualTransformation.None
                        else PasswordVisualTransformation(),
                        shape = RoundedCornerShape(30),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = androidx.compose.ui.graphics.Color.Black,
                            focusedBorderColor = androidx.compose.ui.graphics.Color(0xFF87CEEB),
                            focusedLabelColor = androidx.compose.ui.graphics.Color.Gray,
                            cursorColor = androidx.compose.ui.graphics.Color.Black,
                            containerColor = androidx.compose.ui.graphics.Color.White

                        )
                    )
                    Button(
                        onClick = {
                            viewModel.userEmail = email
                            viewModel.userPassword = password
                            mainActivityCallback.login(email = email,password =  password,navController = navController)
                            viewModel.findUserDetails(email = email,password= password)

                                  },
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
