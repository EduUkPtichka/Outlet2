package com.determent.outlet2.auth.decompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import com.arkivanov.decompose.ComponentContext

@Composable
fun AuthScreenContent(
    component: AuthComponent,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)

    )
}