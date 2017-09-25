package com.neveral.mocer.controllers

import com.neveral.mocer.services.ExchangeRateService
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

/**
 * Created by Neveral on 19/09/2017.
 */
class ExchangeRateControllerTest {

    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var exchangeRateService: ExchangeRateService

    @Before
    fun init() {
        mockMvc = MockMvcBuilders.standaloneSetup(ExchangeRateController()).build()
        Mockito.`when`(exchangeRateService.getExchangeRateForAllCoins()).thenReturn(mapOf("BTC" to 1.0, "DASH" to 2.3))
    }

    @Test
    fun getExchangeRateShouldReturnNumber() {
        mockMvc.perform(MockMvcRequestBuilders.get("/getExchange"))
                .andExpect(MockMvcResultMatchers.status().isOk)
//                .andExpect(MockMvcResultMatchers.jsonPath("number", org.hamcrest.Matchers.any(Double::class.java)))
    }
}