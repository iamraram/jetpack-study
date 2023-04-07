package com.example.jetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.ui.theme.JetpackTheme

val Primary = Color(0xFF234045)
val PrimaryGray = Color(0xFF637B81)
val PrimaryLight = Color(0xFF919FA2)
val PrimaryWhite = Color(0xFFE7EDEE)

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                Surface(color = colors.background, modifier = Modifier.fillMaxSize()) {
                    Column {
                        Greeting()
                    }
                }
            }
        }
    }
}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun Greeting() {
    val clubMembers by remember { mutableStateOf(
        mutableListOf("이하람", "백시현")
    )} // 사용자에게 보여줄 전체 리스트
    var text by remember { mutableStateOf("") } // 임시로 사용할 리스트

    Column(modifier = Modifier.fillMaxSize()) { // 세로 배치
        for (name in clubMembers) { // 리스트 사이즈만큼 반복
            Text(name, modifier = Modifier.padding(6.dp)) // 텍스트 보여주고 패딩 주기
        }
        TextField( // 텍스트
            value = text, // 기본 값은 위에서 선언한 텍스트고
            onValueChange = { text = it }, // 내용이 변경되면 텍스트를 갱신하고
            modifier = Modifier.fillMaxWidth(), // 가로로 꽉 채우기
        )

        Button( // 버튼
            onClick = { // 눌렀을 때
                clubMembers.add(clubMembers.size, text) // 전체 리스트에 추가하고
                Log.d("TAG", "입력된 값: $text") // 로그 한번 찍고
                text = "" // 변수 초기화
            },
            enabled = text.isNotEmpty() // 내용이 없으면 활성화 안시킴
        ) {
            Text("버튼") //  버튼 이름은 "버튼"
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackTheme {
        Greeting()
    }
}