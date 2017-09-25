package com.neveral.mocer.services

import com.neveral.mocer.Currencies
import com.neveral.mocer.CurrencyDto
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

/**
 * Created by Neveral on 20/09/2017.
 */
@Service
class DefaultExchangeRateService : ExchangeRateService {

    val DEFAULT_URL_TO_PARSE_EXCHANGE_RATE = "https://bitinfocharts.com/ru/markets/"
    val currencyRateMap: HashMap<String, Double> = HashMap()

    /**
     * This method return map of cryptocoins currency exchange rate from parsed site https://bitinfocharts.com/ru/markets/
     */
    override fun getExchangeRateForAllCoins(): Map<String, Double> {
        val doc: Document = Jsoup.connect(DEFAULT_URL_TO_PARSE_EXCHANGE_RATE)
                .userAgent("Mozilla")
                .get()

        val elementsByClass = doc.getElementsByClass("ptr")


        for (element: Element in elementsByClass) {
            val currencyName = element.child(0).text().substringBefore(" ")
            val currencyRate: Double = parseDoubleFromConvCurElement(element.getElementsByClass("conv_cur")[0])
            currencyRateMap.put(currencyName, currencyRate)
        }

        return currencyRateMap
    }

    override fun getExchangeRateFor(currency: Currencies): CurrencyDto {
        if (currencyRateMap.isEmpty())
            getExchangeRateForAllCoins()

        return CurrencyDto(currency.name,
                currencyRateMap[currency.shortName] ?: throw RuntimeException("Currency rate for this coin was not found"))
    }

    fun parseDoubleFromConvCurElement(element: Element): Double {
        return element.text().replace("$", "").replace(" ", " ").replace(",", "").toDouble()
    }
}