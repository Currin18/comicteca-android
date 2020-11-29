package com.jesusmoreira.comicteca.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun LogInScreen(
        userName: String = "",
        password: String = "",
        onClick: (userName: String, password: String) -> Unit = {_, _ -> }
) {
//    Surface() {
        Column(
                Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
        ) {
            LogIn(userName = userName, password = password, onClick = onClick)
        }
//    }
}

@Composable
fun LogIn(
        modifier: Modifier = Modifier,
        userName: String = "",
        password: String = "",
        onClick: (userName: String, password: String) -> Unit = {_, _ -> }
){

    val spacer = 16.dp
    var user by remember { mutableStateOf(TextFieldValue(userName)) }
    var pass by remember { mutableStateOf(TextFieldValue(password)) }

    Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
    ) {
        OutlinedTextField(
            value = user,
            label = { Text("User") },
            onValueChange = { user = it }
        )

        Spacer(Modifier.preferredSize(spacer))

        OutlinedTextField(
            value = pass,
            label = { Text("Password") },
            onValueChange = { pass = it }
        )

        Spacer(Modifier.preferredSize(spacer))

        Button(onClick = {
            onClick(user.text, pass.text)
        }) {
            Text(text = "LogIn")
        }
    }

}

@Preview
@Composable
fun LogInPreview() {
    LogIn()
}

@Preview
@Composable
fun LogInScreenPreview() {
    LogInScreen()
}
