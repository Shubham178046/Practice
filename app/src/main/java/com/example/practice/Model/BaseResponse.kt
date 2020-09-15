package com.example.practice.Model

data class BaseResponse(
    val countries_stat: ArrayList<CountriesStat>,
    val statistic_taken_at: String,
    val world_total: WorldTotal
)