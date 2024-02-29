package com.example.sportsunity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RunningTournament(
    @StringRes val stringResourceId: Int,
    @StringRes val stringResourceId2: Int,
    @DrawableRes val imageResourceId: Int
)

data class SportsList(
    @StringRes val stringResourceId1: Int,
)

