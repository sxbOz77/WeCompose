package com.ozgungnir77.wecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozgungnir77.wecompose.data.Chat
import com.ozgungnir77.wecompose.ui.theme.WeComposeTheme

@Composable
fun ChatList(chats: List<Chat>) {
    LazyColumn(Modifier.fillMaxSize()) {
        itemsIndexed(chats) { index, chat ->
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painterResource(chat.friend.avatar), chat.friend.name,
                    Modifier
                        .padding(8.dp)
                        .size(48.dp)
                        .unread(!chat.msgs.last().read, WeComposeTheme.colors.badge),
                )
                Column(
                    Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                ) {
                    Text(
                        chat.friend.name,
                        fontSize = 17.sp,
                        color = WeComposeTheme.colors.textPrimary
                    )
                    Text(
                        chat.msgs.last().text,
                        fontSize = 14.sp,
                        color = WeComposeTheme.colors.textSecondary
                    )
                }
                Text(
                    chat.msgs.last().time,
                    Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
                    fontSize = 11.sp,
                    color = WeComposeTheme.colors.textSecondary
                )
            }
            if (index < chats.lastIndex) {
                Divider(
                    startIndent = 68.dp,
                    color = WeComposeTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
            }
        }
    }
}

fun Modifier.unread(show: Boolean, color: Color): Modifier = this.drawWithContent {
    drawContent()
    if (show) {
        drawCircle(
            color,
            5.dp.toPx(),
            Offset(size.width - 1.dp.toPx(), 1.dp.toPx())
        )
    }
}