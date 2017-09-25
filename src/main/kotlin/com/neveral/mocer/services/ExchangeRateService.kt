package com.neveral.mocer.services

import com.neveral.mocer.Currencies
import com.neveral.mocer.CurrencyDto

/**
 * Created by Neveral on 20/09/2017.
 */
interface ExchangeRateService {

    fun getExchangeRateForAllCoins(): Map<String, Double>
    fun getExchangeRateFor(currencyName: Currencies): CurrencyDto
}