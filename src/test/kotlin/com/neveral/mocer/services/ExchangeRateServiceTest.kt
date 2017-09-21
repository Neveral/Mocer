package com.neveral.mocer.services

import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Created by Neveral on 20/09/2017.
 */
//@RunWith(SpringRunner::class)
//@SpringBootTest
class ExchangeRateServiceTest {

    lateinit var exchangeRateService: ExchangeRateService

    @Before
    fun init() {
        exchangeRateService = DefaultExchangeRateService()
    }

    @Test
    fun getExchangeRateShouldReturnNotEmptyMap() {
        assertTrue(exchangeRateService.getExchangeRate().isNotEmpty())
        assertThat(exchangeRateService.getExchangeRate().size, org.hamcrest.Matchers.greaterThan(1))
    }

}