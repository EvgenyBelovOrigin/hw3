package ru.netology

import kotlin.math.round

fun main() {
    var transferResult = transfer("Mastercard", transferAmount = 150_000_00)
    println(transferResult)
}

fun transfer(cardType: String = "Мир", thisMonthTransferredAmount: Int = 0, transferAmount: Int): String {
    val dayLimit = 150_000_00 //копейки
    val monthLimit = 600_000_00
    if (transferAmount > dayLimit) return "Превыышен дневной лимит перевода, перевод заблокирован"
    if (transferAmount + thisMonthTransferredAmount > monthLimit)
        return "Превышен месячный лимит перевода, перевод заблокирован"
    val mastercardmaestroMonthLimit = 75_000_00
    val mastercardmaestroMinTransfer = 300_00
    val mastercardmaestroMonthTransferredAmount = 100_00
    val mastercardmaestroExtraFeePercent = 0.006
    val mastercardmaestroExtraFeeConst = 20_00
    val visamirFee = 0.0075
    val visamirMinFee = 35_00
    val vkpayFee = 0.0
    val vkpayMonthLimit = 40_000_00
    val vkpayOnceTransferLimit = 15_000_00
    val vkpayMonthTransferredAmount = 30_000_00

    var feeResult: Double = 0.0

    when (cardType) {
        "Mastercard", "Maestro" ->
            feeResult =
                when {
                    mastercardmaestroMinTransfer > transferAmount + mastercardmaestroMonthTransferredAmount ->
                        transferAmount * mastercardmaestroExtraFeePercent + mastercardmaestroExtraFeeConst

                    mastercardmaestroMonthTransferredAmount > mastercardmaestroMonthLimit ->
                        transferAmount * mastercardmaestroExtraFeePercent + mastercardmaestroExtraFeeConst

                    transferAmount + mastercardmaestroMonthTransferredAmount > mastercardmaestroMonthLimit ->
                        (transferAmount + mastercardmaestroMonthTransferredAmount - mastercardmaestroMonthLimit) *
                                mastercardmaestroExtraFeePercent + mastercardmaestroExtraFeeConst


                    else -> 0.0
                }


        "Visa", "Мир" -> feeResult =
            if (transferAmount * visamirFee > visamirMinFee)
                transferAmount * visamirFee
            else (visamirMinFee.toDouble())

        "VK Pay" ->
            when {
                transferAmount > vkpayOnceTransferLimit ->
                    return "Превышен лимит единовременного перевода VK Pay"

                transferAmount + vkpayMonthTransferredAmount > vkpayMonthLimit ->
                    return "Превышен месячный лимит переводв VK Pay"

                else -> feeResult = vkpayFee * transferAmount

            }

        else -> return "Неизвестная платежная система, перевод заблокирован"

    }
    return "Комиссия за перевод: ${round(feeResult) / 100} руб."

}