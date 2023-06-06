import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateTaxMaestroMastercard() {
        var paymentSystem = "Maestro"
        var monthlySum = 10_000
        var dailySum = 50_000
        var amount = 20_000

        val result = calculateTax(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(140, result)
    }

    @Test
    fun calculateTaxVisaMir() {
        var paymentSystem = "Visa"
        var monthlySum = 10000
        var dailySum = 200
        var amount = 750

        val result = calculateTax(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(35, result)
    }

    @Test
    fun testCalculateTax_UnknownPaymentSystem() {
        val paymentSystem = "Unknown"
        val monthlySum = 10000
        val dailySum = 200
        val amount = 750

        val result = calculateTax(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(0, result)
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

    @Test
    fun checkLimitsPaymentSystem() {
        var paymentSystem = "Union Pay"
        var monthlySum = 10000
        var dailySum = 200
        var amount = 750

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(false, result)
    }
    @Test
    fun checkLimitsDaily() {
        var paymentSystem = "Mastercard"
        var monthlySum = 0
        var dailySum = 10000
        var amount = 750

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(true, result)
    }
    @Test
    fun checkLimitsMonthly() {
        var paymentSystem = "Mastercard"
        var monthlySum = 579000
        var dailySum = 20000
        var amount = 750

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(true, result)
    }
    @Test
    fun checkLimitsMonthlyVKPay() {
        var paymentSystem = "VK Pay"
        var monthlySum = 30000
        var dailySum = 0
        var amount = 9000

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(true, result)
    }

    @Test
    fun checkLimitsVKPay() {
        var paymentSystem = "VK Pay"
        var monthlySum = 0
        var dailySum = 0
        var amount = 10000

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)

        assertEquals(true, result)
    }
    @Test
    fun testCheckLimits_Mastercard_Maestro_MonthlyLimit() {
        val paymentSystem = "Mastercard"
        val monthlySum = 580000
        val dailySum = 1000
        val amount = 3000

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(true,result)
    }

    @Test
    fun testCheckLimits_Mastercard_Maestro_DailyLimit() {
        val paymentSystem = "Mastercard"
        val monthlySum = 20000
        val dailySum = 15000
        val amount = 3000

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(true,result)
    }

    @Test
    fun testCheckLimits_VKPay_MonthlyLimit() {
        val paymentSystem = "VK Pay"
        val monthlySum = 45000
        val dailySum = 1000
        val amount = 3000

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertFalse(result)
    }

    @Test
    fun testCheckLimits_VKPay_AmountLimit() {
        val paymentSystem = "VK Pay"
        val monthlySum = 20000
        val dailySum = 1000
        val amount = 16000

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertFalse(result)
    }

    @Test
    fun testCheckLimits_UnknownPaymentSystem() {
        val paymentSystem = "Unknown"
        val monthlySum = 10000
        val dailySum = 200
        val amount = 750

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertFalse(result)
    }

    @Test
    fun testCheckLimits_PassingLimits() {
        val paymentSystem = "MIR"
        val monthlySum = 50000
        val dailySum = 1000
        val amount = 3000

        val result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertTrue(result)
    }
}