package io.jeffchang.covidtracking.ui.dailycase.data.model.daily

import com.squareup.moshi.Json

data class DailyCase(

	@Json(name = "date")
	val date: Int? = null,

	@Json(name = "death")
	val death: Int? = null,

	@Json(name = "totalTestResultsIncrease")
	val totalTestResultsIncrease: Int? = null,

	@Json(name = "pending")
	val pending: Int? = null,

	@Json(name = "hospitalizedCurrently")
	val hospitalizedCurrently: Int? = null,

	@Json(name = "hospitalizedIncrease")
	val hospitalizedIncrease: Int? = null,

	@Json(name = "states")
	val states: Int? = null,

	@Json(name = "onVentilatorCumulative")
	val onVentilatorCumulative: Int? = null,

	@Json(name = "hospitalized")
	val hospitalized: Int? = null,

	@Json(name = "negative")
	val negative: Int? = null,

	@Json(name = "total")
	val total: Int? = null,

	@Json(name = "hospitalizedCumulative")
	val hospitalizedCumulative: Int? = null,

	@Json(name = "inIcuCumulative")
	val inIcuCumulative: Int? = null,

	@Json(name = "negativeIncrease")
	val negativeIncrease: Int? = null,

	@Json(name = "positiveIncrease")
	val positiveIncrease: Int? = null,

	@Json(name = "deathIncrease")
	val deathIncrease: Int? = null,

	@Json(name = "totalTestResults")
	val totalTestResults: Int? = null,

	@Json(name = "inIcuCurrently")
	val inIcuCurrently: Int? = null,

	@Json(name = "dateChecked")
	val dateChecked: String? = null,

	@Json(name = "onVentilatorCurrently")
	val onVentilatorCurrently: Int? = null,

	@Json(name = "positive")
	val positive: Int? = null,

	@Json(name = "posNeg")
	val posNeg: Int? = null,

	@Json(name = "recovered")
	val recovered: Int? = null,

	@Json(name = "lastModified")
	val lastModified: String? = null,

	@Json(name = "hash")
	val hash: String? = null

)