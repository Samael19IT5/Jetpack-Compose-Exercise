package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}


@Composable
fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff073042))
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(painter = image, contentDescription = null, modifier = Modifier.width(96.dp))
        Text(text = "Sang Tran", fontSize = 48.sp, color = Color.White)
        Text(
            text = "Android Developer Extraordinaire",
            fontWeight = FontWeight.Bold,
            color = Color(0xff3DDC84)
        )
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
    ) {
        BusinessCardDetail(
            Icons.Filled.Phone,
            stringResource(R.string.phone),
        )
        BusinessCardDetail(
            Icons.Filled.Share,
            stringResource(R.string.share),
        )
        BusinessCardDetail(
            Icons.Filled.Email,
            stringResource(R.string.email),
        )
    }
}

@Composable
fun BusinessCardDetail(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.padding(start = 48.dp, end = 32.dp),
            tint = Color(0xff3DDC84)
        )
        Text(text = text, color = Color.White)
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}