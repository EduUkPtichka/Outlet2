package com.determent.outlet2.decompose_core

import androidx.compose.runtime.State
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.determent.outlet2.auth.decompose.AuthComponent
import kotlinx.coroutines.flow.StateFlow

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        class AuthChild(val component: AuthComponent) : Child()
    }
}