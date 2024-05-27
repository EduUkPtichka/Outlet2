package com.determent.outlet2.auth.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.determent.outlet2.auth.model.AuthModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthComponentDefault(
    componentContext: ComponentContext
) : AuthComponent, ComponentContext by componentContext {

    private val _models = MutableValue(
        AuthModel(
            phoneNumber = "",
            emailPerson = "",
        )
    )

    override val models: Value<AuthModel> = _models

    override fun onPhoneNumberChange(phoneNumber: String) {
        _models.value = models.value.copy(phoneNumber = phoneNumber)
    }

    override fun onEmailPersonChange(emailPerson: String) {
        _models.value = models.value.copy(emailPerson = emailPerson)
    }

    override fun onNextStep() {

    }
}