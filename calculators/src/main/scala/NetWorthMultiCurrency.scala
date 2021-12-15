
object NetWorthMultiCurrency {

  def calculate(assets: Double, liabilities: Double): Double = assets - liabilities

  def main(args: Array[String]): Unit = {
    val assets = args(0)
    val liabilities = args(1)

    val assetsInEuros = assets.split(",").map(_.trim).map(Currency(_))
    val liabilitiesInEuros = liabilities.split(",").map(_.trim).map(Currency(_))

    val totalAssetsInEuros = assetsInEuros.map(_.valueInEuros).sum
    val totalLiabilitiesInEuros = liabilitiesInEuros.map(_.valueInEuros).sum

    println(s"Your net worth is ${calculate(totalAssetsInEuros, totalLiabilitiesInEuros)}")
  }
}

object Currency {

  val currencyConverter: Map[String, Double] = Forex.getExchangeRates()

  def apply(value: String): Currency = {
    val Array(amountString: String, currencyCode: String) = value.split("\\s").map(_.trim)
    val amount: Long = amountString.toLong
    if(currencyCode != "EUR") {
      val multiplier: Double = 1 / currencyConverter(currencyCode)
      println(s"$currencyCode -> EUR: $multiplier")
      Currency(amount, currencyCode, amount * multiplier)
    } else Currency(amount, currencyCode, amount)
  }

}

case class Currency(amount: Long, code: String, valueInEuros: Double)
