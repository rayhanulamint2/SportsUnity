package com.example.sportsunity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.time.LocalDate
import java.util.Date

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
    @StringRes val stringResourceId3: Int,
    @StringRes val goal_team1: Int,
    @StringRes val goal_team2: Int
)

data class IndividualTeam(
    @StringRes val stringResourceId1: Int,
    val goal_team1: Int,
    val goal_team2: Int
)

data class TeamData(
    @StringRes val stringResourceId: Int
)

data class UserID(
    var documentId: String? = null,
    var name: String? = null,
    var university: String? = null,
    var email: String? = null,
    var contact: String? = null,
    var password: String? = null,
    var asParticipant: List<String>? = null,
    var asOrganaizer: List<String>? = null,
    var asVolunteer: List<String>? = null
)

data class TournamentID(
    var tournamentId: String= "",
    var name: String? = null,
    var description: String? = null,
    var sports: List<String>? = null,
    var volunteers: List<String>? = null,
    var startDate: String? = null,
    var endDate: String? = null
)