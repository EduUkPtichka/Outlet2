package com.determent.outlet2.decompose_core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.determent.outlet2.auth.decompose.AuthScreenContent

@Composable
fun RootScreenContent(
    component: RootComponent,
    modifier: Modifier = Modifier,
){
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ){
        when(val child = it.instance){
            is RootComponent.Child.AuthChild -> AuthScreenContent(component = child.component)
        }
    }
}