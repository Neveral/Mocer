package com.neveral.mocer.services

import org.springframework.stereotype.Service

/**
 * Created by Neveral on 20/09/2017.
 */
@Service
class DefaultExchangeRateService : ExchangeRateService {

    override fun getExchangeRate(): Map<String, Double> {
        return mapOf("BTC" to 1.0, "Dash" to 2.0)
    }
}