package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticleCard(
                        title = stringResource(R.string.title_text),
                        shortDescription = stringResource(R.string.short_description_text),
                        longDescription = stringResource(R.string.long_description_text)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleCard(title: String, shortDescription: String, longDescription: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(painter = image, contentDescription = null)
        Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = longDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        ArticleCard(
            title = stringResource(R.string.title_text),
            shortDescription = stringResource(R.string.short_description_text),
            longDescription = stringResource(R.string.long_description_text)
        )
    }
}