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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.navigation.NavController
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController,modifier: Modifier = Modifier) {
    val paddingValues = 10.dp
    Scaffold(
        topBar = { TopBar(navController) },
        content = {innerpadding->
            myContent(innerpadding)
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
            style = MaterialTheme.typography.headlineLarge,
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myContent(innerpadding: PaddingValues) {
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
                        value = "RUNNING TOURNAMENTS",
                        onValueChange = { text = it },
                        enabled = false,
                        shape = RoundedCornerShape(30),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .fillMaxWidth()

                    )
                    Text(text = stringResource(id = R.string.no_tournaments),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = " CREATE NEW" + "\nTOURNAMENT",
                    textAlign = TextAlign.Center
                    )
            }
        }
    }
}
