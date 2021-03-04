package com.lucidsoftworksllc.applicationblank.main_activity.repositories.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("Global Quote")
    val globalQuote: GlobalQuote?
) {
    data class GlobalQuote(

        @SerializedName("01. symbol")
        val symbol: String?,

        @SerializedName("02. open")
        val open: String?,

        @SerializedName("03. high")
        val high: String?,

        @SerializedName("04. low")
        val low: String?,

        @SerializedName("05. price")
        val price: String?,

        @SerializedName("06. volume")
        val volume: String?,

        @SerializedName("07. latest trading day")
        val latest_trading_day: String?,

        @SerializedName("08. previous close")
        val previous_price: String?,

        @SerializedName("09. change")
        val change: String?,

        @SerializedName("10. change percent")
        val change_percent: String?
    )
}

/*"01. symbol": "TSLA",
        "02. open": "687.9900",
        "03. high": "700.7000",
        "04. low": "651.7050",
        "05. price": "653.2000",
        "06. volume": "30207960",
        "07. latest trading day": "2021-03-03",
        "08. previous close": "686.4400",
        "09. change": "-33.2400",
        "10. change percent": "-4.8424%"*/