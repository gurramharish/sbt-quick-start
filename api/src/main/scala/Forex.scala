import scala.util.{Failure, Success, Try}
import scala.xml.XML

object Forex {

  def getExchangeRates() = {
    val apiUrl = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml"
    val r = Try { requests.get(apiUrl) }
    r match {
      case Success(value) => getRatesFromXml(value.text)
      case Failure(exception) =>
        println(s"Exception while fetching exchange rates : ${exception.getMessage}")
        Map[String, Double]()
    }
  }

  private def getRatesFromXml(xml: String): Map[String, Double] = {
    val xmlResponse = XML.loadString(xml)
    val currencyCodes = (xmlResponse \\ "@currency").map(_.text)
    val euroExchangeRates = (xmlResponse \\ "@rate").map(_.text.toDouble)
    (currencyCodes zip euroExchangeRates).toMap
  }

  def main(args: Array[String]): Unit = {
    println(getExchangeRates())
  }
}
