package com.example.sportsunity

import com.example.sportsunity.model.ApiResponse
import com.example.sportsunity.model.OtpVerifyRespone
import com.example.sportsunity.model.RequestParameters
import com.example.sportsunity.model.StatusResponse
import com.example.sportsunity.model.SubscribeRequestParameters
import com.example.sportsunity.model.SubscribeResponse
import com.example.sportsunity.model.UnsubscribeRequestParameters
import com.example.sportsunity.model.UnsubscribeResponse
import com.example.sportsunity.model.VerifyParameters
import com.example.sportsunity.model.VerifyParametersStatus
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyApiService{
    @POST("nazmul/subscription/otp/request")
    fun requestOtp(@Body requerstParameters: RequestParameters): Call<ApiResponse>

    @POST("nazmul/subscription/otp/verify")
    fun verifyOtp(@Body verifyParameters: VerifyParameters): Call<OtpVerifyRespone>

    @POST("nazmul/subscription/status ")
    fun verifySubscription(@Body verifyParametersStatus: VerifyParametersStatus): Call<StatusResponse>
//
    @POST("nazmul/subscription/subscribe ")
    fun subscribe(@Body subscribeRequestParameters: SubscribeRequestParameters): Call<SubscribeResponse>
//
    @POST("nazmul/subscription/unsubscribe ")
    fun unsubscribe(@Body unsubscribeRequestParameters: UnsubscribeRequestParameters): Call<UnsubscribeResponse>


}