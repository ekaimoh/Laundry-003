package com.example.laundryapp.ui.theme.Screens.Confirm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.laundryapp.R
import com.example.laundryapp.data.AuthViewModel
import com.example.laundryapp.navigation.ROUTE_MENU

@Composable
fun Login( navController: NavController) {
    Box (){
        Image(painter = painterResource(id = R.drawable.eberhardgross
        ),
            contentDescription ="dashboard background",
            contentScale = ContentScale.FillBounds)
    }
    var email by remember { mutableStateOf(value = "")
    }


    var password by remember {
        mutableStateOf(value = "")
    }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center

    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "LOGIN YOUR DETAILS",
            fontSize = 30.sp,
            color = Color.Green,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(20.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(300.dp))
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter email") },
            value = email,
            onValueChange ={
                    newName -> email = newName
            } )


        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter Password") },
            value = password,
            onValueChange ={
                    newPassword-> password =newPassword
            } )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val login = AuthViewModel(navController,context)
                login.login(email.trim(),password.trim())
                navController.navigate(ROUTE_MENU)

            },
            colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(modifier = Modifier.padding(5.dp),
                text = "LOGIN")
        }


        }

    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview(){
    Login(rememberNavController())}