package com.determent.outlet2.presentation_core

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.determent.outlet2.decompose_core.RootComponentDefault
import com.determent.outlet2.decompose_core.RootScreenContent

fun MainViewController() = ComposeUIViewController {
    val root = remember {
        RootComponentDefault(DefaultComponentContext(LifecycleRegistry()))
    }
    RootScreenContent(root)
}