package com.example.sportsunity

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.annotation.Size
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTournament(navController: NavController,viewModel: SharedViewModel, modifier: Modifier=Modifier){
    Scaffold(
        topBar = {
//            TopBarCreateTournament(navController)
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = viewModel.getTopBar(),
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
            myContentCreateTournament(navController,innerpadding)
        }
    )
}
//@Composable
//fun TopBarCreateTournament(navController: NavController,modifier: Modifier = Modifier){
//    Column {
//        Row(
//            horizontalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .background(Color.Black)
//                .fillMaxWidth()
//        ) {
//            Text(
//                text = stringResource(id = R.string.create_tournament),
//                color = Color.White,
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.headlineLarge,
//            )
//        }
//        Image(
//            painter = painterResource(id = R.drawable.blue_line),
//            contentDescription = "Blue Line",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .height(2.dp)
//                .fillMaxWidth()
//        )
//    }
//}
@SuppressLint("UnrememberedMutableState")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myContentCreateTournament(navController: NavController, innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var sports by rememberSaveable {
                mutableStateOf("")
            }
            var volunteer by rememberSaveable {
                mutableStateOf("")
            }
            var start_date by rememberSaveable {
                mutableStateOf(LocalDate.now())
            }
            var end_date by rememberSaveable {
                mutableStateOf(LocalDate.now())
            }
            var expanded by rememberSaveable {
                mutableStateOf(false)
            }
            val list = listOf("CHESS","LUDO","CARROM","FOOTBALL")
            var selectedItem by rememberSaveable {
                mutableStateOf("")
            }
            val textFieldSize by remember {
                mutableStateOf(androidx.compose.ui.geometry.Size.Zero)
            }
            val icon = if(expanded){
                Icons.Filled.KeyboardArrowUp
            }
            else {
                Icons.Filled.KeyboardArrowDown
            }

            val formattedStartDate by remember {
                derivedStateOf {
                    DateTimeFormatter
                        .ofPattern("dd-MM-yyyy")
                        .format(start_date)
                }
            }
            val formattedEndDate by remember {
                derivedStateOf {
                    DateTimeFormatter
                        .ofPattern("dd-MM-yyyy")
                        .format(end_date)
                }
            }
            val dateDialogState = rememberMaterialDialogState()

            Image(
                painter = painterResource(id = R.drawable.image_5),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = .8f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(top = 60.dp)
            )
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "banner", tint = Color.White)
//            }


            CreateTextFieldTournament(
                label = "Set Tournament Name",
                keyboardType = KeyboardType.Text,
                imeaction = ImeAction.Next
            )
            CreateTextFieldTournament(
                label = "Short Description",
                keyboardType = KeyboardType.Text,
                imeaction = ImeAction.Next
            )
            OutlinedTextField(
                modifier = Modifier// Add border to TextField
                    .fillMaxWidth()
                    .padding(5.dp),
//            .height(50.dp),
                value = selectedItem,
                onValueChange = { sports = it },
                label = {
                    Text(text = "Select Sports Type")

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(30),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color(0xFF87CEEB),
                    focusedLabelColor = Color.Gray,
                    cursorColor = Color.White,
                    containerColor = Color.Black

                ),
                trailingIcon = {
                    Row(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        IconButton(
                            onClick = { expanded = !expanded }
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = "Drop Down",
                                tint = Color.Gray // Customize the color of the icon
                            )
                        }
                        IconButton(
                            onClick = { sports = "" }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                tint = Color.Gray // Customize the color of the icon
                            )
                        }
                    }
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                list.forEach{
                    label ->
                    DropdownMenuItem(text = {
                        Text(text = label)
                    },onClick = {
                        selectedItem = label
                        expanded = false
                    },
//                    modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})

                    )
                }
            }

//            CreateTextFieldTournament(
//                label = "Add Sports Type",
//                keyboardType = KeyboardType.Text,
//                imeaction = ImeAction.Next
//            )
//            CreateTextFieldTournament(
//                label = "Volunteers",
//                keyboardType = KeyboardType.Text,
//                imeaction = ImeAction.Next
//            )
            OutlinedTextField(
                modifier = Modifier// Add border to TextField
                    .fillMaxWidth()
                    .padding(5.dp),
//            .height(50.dp),
                value = volunteer,
                onValueChange = { volunteer = it },
                label = {
                    Text(text = "Volunteer")

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(30),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color(0xFF87CEEB),
                    focusedLabelColor = Color.Gray,
                    cursorColor = Color.White,
                    containerColor = Color.Black

                ),
                trailingIcon = {
                    Box(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        IconButton(
                            onClick = { volunteer = "" }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                tint = Color.Gray // Customize the color of the icon
                            )
                        }
                    }
                }
            )
//            CreateTextFieldTournament(
//                label = "Add Volunteers",
//                keyboardType = KeyboardType.Text,
//                imeaction = ImeAction.Next
//            )
//            CreateTextFieldTournament(
//                label = "Start Date",
//                keyboardType = KeyboardType.Number,
//                imeaction = ImeAction.Next
//            )
            var clickingfrom = 0;
            OutlinedTextField(
                modifier = Modifier// Add border to TextField
                    .fillMaxWidth()
                    .padding(5.dp),
//            .height(50.dp),
                value = formattedStartDate,
                onValueChange = { volunteer = it },
                label = {
                    Text(text = "Start Date")

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(30),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color(0xFF87CEEB),
                    focusedLabelColor = Color.Gray,
                    cursorColor = Color.White,
                    containerColor = Color.Black

                ),
                trailingIcon = {
                    Box(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        IconButton(
                            onClick = {
                                clickingfrom = 1;
                                dateDialogState.show()
                            }

                        ) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Add",
                                tint = Color.Gray // Customize the color of the icon
                            )
                        }
                    }
                }
            )
//            CreateTextFieldTournament(
//                label = "End Date",
//                keyboardType = KeyboardType.Number,
//                imeaction = ImeAction.Next
//            )
            OutlinedTextField(
                modifier = Modifier// Add border to TextField
                    .fillMaxWidth()
                    .padding(5.dp),
//            .height(50.dp),
                value = formattedEndDate,
                onValueChange = { volunteer = it },
                label = {
                    Text(text = "End Date")

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(30),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color(0xFF87CEEB),
                    focusedLabelColor = Color.Gray,
                    cursorColor = Color.White,
                    containerColor = Color.Black

                ),
                trailingIcon = {
                    Box(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        IconButton(
                            onClick = {
                                clickingfrom = 2
                                dateDialogState.show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Add",
                                tint = Color.Gray // Customize the color of the icon
                            )
                        }
                    }
                }
            )
            MaterialDialog(
                dialogState = dateDialogState,
                buttons = {
                    positiveButton(
                        text = "OK"
                    )
                    negativeButton(
                        text = "Cancel"
                    )
                }
            ) {
                datepicker(
                    initialDate = LocalDate.now(),
                    title = "Pick a date",
                    colors = DatePickerDefaults.colors(colorResource(id = R.color.maastricht_Blue))
                ){
                    if(clickingfrom==1){
                        start_date = it
                    }
                    else if(clickingfrom==2){
                        end_date = it
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = { navController.navigate("MYTOURNAMENTS") }) {
                Text(
                    text = "CREATE"
                )
            }

        }
    }
    
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTextFieldTournament(
    label: String,
    keyboardType: KeyboardType,
    imeaction:ImeAction,
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier// Add border to TextField
            .fillMaxWidth()
            .padding(5.dp),
//            .height(50.dp),
        value = text,
        onValueChange = { text = it },
        label = {
            Text(text = label)

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeaction
        ),
        shape = RoundedCornerShape(30),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            focusedBorderColor = Color(0xFF87CEEB),
            focusedLabelColor = Color.Gray,
            cursorColor = Color.White,
            containerColor = Color.Black

        )
    )
}