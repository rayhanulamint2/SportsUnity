package com.example.sportsunity

import android.provider.ContactsContract
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(mainActivityCallback: MainActivityCallback,navController: NavHostController, modifier: Modifier = Modifier) {
    Box (modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse_1),
                contentDescription = null,
//                modifier = Modifier.size(96.dp),
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier.padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                //            Image(
                //                painter = painterResource(id = R.drawable.rectangle_7),
                //                contentDescription = null,
                //                contentScale = ContentScale.Crop,
                //                alpha = .7f,
                //                modifier = Modifier
                //                    .border(2.dp, androidx.compose.ui.graphics.Color.Blue)
                //                    .fillMaxSize()
                //            )
                Column(modifier = Modifier.padding(10.dp)) {
                    var name by rememberSaveable {
                        mutableStateOf("")
                    }
                    var university by rememberSaveable {
                        mutableStateOf("")
                    }
                    var email by rememberSaveable {
                        mutableStateOf("")
                    }
                    var mobile by rememberSaveable {
                        mutableStateOf("")
                    }
                    var password by rememberSaveable {
                        mutableStateOf("")
                    }
                    name = CreateTextField(
                        stringResource(id = R.string.your_name), KeyboardType.Text, ImeAction.Next,
                        Icons.Filled.Person
                    )
                    university = CreateTextField(
                        stringResource(id = R.string.your_university),
                        KeyboardType.Text,
                        ImeAction.Next,
                        Icons.Filled.Home
                    )
                    email = CreateTextField(
                        stringResource(id = R.string.your_email),
                        KeyboardType.Email,
                        ImeAction.Next,
                        icon = Icons.Filled.Email
                    )

                    mobile = CreateTextField(
                        stringResource(id = R.string.your_mobile),
                        KeyboardType.Number,
                        ImeAction.Next,
                        Icons.Filled.Phone
                    )
                    password = CreateTextField(
                        stringResource(id = R.string.password_set),
                        KeyboardType.Password,
                        ImeAction.Go,
                        Icons.Filled.Lock
                    )
                    Log.d("my name ",name)
                    Log.d("my university ",university)
                    Log.d("my number ",mobile)

                    Button(
                        onClick = {
                            mainActivityCallback.createAccount(email = email,password = password)
                            navController.navigate("AFTERSIGNUP")
                                  },
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally) // Center the button horizontally
                    ) {
                        Text(text = "Sign Up")
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Already have an account?",
                        textAlign = TextAlign.Center,
                        color = androidx.compose.ui.graphics.Color.White,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        onClick = { navController.navigate("LOGIN") },
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Log In")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTextField(
    label: String,
    keyboardType: KeyboardType,
    imeaction:ImeAction,
    icon:ImageVector,
    modifier: Modifier = Modifier
): String {
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
            textColor = androidx.compose.ui.graphics.Color.Black,
            focusedBorderColor = androidx.compose.ui.graphics.Color(0xFF87CEEB),
            focusedLabelColor = androidx.compose.ui.graphics.Color.Gray,
            cursorColor = androidx.compose.ui.graphics.Color.Black,
            containerColor = androidx.compose.ui.graphics.Color.White

        )
    )
    return text
}

@Preview(showSystemUi = true)
@Composable
fun SignUp_preview(){
//    SignUp()
}
