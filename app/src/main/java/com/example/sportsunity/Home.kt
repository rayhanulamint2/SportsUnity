package com.example.sportsunity

import android.content.ContentValues
import android.media.Image
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.model.TournamentID
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController,viewModel: SharedViewModel,modifier: Modifier = Modifier) {
    val paddingValues = 10.dp

//    android:theme="@style/Theme.SportsUnity"
    val drawerstate  = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var abhishek by remember {
        mutableStateOf(1)
    }
    ModalNavigationDrawer(
        drawerState = drawerstate,
        drawerContent = {
            ModalDrawerSheet {
                IconButton(onClick = {
                    scope.launch {
                        drawerstate.close()
                    }
                }) {
//                    androidx.compose.material3.Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Drawer Back")
                    Image(
                        painter = painterResource(id = R.drawable.back_button),
                        contentDescription = "back button",
                        modifier
                            .height(50.dp)
                            .width(50.dp)
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment  = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_1),
                        contentDescription = "profile photo",
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                    )
                    Text(
                        text = "Khalid Bin Selim",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "My Profile") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerstate.close() }
                        navController.navigate("MYPROFILE")
                    }
                )
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "My Tournaments") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerstate.close() }
                        navController.navigate("MYTOURNAMENTS")
                    }
                )
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Create Tournament") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerstate.close() }
                        navController.navigate("CREATETOURNAMENT")
                    }
                )
                Divider()
                Spacer(modifier = modifier.height(230.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Help") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Log Out") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerstate.close() }
                        navController.navigate("LOGIN")
                    }
                )
                Divider()
            }
        },
        gesturesEnabled = false
    ) {
        Scaffold(
            topBar = {
//            TopBar(navController)
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
                                scope.launch { drawerstate.open()}
                            }) {
                                //                                 Icon(
                                //                                     imageVector = Icons.Default.Menu,
                                //                                     contentDescription = null,
                                //                                     tint = Color.White
                                //                                 )
                                Image(
                                    painter = painterResource(id = R.drawable.menu_1),
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
            content = { innerpadding ->
                val formattedLocalDate by remember {
                    derivedStateOf {
                        DateTimeFormatter
                            .ofPattern("yyyy-MM-dd")
                            .format(LocalDate.now())
                    }
                }
                viewModel.today = formattedLocalDate
                if (abhishek==2) {
                    myContent(navController, innerpadding)
                } else if(abhishek == 3){
                    myContentRunningTournament(
                        navController = navController,
                        viewModel = viewModel,
                        innerpadding = innerpadding
                    )
                }
                else{
                    loading()
                    LaunchedEffect(Unit) {
                        viewModel.findTournamentsDetails(viewModel.today, viewModel)
                        if(viewModel.runningTournaments.size!=0)abhishek = 3
                        else abhishek = 2
                    }
                }
            }
        )
    }
}


@Composable
fun loading(){
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
                        .width(380.dp),
                    alignment = Alignment.Center
                )
                Text(
                    text = "loading",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    style = TextStyle(fontSize = 30.sp)
                )
            }
        }
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
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                ){
                    var text = ""
                    Box(modifier = Modifier
                        .fillMaxWidth(.8f)
                        .padding(bottom = 20.dp)){
                        Image(
                            painter = painterResource(id = R.drawable.rectangle_60),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                        )
                        Text(
                            text = "Running Tournaments",
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
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

@Composable
fun myContentRunningTournament(navController: NavController,viewModel: SharedViewModel,innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
//        Log.d("nothing","${viewModel.runningTournaments}")
//        viewModel.runningTournaments?.let { RunningTournamentList(navController = navController,runningtournamentList = it) }
        RunningTournamentList(navController = navController, viewModel = viewModel,runningtournamentList = viewModel.runningTournaments)
    }
}

@Composable
fun RunningTournamentList(navController: NavController,viewModel: SharedViewModel,runningtournamentList: List<TournamentID>,modifier: Modifier = Modifier){
    Log.d("running","$runningtournamentList")
    LazyColumn(modifier = modifier.padding(top = 50.dp)){
        items(runningtournamentList){ runningtournament ->
            Log.d("running1","$runningtournament")
            RunningTournamentCard(
                navController = navController,
                runningtournament = runningtournament,
                viewModel = viewModel,
                modifier = Modifier.padding(8.dp)
                )
        }
    }
}
@Composable
fun RunningTournamentCard(navController: NavController,runningtournament: TournamentID,viewModel: SharedViewModel,modifier:Modifier = Modifier){
    Card(
        modifier = modifier.clickable {
            viewModel.tournamentId = runningtournament.tournamentId
            navController.navigate("SPORTSLISTFORORGANAIZER")
        },
        colors = CardDefaults.cardColors(containerColor = Color.Black)

        ){


//        Box(modifier = modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.image_6),
                contentDescription = runningtournament.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
        Log.d("running3","$runningtournament")
        runningtournament.name?.let {
            Text(
                text = it,
    //                LocalContext.current.getString(runningtournament.stringResourceId),
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 10.dp, start = 16.dp),
                //                style = MaterialTheme.typography.headlineSmall
            )
        }

//        }
            Spacer(modifier = Modifier.height(15.dp))
        runningtournament.description?.let {
            Text(
                text = it,
    //                LocalContext.current.getString(runningtournament.stringResourceId2),
                color = Color.White,
                fontSize = 10.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        }

}
