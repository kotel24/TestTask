package ru.sumin.testtask.features.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel
import ru.sumin.testtask.core.ui.R
import ru.sumin.testtask.core.ui.theme.*

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search courses...", color = Color.Gray) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = AppWhite) },
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFF1E1E1E), RoundedCornerShape(90.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1E1E1E),
                    unfocusedContainerColor = Color(0xFF1E1E1E),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(90.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = { viewModel.onSortClicked() },
                modifier = Modifier
                    .size(56.dp)
                    .background(Color(0xFF1E1E1E), RoundedCornerShape(90.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.funnel),
                    contentDescription = "Sort",
                    tint = AppWhite
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.align(Alignment.End)) {
            Text("По дате добавления", color = AppGreen, fontSize = 20.sp)
            Icon(modifier = Modifier.align(Alignment.CenterVertically).size(20.dp), painter = painterResource(id = R.drawable.arrow_down_up), contentDescription = null, tint = AppGreen)
        }


        Spacer(modifier = Modifier.height(8.dp))

        when {
            state.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color(0xFF12B956))
                }
            }
            state.isError -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Ошибка загрузки данных", color = Color.Red)
                }
            }
            else -> {
                LazyColumn(
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(state.courses) { course ->
                        CourseItem(
                            course = course,
                            onCourseClick = { }
                        )
                    }
                }
            }
        }
    }
}