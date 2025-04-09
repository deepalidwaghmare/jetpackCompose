package com.example.birthdaymessage

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaymessage.ui.theme.BirthdayMessageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayMessageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingImage(
                        message = "Happy Birthday Sam!",
                        from = "From Emma",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,  //scales the image uniformly to maintain the aspect ratio
            alpha = 0.5F                      //Improve the app's contrast opacity changed

        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier.fillMaxSize().padding(8.dp))
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier : Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
    Text(
        text = message,
        fontSize = 100.sp,
        lineHeight = 116.sp,
        textAlign = TextAlign.Center
    )
    Text(
        text = from,
        fontSize = 36.sp,
        modifier = Modifier
            .padding(16.dp)
            .align(alignment = Alignment.CenterHorizontally)
    )

}
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayMessageTheme {
        GreetingImage(
            message = "Happy Birthday Ovu!",
            from = "From Mumma")
    }
}