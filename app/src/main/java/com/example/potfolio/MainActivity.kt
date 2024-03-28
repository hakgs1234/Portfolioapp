package com.example.potfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.potfolio.ui.theme.PotfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PotfolioTheme {
                Potfolio()
            }
        }
    }
}

@Composable
fun Potfolio() {
    val isOpen = remember { mutableStateOf(false) }

    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Hamaad ayub khan",
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Android Developer",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.insta),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "@hamaadayubkhan",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(fontSize = 10.sp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "@hakgs1234",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = TextStyle(fontSize = 10.sp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { isOpen.value = !isOpen.value }) {
                Text(text = "My Details")
            }
            if (isOpen.value) {
                LazyColumn {
                    items(getProjectList()) { project ->
                        ProjectItem(project = project)
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project) {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Text(text = project.name, style = MaterialTheme.typography.bodyMedium)
        Text(text = project.desc, style = MaterialTheme.typography.bodySmall)
    }
}

data class Project(
    val name: String,
    val desc: String
)

fun getProjectList(): List<Project> {
    return listOf(
        Project(
            name =
            "HELLO I'm Hamaad Ayub Khan Student of BSSE Semester 6th Currently" +
                    " working on Jetpack Compose " +
                    "This App is my Portfolio App" +
                    " In Which I shared my Social " +
                    "Media Info.",
            desc = "Sharing to Class Group"
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PotfolioPreview() {
    Potfolio()
}
