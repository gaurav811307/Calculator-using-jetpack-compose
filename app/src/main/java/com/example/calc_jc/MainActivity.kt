package com.example.calc_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calc_jc.ui.theme.Calc_JCTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calc_JCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myApp()
                }
            }
        }
    }
}

@Composable
fun myApp() {

    var value1 = remember {
        mutableStateOf("")
    }
    var value2 = remember {
        mutableStateOf("")
    }
    var result = remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)) {
        
        Text(text = "Calculator using Jetpack Compose")
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = value1.value, onValueChange ={
                                                               value1.value=it
        }, modifier = Modifier.fillMaxWidth() )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = value2.value, onValueChange ={
                                                         value2.value=it
        }, modifier = Modifier.fillMaxWidth() )
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                result.value = (value1.value.toDouble()+value2.value.toDouble()).toString()
            }) {
                Text(text = "ADD")
            }
            Button(onClick = {
                result.value = (value1.value.toDouble()-value2.value.toDouble()).toString()
            }) {
                Text(text = "SUB")
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                result.value = (value1.value.toDouble()*value2.value.toDouble()).toString()
            }) {
                Text(text = "MULTI")
            }
            Button(onClick = {
                result.value = (value1.value.toDouble()/value2.value.toDouble()).toString()
            }) {
                Text(text = "DIV")
            }
        }

        if (result.value.isNotEmpty())
        Text(text = "The Result is ${result.value}")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun demo() {
    myApp()
}






