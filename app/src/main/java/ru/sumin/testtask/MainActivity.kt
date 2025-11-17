package ru.sumin.testtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.sumin.testtask.core.ui.theme.AppTheme
import ru.sumin.testtask.features.home.presentation.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                CoursesAppContent()
            }
        }
    }
}