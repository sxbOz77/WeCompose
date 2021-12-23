package com.ozgungnir77.wecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ozgungnir77.wecompose.data.Chat

@Composable
fun ChatList(chats: List<Chat>) {
    LazyColumn {
        items(chats) { chat ->
            Image(
                painterResource(chat.friend.avatar), contentDescription = chat.friend.name,
                Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        }
    }
}