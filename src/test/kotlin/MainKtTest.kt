import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

 //1 "Mastercard", "Maestro", "Visa", "MIR" (monthlySum + dailySum + amount > 600000)
    @Test
    fun checkLimits_1() {
        var paymentSystem = "Mastercard"
        var monthlySum = 500000
        var dailySum = 100000
        var amount = 10000

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(true,result)
    }


    //2 "Mastercard", "Maestro", "Visa", "MIR" (monthlySum + dailySum + amount < 600000)
    @Test
    fun checkLimits_2() {
        var paymentSystem = "Maestro"
        var monthlySum = 50000
        var dailySum = 10000
        var amount = 10000

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(true,result)
    }


    //3 "Mastercard", "Maestro", "Visa", "MIR" (dailySum + amount > 150000)
    @Test
    fun checkLimits_3() {
        var paymentSystem = "Visa"
        var monthlySum = 50000
        var dailySum = 10000
        var amount = 200000

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(false,result)
    }

    //4 "Mastercard", "Maestro", "Visa", "MIR" (dailySum + amount < 150000)
    @Test
    fun checkLimits_4() {
        var paymentSystem = "MIR"
        var monthlySum = 50000
        var dailySum = 10000
        var amount = 20000

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(true,result)
    }

    //5 "VK Pay" (monthlySum + dailySum + amount > 40000)
    @Test
    fun checkLimits_5() {
        var paymentSystem = "VK Pay"
        var monthlySum = 20000
        var dailySum = 10000
        var amount = 15000

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(false,result)
    }

    //6 "VK Pay" (monthlySum + dailySum + amount < 40000)
    @Test
    fun checkLimits_6() {
        var paymentSystem = "VK Pay"
        var monthlySum = 2000
        var dailySum = 1000
        var amount = 1500

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(true,result)
    }

    //7 "VK Pay" (amount > 15000)
    @Test
    fun checkLimits_7() {
        var paymentSystem = "VK Pay"
        var monthlySum = 2000
        var dailySum = 1000
        var amount = 25000

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(false,result)
    }

    //8 "VK Pay" (amount < 15000)
    @Test
    fun checkLimits_8() {
        var paymentSystem = "VK Pay"
        var monthlySum = 2000
        var dailySum = 1000
        var amount = 2500

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(true,result)
    }

    //9 "Неизвестная платежная система"
    @Test
    fun checkLimits_9() {
        var paymentSystem = "Unknown"
        var monthlySum = 2000
        var dailySum = 1000
        var amount = 2500

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(false,result)
    }


    //10 "Mastercard", "Maestro" (monthlySum + dailySum + amount > 75000)
    @Test
    fun calculateTax() {
        var paymentSystem = "Mastercard"
        var monthlySum = 50000
        var dailySum = 10000
        var amount = 20000

        var result = calculateTax(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(140,result)
    }

    //11 "Mastercard", "Maestro" (monthlySum + dailySum + amount < 75000)
    @Test
    fun calculateTax_1() {
        var paymentSystem = "Maestro"
        var monthlySum = 50000
        var dailySum = 10000
        var amount = 2000

        var result = calculateTax(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(0,result)
    }

    //12 "Visa", "MIR" (amount * 0.0075 > 35)
    @Test
    fun calculateTax_2() {
        var paymentSystem = "Visa"
        var monthlySum = 50000
        var dailySum = 10000
        var amount = 2000

        var result = calculateTax(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(35,result)
    }


    //13 "Visa", "MIR" (amount * 0.0075 < 35)
    @Test
    fun calculateTax_3() {
        var paymentSystem = "MIR"
        var monthlySum = 5000
        var dailySum = 1000
        var amount = 20000

        var result = calculateTax(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(150,result)
    }


    //14 "VK Pay"
    @Test
    fun calculateTax_4() {
        var paymentSystem = "VK Pay"
        var monthlySum = 5000
        var dailySum = 1000
        var amount = 2000

        var result = calculateTax(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(0,result)
    }
    //15 "Unknown"
    @Test
    fun calculateTax_5() {
        var paymentSystem = "Unknown"
        var monthlySum = 5000
        var dailySum = 1000
        var amount = 2000

        var result = checkLimits(paymentSystem, monthlySum, dailySum, amount)
        assertEquals(false,result)
    }


}