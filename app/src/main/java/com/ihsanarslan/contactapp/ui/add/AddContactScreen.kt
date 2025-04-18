package com.ihsanarslan.contactapp.ui.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ihsanarslan.contactapp.R
import com.ihsanarslan.contactapp.data.local.ContactEntity
import com.ihsanarslan.contactapp.ui.home.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(navController: NavController){

    val viewModel = hiltViewModel<HomeScreenViewModel>()

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }

    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { Text("Add Contact") },
            navigationIcon = {
                IconButton(onClick = {navController.navigateUp()}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
        )
    }){
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "")
            Spacer(Modifier.padding(80.dp))
            TextField(modifier = Modifier.fillMaxWidth(),value = name, onValueChange = { name = it}, label = { Text("Name") })
            Spacer(Modifier.padding(15.dp))
            TextField(modifier = Modifier.fillMaxWidth(),value = surname, onValueChange = {surname=it}, label = { Text("Surname") })
            Spacer(Modifier.padding(15.dp))
            TextField(modifier = Modifier.fillMaxWidth(),value = email, onValueChange = {email=it}, label = { Text("Email") })
            Button(
                onClick = {
                    val contact = ContactEntity(
                        name = name,
                        surname = surname,
                        email = email,
                        phone = "68461",
                        image = image
                    )
                    viewModel.insert(contact = contact)
                }
            ) {
                Text("Ekle")
            }
        }
    }
}


@Preview
@Composable
fun AddContactScreenPreview(){
    AddContactScreen(rememberNavController())
}