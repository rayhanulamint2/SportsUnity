package com.example.sportsunity.data

import androidx.compose.ui.res.stringResource
import com.example.sportsunity.R
import com.example.sportsunity.model.RunningTournament
import com.example.sportsunity.model.SportsList

class DataSource {
    fun loadRunningTournaments(): List<RunningTournament>{
        return listOf<RunningTournament>(

            RunningTournament(R.string.ipe_indoor, R.string.ipe_des, R.drawable.indoor_ipe),
            RunningTournament(R.string.indoor, R.string.cse_des, R.drawable.chess_button),
            RunningTournament(R.string.eee_indoor, R.string.eee_des, R.drawable.indoor_eee),
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

class DataSourceForSportList{
    fun loadSportList(): List<SportsList>{
        return listOf<SportsList>(
            SportsList(stringResourceId1 = R.string.chess),
            SportsList(R.string.ludo),
            SportsList(R.string.carrom)
        )
    }
}