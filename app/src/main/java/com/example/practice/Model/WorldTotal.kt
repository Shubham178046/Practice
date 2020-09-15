package com.example.practice.Model

data class WorldTotal(
    val active_cases: String,
    val deaths_per_1m_population: String,
    val new_cases: String,
    val new_deaths: String,
    val serious_critical: String,
    val statistic_taken_at: String,
    val total_cases: String,
    val total_cases_per_1m_population: String,
    val total_deaths: String,
    val total_recovered: String
)