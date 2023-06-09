fun main() {

    var paymentSystem = "VK Pay"
    var monthlySum = 10000
    var dailySum = 200
    var amount = 750

if (checkLimits(paymentSystem, monthlySum, dailySum, amount)) {
    var tax = calculateTax(paymentSystem, monthlySum,dailySum,amount)
    println(tax)
}
}
    fun checkLimits(paymentSystem: String, monthlySum: Int, dailySum: Int, amount: Int): Boolean {
        when (paymentSystem) {
            "Mastercard", "Maestro", "Visa", "MIR" -> {
                if (monthlySum + dailySum + amount > 600000) {
                    println("Превышен месячный лимит переводов")
                    return false
                }
                if (dailySum + amount > 150000) {
                    println("Превышен дневной лимит переводов")
                    return false
                }
            }
            "VK Pay" -> {
                if (monthlySum + dailySum + amount > 40000) {
                    println("Превышен месячный лимит переводов")
                    return false
                }
                if (amount > 15000) {
                    println("Превышен лимит перевода")
                    return false
                }
            }
            else -> {
                println("Неизвестная платежная система")
                return false
            }
        }
        return true
    }



fun calculateTax(paymentSystem: String, monthlySum: Int, dailySum: Int, amount:Int): Int {
    return when (paymentSystem) {
        "Mastercard", "Maestro" -> if (monthlySum + dailySum + amount > 75000) (amount * 0.006 + 20).toInt() else 0
        "Visa", "MIR" -> if (amount * 0.0075 >= 35) (amount * 0.0075).toInt() else 35
        else -> {
            0
        }
    }
}




