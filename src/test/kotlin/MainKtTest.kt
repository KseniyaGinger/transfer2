import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateTax() {
        var paymentSystem = "Visa"
        var monthlySum = 10000
        var dailySum = 200
        var amount = 750

        val result = calculateTax(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(35, result)
    }

    @Test
    fun calculateTaxShouldTakeTax() {
        var paymentSystem = "VK Pay"
        var monthlySum = 10000
        var dailySum = 200
        var amount = 750

        val result = calculateTax(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(0, result)
    }
}