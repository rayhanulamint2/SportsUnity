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

data class WinnerList(
    @StringRes val stringResourceId1: Int,
    @StringRes val stringResourceId2: Int,
    @StringRes val stringResourceId3: Int
)

data class TeamWiseWinner(
    @StringRes val stringResourceId1: Int,
    @StringRes val stringResourceId2: Int,
    @StringRes val goal_team1: Int,
    @StringRes val goal_team2: Int
)
