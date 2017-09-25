package com.neveral.mocer.services

import com.neveral.mocer.Currencies
import org.assertj.core.api.Assertions.assertThat
import org.jsoup.nodes.Element
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Neveral on 20/09/2017.
 */
@RunWith(MockitoJUnitRunner::class)
class DefaultExchangeRateServiceTest {

    lateinit var exchangeRateService: DefaultExchangeRateService

    @Before
    fun init() {
        exchangeRateService = DefaultExchangeRateService()
    }

    @Test
    fun getExchangeRateShouldReturnNotEmptyMap() {
        assertTrue(exchangeRateService.getExchangeRateForAllCoins().isNotEmpty())
//        assertThat(exchangeRateService.getExchangeRate().size, org.hamcrest.Matchers.greaterThan(1))
    }

    @Test
    fun getExchangeRateForTest() {
        assertThat(exchangeRateService.getExchangeRateFor(Currencies.BITCOIN).currencyRate).isGreaterThan(0.0)
    }

    @Mock
    lateinit var el: Element

    @Test
    @Throws(Exception::class)
    fun parseDoubleFromConvCurElement() {
        Mockito.`when`(el.text()).thenReturn("$ 3,693.35")
        assertThat(exchangeRateService.parseDoubleFromConvCurElement(el)).isEqualTo(3693.35)
    }

}