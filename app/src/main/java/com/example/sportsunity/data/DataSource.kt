package com.example.sportsunity.data

import androidx.compose.ui.res.stringResource
import com.example.sportsunity.R
import com.example.sportsunity.model.IndividualTeam
import com.example.sportsunity.model.RunningTournament
import com.example.sportsunity.model.SportsList
import com.example.sportsunity.model.TeamData
import com.example.sportsunity.model.TeamWiseWinner
import com.example.sportsunity.model.WinnerList

class DataSource {
    fun loadRunningTournaments(): List<RunningTournament>{
        return listOf<RunningTournament>(
            RunningTournament(R.string.indoor, R.string.cse_des, R.drawable.chess_button),
            RunningTournament(R.string.eee_indoor, R.string.eee_des, R.drawable.indoor_eee),
            RunningTournament(R.string.ipe_indoor, R.string.ipe_des, R.drawable.indoor_ipe),
        )
    }
}
class DataSourceForMyTournament{
    fun loadMyTournament(): List<RunningTournament>{
        return listOf<RunningTournament>(
            RunningTournament(R.string.indoor, R.string.cse_des, R.drawable.chess_button),
            RunningTournament(R.string.eee_indoor, R.string.eee_des, R.drawable.indoor_eee)
            )
    }
}

//class DataSourceForSportList{
//    fun loadSportList(): List<SportsList>{
//        return listOf<SportsList>(
//            SportsList(stringResourceId1 = R.string.chess),
//            SportsList(R.string.ludo),
//            SportsList(R.string.carrom),
//            SportsList(R.string.football)
//        )
//    }
//}

class DataSourceForWinnerList{
    fun loadWinnerList(): List<WinnerList>{
        return listOf<WinnerList>(
            WinnerList(R.string.winner1,R.string.round1,R.string.losser1),
            WinnerList(R.string.winner2,R.string.round2,R.string.losser2),
            WinnerList(R.string.winner3,R.string.round1,R.string.losser3),
            WinnerList(R.string.winner4,R.string.round2,R.string.losser4),
        )
    }
}
class DataSourceTeamWiseWinner{
    fun loadTeamWiseWinner(): List<TeamWiseWinner>{
        return listOf<TeamWiseWinner>(
            TeamWiseWinner(R.string.winner1,R.string.losser1,R.string.round1,R.string.val_3,R.string.val_6),
            TeamWiseWinner(R.string.winner2,R.string.losser2,R.string.round1,R.string.val_4,R.string.val_8),
            TeamWiseWinner(R.string.winner3,R.string.losser3,R.string.round1,R.string.val_3,R.string.val_4),
            TeamWiseWinner(R.string.winner4,R.string.losser4,R.string.round1,R.string.val_4,R.string.val_5),
        )
    }
}

class DataSourceIndividualTeam{
    fun loadIndividualTeam(): List<IndividualTeam>{
        return listOf<IndividualTeam>(
            IndividualTeam(R.string.winner1,0,2),
            IndividualTeam(R.string.losser1,0,1),
            IndividualTeam(R.string.winner2,0,1),
            IndividualTeam(R.string.losser2,1,2),
            IndividualTeam(R.string.winner3,0,1),
            IndividualTeam(R.string.losser3,1,0),
            IndividualTeam(R.string.winner4,2,0),
            IndividualTeam(R.string.losser4,3,2),
        )
    }
}

class DataSourceTeamData{
    fun loadTeamData(): List<TeamData>{
        return listOf<TeamData>(
            TeamData(R.string.winner1),
            TeamData(R.string.winner2),
            TeamData(R.string.winner3),
            TeamData(R.string.winner4),
            TeamData(R.string.losser1),
            TeamData(R.string.losser2),
            TeamData(R.string.losser3),
            TeamData(R.string.losser4),
        )
    }
}

