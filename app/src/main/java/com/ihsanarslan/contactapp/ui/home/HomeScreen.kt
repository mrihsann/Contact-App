package com.ihsanarslan.contactapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ihsanarslan.contactapp.R
import com.ihsanarslan.contactapp.model.Contact
import com.ihsanarslan.contactapp.navigation.Screen
import com.ihsanarslan.contactapp.ui.home.components.CustomSearchBar
import com.ihsanarslan.contactapp.ui.home.components.LazyRowComponent


@Composable
fun HomeScreen(navController: NavController) {

    var searchText = remember { mutableStateOf("") }

    val kisiListe = listOf(
        Contact(
            image = "",
            name = "İhsan",
            surname = "Arslan",
            email = "ihsan.arslan@gmail.com"
        ),
        Contact(
            image = "",
            name = "Ayşe",
            surname = "Yılmaz",
            email = "ayse.yilmaz@hotmail.com"
        ),
        Contact(
            image = "",
            name = "Mehmet",
            surname = "Kaya",
            email = "mehmetkaya@outlook.com"
        ),
        Contact(
            image = "",
            name = "Zeynep",
            surname = "Demir",
            email = "z.demir@company.com"
        ),
        Contact(
            image = "",
            name = "Can",
            surname = "Öztürk",
            email = "can.ozturk@gmail.com"
        ),
        Contact(
            image = "",
            name = "Elif",
            surname = "Çelik",
            email = "elif.celik@yahoo.com"
        ),
        Contact(
            image = "",
            name = "Burak",
            surname = "Şahin",
            email = "buraksahin@gmail.com"
        ),
        Contact(
            image = "",
            name = "Selin",
            surname = "Yıldız",
            email = "selinyildiz@company.com"
        ),
        Contact(
            image = "",
            name = "Emre",
            surname = "Aydın",
            email = "emre.aydin@outlook.com"
        ),
        Contact(
            image = "",
            name = "Deniz",
            surname = "Koç",
            email = "deniz.koc@gmail.com"
        )
    )
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Contacts",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomSearchBar(searchText = searchText)
                Spacer(modifier = Modifier.height(16.dp))
                Text(modifier = Modifier.padding(start = 15.dp),text = "Recent Added", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                LazyRowComponent(kisiList = kisiListe)
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = "My Contacts (${kisiListe.size})",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(kisiListe.size) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        if (kisiListe[it].image.isEmpty()) {
                            Text(
                                text = "${kisiListe[it].name.first()}${kisiListe[it].surname.first()}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        } else {
                            Image(
                                painter = painterResource(R.drawable.ic_launcher_background),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "${kisiListe[it].name} ${kisiListe[it].surname}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = kisiListe[it].email,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onClick = { navController.navigate(Screen.Detail) },
            containerColor = Color(0xFFFF5722),
            contentColor = Color.White,
            shape = RoundedCornerShape(25.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
        }
    }
}
