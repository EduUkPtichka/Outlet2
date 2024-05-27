package com.determent.outlet2.decompose_core

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.determent.outlet2.auth.decompose.AuthComponent
import com.determent.outlet2.auth.decompose.AuthComponentDefault
import com.determent.outlet2.decompose_core.RootComponent.Child.AuthChild
import com.determent.outlet2.decompose_core.RootComponentDefault.ConfigDecompose.ConfigAuth
import kotlinx.serialization.Serializable

class RootComponentDefault(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<ConfigDecompose>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = ConfigDecompose.serializer(),
            initialConfiguration = ConfigAuth,
            handleBackButton = true,
            childFactory = ::child
        )

    private fun child(configDecompose: ConfigDecompose, componentContext: ComponentContext) =
        when (configDecompose) {
            is ConfigAuth -> AuthChild(authComponent(componentContext))
        }

    private fun authComponent(componentContext: ComponentContext): AuthComponent =
        AuthComponentDefault(
            componentContext = componentContext,
        )

    @Serializable
    private sealed interface ConfigDecompose {
        @Serializable
        data object ConfigAuth : ConfigDecompose

    }
}