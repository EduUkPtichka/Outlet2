package com.determent.outlet2.auth.decompose

import com.arkivanov.decompose.value.Value
import com.determent.outlet2.auth.model.AuthModel
import kotlinx.coroutines.flow.StateFlow

interface AuthComponent {

    val models: Value<AuthModel>

    fun onPhoneNumberChange(phoneNumber: String)
    fun onEmailPersonChange(emailPerson: String)

    fun onNextStep()
}