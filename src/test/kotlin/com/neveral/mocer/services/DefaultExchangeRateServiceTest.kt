package com.neveral.mocer.services

import org.jsoup.nodes.Element
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.*

/**
 * Created by Neveral on 20/09/2017.
 */
class DefaultExchangeRateServiceTest {

    lateinit var exchangeRateService: DefaultExchangeRateService

    @Before
    fun init() {
        exchangeRateService = DefaultExchangeRateService()
    }

    @Test
    fun getExchangeRateShouldReturnNotEmptyMap() {
        assertTrue(exchangeRateService.getExchangeRate().isNotEmpty())
//        assertThat(exchangeRateService.getExchangeRate().size, org.hamcrest.Matchers.greaterThan(1))
    }

//    val el: Element = Element("<tag></tag>")
//
    @Test
    @Throws(Exception::class)
    fun parseDoubleFromConvCurElement() {
        val el: Element = Mockito.mock(Element::class.java)
        Mockito.`when`(el.text()).thenReturn("$ 3,693.35")
        org.assertj.core.api.Assertions.assertThat(exchangeRateService.parseDoubleFromConvCurElement(el)).isEqualTo(3693.35)
    }

}