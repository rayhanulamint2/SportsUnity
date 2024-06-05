package com.example.sportsunity

import  android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.model.OtpVerifyRespone
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Otp(navController: NavController, viewModel: SharedViewModel, modifier: Modifier) {
    var a by remember{
        mutableStateOf(1)
    }
    Scaffold(
        content = {innerpadding->

            if(viewModel.userDetails.contact!=null){
//                viewModel.verifyStatus(navController,innerpadding)
                OTP(navController,viewModel,innerpadding)
            }
//            else{
//                loading()
//                LaunchedEffect(Unit){
//                    Log.d("tanvir123", "${viewModel.userEmail}")
//                    Log.d("tanvir123", "${viewModel.userPassword}")
//
////                    viewModel.findUserDetails(email = viewModel.userEmail,password = viewModel.userPassword)
////                    viewModel.findAllTeams()
////                    viewModel.findAllPlayerId()
////                    viewModel.findAllWinnerList2()
//                    Log.d("tanvir12345", "${viewModel.userDetails}")
//                    if(){
//                        a = 2
//                    }
//
//                }



//            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTP(navController: NavController, viewModel: SharedViewModel, innerpadding: PaddingValues){
    var contact = viewModel.userDetails.contact
    if (contact != null) {
        if(contact.length == 11){
            contact = "88$contact"
        }
        viewModel.requestParameters.mobile = contact
    }
    if(viewModel.otpResend)viewModel.sendOtp(navController)
    viewModel.otpResend = false
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(.9f)
        ) {


            if (contact != null) {
                Text(
                    text = stringResource(id = R.string.otp_string)+"  "+contact.get(2)+contact.get(3)+contact.get(4)+"***"+contact.get(10)+contact.get(11)+contact.get(12),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            var otp by rememberSaveable { mutableStateOf("") }
            Card(
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.background_card))
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    modifier = Modifier// Add border to TextField
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp, top = 2.dp, bottom = 2.dp),
                    value = otp,
                    onValueChange = { otp = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    leadingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painterResource(id = R.drawable.baseline_key_24), contentDescription = null)
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
                Spacer(modifier = Modifier.height(20.dp))
            }
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
//                        viewModel.verifyOtp(otp = otp)

                    viewModel.verifyParameters.otp = otp
//                    viewModel.verifyParameters.referenceNo = "88018668437301717564892306737512"
                    Log.d("MyActivity", "${viewModel.verifyParameters}")
                    val destinationService = ServiceBuilder.buildService(MyApiService::class.java)
                    val requestCall = destinationService.verifyOtp(viewModel.verifyParameters)

                    requestCall.enqueue(object : Callback<OtpVerifyRespone> {
                        override fun onResponse(
                            call: Call<OtpVerifyRespone>,
                            response: Response<OtpVerifyRespone>
                        ) {
                            if (response.isSuccessful) {
                                val apiResponse = response.body()
                                Log.d("MyActivity", "OTP verified successfully: $apiResponse")
                                if (apiResponse != null) {
                                    if(apiResponse.statusDetail=="Success"){
                                        viewModel.subscriptionStatus = true
                                        viewModel.verifyOtpStatus = true
                                        navController.navigate("LOGIN")
                                        Toast.makeText(
                                            navController.context,
                                            "Successfully Log In",
                                            Toast.LENGTH_SHORT,
                                        ).show()

                                    } else{
                                        Toast.makeText(
                                            navController.context,
                                            "${apiResponse.statusDetail}",
                                            Toast.LENGTH_SHORT,
                                        ).show()
                                    }
                                }
                            } else {
                                // Handle unsuccessful response
                                Log.e("MyActivity", "Failed to verify OTP: ${response.errorBody()?.string()}")
                            }
                        }
                        override fun onFailure(call: Call<OtpVerifyRespone>, t: Throwable) {
                            // Handle failure
                            Log.e("MyActivity", "Network error: ${t.message}")
                        }
                    })
                    },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)

            ) {
                Text(text = "Submit")
            }
        }
    }
}




