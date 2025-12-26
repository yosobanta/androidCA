package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            inputs()
        }
    }
}
/*Ananya is using a Workshop
Registration Compose app. She enters the Workshop title, workshop ID, and number of sessions in separate text fields. She also selects a checkbox to confirm her registration details.
If the number of sessions is greater than zero and the checkbox is selected,the app navigates to a confirmation
screen displaying the workshop title, workshop ID, and number of sessions entered by Ananya.
Otherwise, the app displays the message:“Please enter valid details and confirm the registration.”*/
@Preview(showBackground = true)
@Composable
fun inputs() {
    val context = LocalContext.current
    var title by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var sessions by remember { mutableStateOf("") }
    var check by remember { mutableStateOf(false) }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp).border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)).padding(10.dp).fillMaxSize()
    ){
        OutlinedTextField(
            value = title,
            onValueChange = {title=it},
            label = {Text("Session Title")}
        )
        OutlinedTextField(
            value = id,
            onValueChange = {id=it},
            label = {Text("Session ID here")}
        )
        OutlinedTextField(
            value = sessions,
            onValueChange = {sessions=it},
            label = {Text("Total sessions conducted")}
        )
        Row (
            modifier = Modifier.padding(top = 18.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ){
            Checkbox(
                checked = check,
                onCheckedChange = {check=it}
            )
            Text("Confirm the registration details")
        }
        Button(
            onClick = {
                if (!title.isEmpty() && !id.isEmpty() && sessions.toInt()>0 && check==true){
                    val intent = Intent(context, SecondScreen::class.java)
                    intent.putExtra("Title",title)
                    intent.putExtra("ID",id)
                    intent.putExtra("Sessions",sessions)
                    context.startActivity(intent)
                }
                else{
                    Toast.makeText(context,"Please verify all the fields and check the checkbox",
                        Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("SEND")
            Icon(
                imageVector = Icons.Default.Send, // The actual send icon
                contentDescription = "Send Icon", // For accessibility
                modifier = Modifier.padding(end = 8.dp) // Space between icon and text
            )


        }

    }
}

