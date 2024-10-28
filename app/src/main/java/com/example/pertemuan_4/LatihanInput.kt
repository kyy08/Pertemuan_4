package com.example.pertemuan_4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.NavigableMap

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var nama  by remember { mutableStateOf("") }
    var email  by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki-Laki","Perempuan")
    
    var confNama  by remember { mutableStateOf("") }
    var confEmail  by remember { mutableStateOf("") }
    var confAlamat by remember { mutableStateOf("") }
    var confNotelepon by remember { mutableStateOf("") }
    var confGender by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "nama")
            },
            placeholder = {
                Text(text = "isi nama anda")
            },
            modifier= Modifier.fillMaxWidth().padding(5.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            dataGender.forEach{selectedGender->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {gender = selectedGender}
                    )
                    Text(text = selectedGender)}

            }
        }
        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "email")
            },
            placeholder = {
                Text(text = "isi email anda")
            },
            modifier= Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "alamat")
            },
            placeholder = {
                Text(text = "isi alamat anda")
            },
            modifier= Modifier.fillMaxWidth().padding(5.dp)
        )
        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "no telepon")
            },
            placeholder = {
                Text(text = "isi notelepon anda")
            },
            modifier= Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            confNama = nama
            confEmail = email
            confAlamat = alamat
            confNotelepon = notelepon
            confGender = gender
        }) {
            Text(text = "Simpan")
        }
        TampilData(
            Param = "Nama",
            Argu = confNama
        )
        TampilData(
            Param = "Email",
            Argu = confEmail
        )
        TampilData(
            Param = "Alamat",
            Argu = confAlamat
        )
        TampilData(
            Param = "No Telepon",
            Argu = confNotelepon
        )
        TampilData(
            Param = "Gender",
            Argu = confGender
        )

    }
}

@Composable
fun TampilData(Param : String, Argu : String){
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = Param, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = Argu, modifier = Modifier.weight(2f))
        }
    }
}