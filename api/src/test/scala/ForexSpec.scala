import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ForexSpec extends AnyFlatSpec with Matchers {
  "The Forex api" should "fetch 32 currencies" in {
    val exchangeRates = Forex.getExchangeRates()
    exchangeRates.size should be (32)
  }
}
