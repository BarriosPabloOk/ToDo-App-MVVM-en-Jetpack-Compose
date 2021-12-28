package com.pablobarriosdevs.easytask.presentation.tasks_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pablobarriosdevs.easytask.common.format
import com.pablobarriosdevs.easytask.common.makeFormat

import java.util.*

@Composable
fun DateDisplay(
    modifier: Modifier = Modifier,
    currentDate: Date,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            modifier = Modifier
                .width(170.dp)
                .height(70.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(3.dp)
                    .align(Alignment.CenterStart),
                text = currentDate.format(),
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold,

                )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    modifier = Modifier
                        .padding(0.dp),
                    text = currentDate.format("MMM").makeFormat(),
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start

                )
                Text(
                    modifier = Modifier
                        .padding(0.dp),
                    text = currentDate.format("YYYY"),
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Start

                )
            }
        }

        Text(
            modifier = Modifier
                .padding(3.dp),
            text = currentDate.format("EEEE").uppercase(),
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Medium,


            )
    }




}


