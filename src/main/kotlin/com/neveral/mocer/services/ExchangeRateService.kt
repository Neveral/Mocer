package com.neveral.mocer.services

/**
 * Created by Neveral on 20/09/2017.
 */
interface ExchangeRateService {

    fun getExchangeRate(): Map<String, Double>
}