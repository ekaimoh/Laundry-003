package com.example.morningmobileappmvvm.ui.theme.screens.clients


import android.net.Uri
import android.view.Menu
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.font.FontFamily
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

import com.example.laundryapp.navigation.ROUTE_ADD_CLIENT
import com.example.laundryapp.navigation.ROUTE_LOGIN
import com.example.laundryapp.navigation.ROUTE_MENU
import com.example.laundryapp.navigation.ROUTE_REGISTER
import com.example.laundryapp.navigation.ROUTE_VIEW_CLIENT


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavController)
{

    val imageUri = rememberSaveable() {
        mutableStateOf<Uri?>(null)
    }

    Scaffold (
        bottomBar = {
            BottomAppBar (
                actions = {
                    IconButton(onClick = { navController.navigate(ROUTE_MENU) }) {
                        Icon(Icons.Filled.Home,
                            tint = Color.Cyan,
                            contentDescription ="Home Icon" )
                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    IconButton(onClick = { navController.navigate(ROUTE_VIEW_CLIENT) }) {
                        Icon(Icons.Filled.Email,
                            tint = Color.Cyan,
                            contentDescription = "Profile Icon")
                    }

                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { ROUTE_LOGIN },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()) {
                        Icon(Icons.Filled.Add,
                            tint = Color.Cyan,
                            contentDescription ="Home" )
                    }
                }
            )




        }
    ){InnerPadding ->
        Box (){
            Image(painter = painterResource(id = R.drawable.eberhardgross),
                contentDescription ="",
                contentScale = ContentScale.FillBounds)
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(InnerPadding),
            horizontalAlignment = Alignment
                .CenterHorizontally
        ){
            TopAppBar(
                title = {
                    Text(text = "Laundry Dashboard",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 65.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = Color.Blue) },
                navigationIcon = {

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color.Blue,
                    navigationIconContentColor = Color.Red
                ),
                actions = {
                }
            )
            Row(
                modifier = Modifier.wrapContentWidth()
            ){
                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(90.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "mind")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(15.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "LAUNDRY ATTENDANT")
                        }
                    }

                }

                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(90.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "LAUNDRY CLEANER")
                        }
                    }

                }
            }
            Row(
                modifier = Modifier.wrapContentWidth()
            ){
                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(85.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(15.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "LAUNDRY TECHNICIAN")
                        }
                    }

                }

                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(85.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(15.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "DELIVERY DRIVER")
                        }
                    }

                }
            }
            Row(
                modifier = Modifier.wrapContentWidth()
            ){
                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(85.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(15.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "IRONING SPECIALIST")
                        }
                    }

                }

                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(90.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(15.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "LAUNDRY CLEANER")
                        }
                    }

                }
            }
            Row(
                modifier = Modifier.wrapContentWidth()
            ){
                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(85.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(15.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 23.sp,
                                text = "DRY CLEANER")
                        }
                    }

                }

                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(85.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "SALES ASSOCIATE")
                        }
                    }

                }
            }
            Row(
                modifier = Modifier.wrapContentWidth()
            ){
                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(85.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(15.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "LAUNDRY ATTENDANT")
                        }
                    }

                }

                Card (
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(ROUTE_ADD_CLIENT)
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ){
                    Box (
                        modifier = Modifier.height(85.dp)
                    ){
                        Image(painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "wallpaper")
                        Box (
                            modifier = Modifier
                                .matchParentSize()
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(color = Color.Green,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                text = "LAUNDRY MANAGER")
                        }
                    }

                }
            }
//
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuPreview(){
    Menu(rememberNavController())
}