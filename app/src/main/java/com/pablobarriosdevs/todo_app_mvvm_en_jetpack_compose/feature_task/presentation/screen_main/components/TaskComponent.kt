package com.pablobarriosdevs.easytask.presentation.tasks_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.R


@Composable
fun TaskComponent(
    modifier: Modifier = Modifier,
    title: String,
    isChecked: Boolean,
    onCheckedChange: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier =Modifier.padding(start = 10.dp),
                text = title,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontSize = MaterialTheme.typography.h6.fontSize,
            )

        }
        IconButton(
            onClick = { onCheckedChange() },
            modifier =Modifier.padding(start = 10.dp),
        ) {
            Icon(modifier = Modifier.size(10.dp),
                painter = if (isChecked) painterResource(id = R.mipmap.checked) else
                    painterResource(id = R.mipmap.unchecked),
                contentDescription = stringResource(id = R.string.check_button_icon)
            )
        }
    }
