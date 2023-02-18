package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LemonadeApp() {
    var step by remember { mutableStateOf(1) }
    var count by remember { mutableStateOf(0) }
    Surface(modifier = Modifier.fillMaxSize()) {
        when (step) {
            1 -> {
                LemonadeWithTextAndImage(
                    text = R.string.text_1,
                    desc = R.string.desc_1,
                    image = R.drawable.lemon_tree,
                    onImageClick = {
                        count = (2..4).random()
                        step = 2
                    }
                )
            }
            2 -> {

                LemonadeWithTextAndImage(
                    text = R.string.text_2,
                    desc = R.string.desc_2,
                    image = R.drawable.lemon_squeeze,
                    onImageClick = {
                        count--
                        if (count == 0) {
                            step = 3
                        }

                    }
                )
            }
            3 -> {
                LemonadeWithTextAndImage(
                    text = R.string.text_3,
                    desc = R.string.desc_3,
                    image = R.drawable.lemon_drink,
                    onImageClick = {
                        step = 4
                    }
                )
            }
            4 -> {
                LemonadeWithTextAndImage(
                    text = R.string.text_4,
                    desc = R.string.desc_4,
                    image = R.drawable.lemon_restart,
                    onImageClick = {
                        step = 1
                    }
                )
            }
        }
    }
}

@Composable
fun LemonadeWithTextAndImage(
    text: Int,
    desc: Int,
    image: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = text), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = desc),
            modifier = Modifier
                .clickable(onClick = onImageClick)
                .border(BorderStroke(2.dp, Color(105, 205, 216)), shape = RoundedCornerShape(4.dp))
                .padding(16.dp)
        )
    }
}