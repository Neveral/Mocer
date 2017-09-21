package com.neveral.mocer.controllers

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by Neveral on 19/09/2017.
 */

@Controller
class ExchangeRateController {

    @RequestMapping("/getExchange")
    @ResponseBody
    fun getExchangeRate(): ResponseEntity<RandomNumber> {
        val a = Math.random()*10

        return ResponseEntity.ok(RandomNumber(a))
    }

    data class RandomNumber(var number: Double)
}