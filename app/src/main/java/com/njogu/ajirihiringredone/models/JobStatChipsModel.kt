package com.njogu.ajirihiringredone.models

import kotlinx.coroutines.Job

enum class JobStat (val value: String){
    OverView("OverView"),
    Approved("Approved"),
    InProgress("InProgress")
}

fun getAllJobStatChips(): List<JobStat>{
    return listOf(JobStat.OverView,JobStat.Approved, JobStat.InProgress)
}

fun getJobStat(value: String): JobStat{
    val map = JobStat.values().associateBy(JobStat::value)
    return map[value]!!
}

fun returnView(){

}


