package com.njogu.ajirihiringredone.models.service

interface LogService {
    fun logNonFatalCrash(throwable: Throwable)
}