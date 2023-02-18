package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtSpaceApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var index by remember {
            mutableStateOf(1)
        }
        var art by remember {
            mutableStateOf(R.string.art_1)
        }
        var artist by remember {
            mutableStateOf(R.string.artist_1)
        }
        var date by remember {
            mutableStateOf(R.string.date_1)
        }
        when (index) {
            1 -> {
                ArtImage(image = R.drawable.art1, art = R.string.art_1)
                art = R.string.art_1
                artist = R.string.artist_1
                date = R.string.date_1
            }
            2 -> {
                ArtImage(image = R.drawable.art2, art = R.string.art_2)
                art = R.string.art_2
                artist = R.string.artist_2
                date = R.string.date_2
            }
            3 -> {
                ArtImage(image = R.drawable.art3, art = R.string.art_3)
                art = R.string.art_3
                artist = R.string.artist_3
                date = R.string.date_3
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtInfo(
                art = art,
                artist = artist,
                date = date
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,

                ) {
                Button(
                    onClick = { if (index > 1) index-- },
                    modifier = Modifier
                        .width(140.dp)
                ) {
                    Text(text = stringResource(id = R.string.previous))
                }
                Button(
                    onClick = { if (index < 3) index++ },
                    modifier = Modifier
                        .width(140.dp)
                ) {
                    Text(text = stringResource(id = R.string.next))
                }
            }
        }

    }
}

@Composable
fun ArtImage(image: Int, art: Int) {
    Image(
        painter = painterResource(id = image),
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.FillWidth,
        contentDescription = stringResource(id = art),
        modifier = Modifier
            .fillMaxWidth()
            .border(BorderStroke(width = 2.dp, color = Color.Gray))
            .padding(32.dp),
    )
}

@Composable
fun ArtInfo(art: Int, artist: Int, date: Int) {
    Column(
        modifier = Modifier
            .shadow(elevation = 1.dp)
            .padding(16.dp)
    ) {
        Text(text = stringResource(id = art), fontSize = 24.sp)
        Row {
            Text(
                text = stringResource(id = artist),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = date), fontSize = 16.sp)
        }
    }
}



