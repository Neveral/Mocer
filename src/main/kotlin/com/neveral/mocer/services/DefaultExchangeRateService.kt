package com.neveral.mocer.services

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

    override fun getExchangeRate(): Map<String, Double> {
        val doc: Document = Jsoup.connect(DEFAULT_URL_TO_PARSE_EXCHANGE_RATE)
                .userAgent("Mozilla")
                .get()

        val elementsByClass = doc.getElementsByClass("ptr")

//        File("page.html").printWriter().use {
//            it.print(elementsByClass.get(0).t)
//        }

        val currencyRateMap: HashMap<String, Double> = HashMap()

        for (element: Element in elementsByClass) {
            val currencyName = element.child(0).child(0).text()
            val currencyRate: Double =parseDoubleFromConvCurElement(element.getElementsByClass("conv_cur")[0])
            println("$currencyName: $currencyRate")
            currencyRateMap.put(currencyName, currencyRate)
        }


        print(currencyRateMap)

        return HashMap()
    }

    fun parseDoubleFromConvCurElement(element: Element): Double {
        return element.text().replace("$", "").replace(" ", " ").replace(",", "").toDouble()
    }
}