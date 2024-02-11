package com.example.sportsunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController,modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .background(color = Color.Black)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.image_3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.background(color = Color.White)
        )
        Card(
            modifier = Modifier.padding(16.dp)
        ) {
            var email by remember  {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            CreateTextField(
                label = "Enter your email",
                keyboardType = KeyboardType.Text,
                imeaction = ImeAction.Next,
                icon = Icons.Filled.Email
            )
//            TextField(
//                value = email,
//                onValueChange = {email = it},
//                label = {
//                    Text(text = "Enter your email")
//                },
//                keyboardOptions = KeyboardOptions(
//                    keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.Next
//                ),
//                modifier = Modifier.padding(10.dp)
//            )

            CreateTextField(
                label = "Enter your password",
                keyboardType = KeyboardType.Password,
                imeaction = ImeAction.Go,
                icon = Icons.Filled.Lock
            )
//            TextField(
//                value = password,
//                onValueChange = {password = it},
//                label = {
//                    Text(text = "Enter your password")
//                },
//                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
//            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)

            ) {
                Text(text = "log in")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Don't have an account?",
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatedTextField(
    label: String,
    keyboardType: KeyboardType,
    imeaction:ImeAction,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier// Add border to TextField
            .fillMaxWidth()
            .padding(5.dp),
        value = text,
        onValueChange = { text = it },
        label = {
            Text(text = label)

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeaction
        ),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = icon, contentDescription = null)
            }
        },
        shape = RoundedCornerShape(30),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF87CEEB),
            focusedLabelColor = Color.Gray,
            cursorColor = Color.White,
            containerColor = Color.Transparent

        )
    )
}