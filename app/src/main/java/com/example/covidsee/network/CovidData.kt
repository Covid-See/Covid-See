package com.example.covidsee.network

import com.google.gson.annotations.SerializedName

// 지역별 코로나 현황 data class
data class RegionVO(
    @SerializedName("korea")
    var korea: CovidVO,

    @SerializedName("seoul")
    var seoul: CovidVO,

    @SerializedName("busan")
    var busan: CovidVO,

    @SerializedName("daegu")
    var daegu: CovidVO,

    @SerializedName("incheon")
    var incheon: CovidVO,

    @SerializedName("gwangju")
    var gwangju: CovidVO,

    @SerializedName("daejeon")
    var daejeon: CovidVO,

    @SerializedName("ulsan")
    var ulsan: CovidVO,

    @SerializedName("sejong")
    var sejong: CovidVO,

    @SerializedName("gyeonggi")
    var gyeonggi: CovidVO,

    @SerializedName("gangwon")
    var gangwon: CovidVO,

    @SerializedName("chungbuk")
    var chungbuk: CovidVO,

    @SerializedName("chungnam")
    var chungnam: CovidVO,

    @SerializedName("jeonbuk")
    var jeonbuk: CovidVO,

    @SerializedName("jeonnam")
    var jeonnam: CovidVO,

    @SerializedName("gyeongbuk")
    var gyeongbuk: CovidVO,

    @SerializedName("gyeongnam")
    var gyeongnam: CovidVO,

    @SerializedName("jeju")
    var jeju: CovidVO,

    @SerializedName("quarantine")
    var quarantine: CovidVO
)

// 확진자 등 정보 관련 data class
data class CovidVO(
    @SerializedName("countryName")
    var countryName: String,

    @SerializedName("newCase")
    var newCase: String,

    @SerializedName("totalCase")
    var totalCase: String,

    @SerializedName("recovered")
    var recovered: String,

    @SerializedName("death")
    var death: String,

    @SerializedName("percentage")
    var percentage: String,

    @SerializedName("newFcase")
    var newFCase: String,

    @SerializedName("newCcase")
    var newCCase: String
)
