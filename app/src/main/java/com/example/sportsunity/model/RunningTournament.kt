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
    var registrationNo: String? = null,
    var email: String? = null,
    var contact: String? = null,
    var password: String? = null,
    var asParticipant: List<String>? = null,
    var asOrganaizer: List<String>? = null,
    var asVolunteer: List<String>? = null,
    var isSubscribed: Boolean? = null
)

data class TournamentID(
    var organizerEmail: String? = null,
    var tournamentId: String= "",
    var name: String? = null,
    var description: String? = null,
    var sports: List<String>? = null,
    var volunteers: List<String>? = null,
    var startDate: String? = null,
    var endDate: String? = null
)

data class SportID(
    var sportsId: String? = null,
    var sportName: String? = null,
    var playerList: List<String>? = null,
    var winnerList: List<String>? = null,
    var tournamentName: String? = null
)

data class winnerList1(
    var winnerListId: String? = null,
    var round: String? = null,
    var sportName: String? = null,
    var tournamentName: String? = null,
    var winnerName : String? = null,
    var losserName: String? = null,
)

data class teams(
    var teamsId: String? = null,
    var name: String? = null,
    var playerList: List<String>? = null,
    var tournamentName: String? = null,
)

data class PlayerId(
    var playerIdId: String? = null,
    var playerName: String? = null,
    var teamName: String? = null,
    var goal: String? = null,
    var assist: String? = null,
    var tournamentName: String? = null,
    var round: String? = null
)

data class WinnerList2(
    var WinnerListId: String? = null,
    var winnerTeamName: String? = null,
    var losserTeamName: String? = null,
    var winnerTeamGoal: String? = null,
    var losserTeamGoal: String? = null,
    var round: String? = null,
    var tournamentName: String? =null
)


data class ApiResponse(
    val statusCode: String,
    val statusDetail: String,
    val referenceNo: String,
    val version: String
)


data class RequestParameters(
    val appId: String,
    val password: String,
    var mobile: String
)


data class VerifyParameters(
    val appId: String,
    val password: String,
    var referenceNo: String? = null,
    var otp: String
)


data class SubscribeRequestParameters(
    val appId: String,
    val password: String,
    val mobile: String

)

data class StatusResponse(
    val version:String,
    val statusCode: String,
    val statusDetail: String,
    val subscriptionStatus: String
)

data class OtpVerifyRespone(
    val statusCode: String,
    val version: String,
    val subscriptionStatus: String,
    val statusDetail: String,
    val subscriberId: String
)
data class SubscribeResponse(
    val statusCode: String,
    val statusDetail: String,
    val subscriptionStatus: String,
    val version: String
)

data class VerifyParametersStatus(
    val appId: String,
    val password: String,
    val mobile: String
)

data class UnsubscribeRequestParameters(
    val appId: String,
    val password: String,
    val mobile: String
)

data class UnsubscribeResponse(
    val statusCode: String,
    val statusDetail: String,
    val subscriptionStatus: String,
    val version: String
)