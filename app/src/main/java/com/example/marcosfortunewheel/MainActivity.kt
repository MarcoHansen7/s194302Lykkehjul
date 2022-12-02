package com.example.marcosfortunewheel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.marcosfortunewheel.ui.theme.MarcosFortuneWheelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarcosFortuneWheelTheme() {
                    Navigation()
                }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MarcosFortuneWheelTheme {
        MainActivity()
    }
}