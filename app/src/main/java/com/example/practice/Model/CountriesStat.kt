package com.example.practice.Model

data class CountriesStat(
    val active_cases: String,
    val cases: String,
    val country_name: String,
    val deaths: String,
    val deaths_per_1m_population: String,
    val new_cases: String,
    val new_deaths: String,
    val region: String,
    val serious_critical: String,
    val tests_per_1m_population: String,
    val total_cases_per_1m_population: String,
    val total_recovered: String,
    val total_tests: String
)