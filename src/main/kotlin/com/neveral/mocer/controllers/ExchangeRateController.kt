package com.neveral.mocer.controllers

import com.neveral.mocer.services.ExchangeRateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by Neveral on 19/09/2017.
 */

@Controller
class ExchangeRateController {

    @Autowired
    lateinit var exchangeRateService: ExchangeRateService

    @RequestMapping("/getExchange")
    @ResponseBody
    fun getExchangeRate(): ResponseEntity<Map<String, Double>> {

        return ResponseEntity.ok(exchangeRateService.getExchangeRateForAllCoins())
    }

}