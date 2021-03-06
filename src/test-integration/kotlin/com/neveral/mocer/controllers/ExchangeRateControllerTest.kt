package com.neveral.mocer.controllers

import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

/**
 * Created by Neveral on 19/09/2017.
 */

@RunWith(SpringRunner::class)
@SpringBootTest
class ExchangeRateControllerIT {


    @Autowired lateinit var webAppContext: WebApplicationContext
    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build()
    }

    @Test
    fun getExchangeRateShouldReturnNumber() {
        mockMvc.perform(MockMvcRequestBuilders.get("/getExchange"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("number", Matchers.any(Double::class.java)))
    }
}