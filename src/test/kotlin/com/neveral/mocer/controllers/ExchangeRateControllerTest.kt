package com.neveral.mocer.controllers

import org.junit.Before
import org.junit.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

/**
 * Created by Neveral on 19/09/2017.
 */
class ExchangeRateControllerTest {

    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mockMvc = MockMvcBuilders.standaloneSetup(ExchangeRateController()).build()
    }

    @Test
    fun getExchangeRateShouldReturnNumber() {
        mockMvc.perform(MockMvcRequestBuilders.get("/getExchange"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("number", org.hamcrest.Matchers.any(Double::class.java)))
    }
}