package com.turbomoduleexample.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object APIState {
    var allGroupCall: APIStateType by mutableStateOf(APIStateType.loading)
    var groupDetailsCall: APIStateType by mutableStateOf(APIStateType.loading)
    var accountDetailsCall: APIStateType by mutableStateOf(APIStateType.loading)
}

sealed class APIStateType {
    object loading : APIStateType()
    object done : APIStateType()
}