package com.example.simplecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecounter.ui.theme.SimpleCounterTheme
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                   var number by remember {
                       mutableIntStateOf(0)
                   }
                    val persianLocale= Locale("fa","IR")
                    val numberFormat=NumberFormat.getNumberInstance(persianLocale)
                    Column(modifier=Modifier.fillMaxSize(),
                        horizontalAlignment=Alignment.CenterHorizontally,
                        verticalArrangement=Arrangement.Center){
                        TextResult("$number")
                        Row(modifier=Modifier.fillMaxWidth(),
                            horizontalArrangement=Arrangement.SpaceAround){

                            myButton("+"){number++}
                            Text(numberFormat.format(number),modifier= Modifier.padding(horizontal = 30.dp), fontSize = 60.sp)
                            myButton("-"){number--}
                        }
                    }

                }
            }
        }
    }

    //hello


    @Composable
    private fun myButton(text:String,function: () -> Unit){
        Button(onClick=function){
            Text(text=text)
        }
    }

}
@Composable
private fun TextResult(s:String){
    //Text(text=s, fontWeight = FontWeight.Bold, fontSize = 30.sp,)
}







