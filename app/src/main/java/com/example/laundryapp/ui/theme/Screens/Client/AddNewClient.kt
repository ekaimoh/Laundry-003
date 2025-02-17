package com.example.morningmobileappmvvm.ui.theme.screens.clients


import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.laundryapp.R
import com.example.laundryapp.data.ClientViewModel
import com.example.laundryapp.navigation.ROUTE_REGISTER
import com.example.laundryapp.navigation.ROUTE_VIEW_CLIENT


@Composable
fun AddClient(navController: NavController){
    val imageUri = rememberSaveable() {
        mutableStateOf<Uri?>(null)
    }
    val painter = rememberImagePainter(
        data = imageUri.value ?: R.drawable.person,
        builder = {
            crossfade(true)
        }
    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri.value = it }
    }

    var fullNames by remember {
        mutableStateOf(value = "")
    }
    var YourJob by remember {
        mutableStateOf(value = "")
    }
    var gender by remember {
        mutableStateOf(value = "")
    }
    var age by remember {
        mutableStateOf(value = "")
    }
    var bio by remember {
        mutableStateOf(value = "")
    }
    Scaffold (
    ){innerPadding ->
        Box (){
            Image(painter = painterResource(id = R.drawable.watch),
                contentDescription ="",
                contentScale = ContentScale.FillBounds)}
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
                .fillMaxWidth()
        ){
            Text(text = "MAKE YOUR APPLICATION",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.Transparent),
                color = Color.Red)
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(onClick = { ROUTE_REGISTER }) {
                    Text(text = "GO BACK",)
                }
                val context = LocalContext.current
                Button(onClick = {
                    val clientRepository = ClientViewModel(navController, context)

                    if (imageUri.value != null) {
                        clientRepository.saveClient(
                            filePath = imageUri.value!!,
                            fullNames = fullNames,
                            YourJob = YourJob,
                            gender = gender,
                            age = age,
                            bio = bio
                        )
                        navController.navigate(ROUTE_VIEW_CLIENT) // Navigate only after saving
                    } else {
                        Toast.makeText(context, "Please select an image", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text(text = "SAVE")
                }

            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card (
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(180.dp)
                ){
                    Image(painter = painter ,
                        contentDescription = null,
                        modifier = Modifier
                            .size(180.dp)
                            .clickable { launcher.launch("image/*") },
                        contentScale = ContentScale.Crop)
                }
                Text(text = "Change Picture Here")
            }
            OutlinedTextField(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter Full Names")},

                value = fullNames,
                onValueChange = {
                        newName -> fullNames = newName
                })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter Your Job")},
                value = YourJob,
                onValueChange = {
                        newName -> YourJob = newName
                })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter your Gender")},
                value = gender,
                onValueChange = {
                        newName -> gender = newName
                })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter your Age")},
                value = age,
                onValueChange = {
                        newName -> age = newName
                })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .height(160.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter description")},
                value = bio,
                singleLine = false,
                onValueChange = {
                        newName -> bio = newName
                })

        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddClientPreview(){
    AddClient(rememberNavController())
}