package ru.netology

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.round

class TransfersKtTest {

    @Test
    fun transfersKt_isDayTransferLimitChecked() {
        val cardType = "Мир"
        val thisMonthTransferredAmount = 0
        val transferAmount = 151_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Превыышен дневной лимит перевода, перевод заблокирован", result)

    }

    @Test
    fun transfersKt_isMonthTransferLimitChecked() {
        val cardType = "Мир"
        val thisMonthTransferredAmount = 451_000_00
        val transferAmount = 150_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Превышен месячный лимит перевода, перевод заблокирован", result)

    }

    @Test
    fun transfersKt_visaFeeCalculation() {
        val cardType = "Visa"
        val thisMonthTransferredAmount = 0
        val transferAmount = 100_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 750.0 руб.", result)

    }

    @Test
    fun transfersKt_visaMinFeeCalculation() {
        val cardType = "Visa"
        val thisMonthTransferredAmount = 0
        val transferAmount = 100_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 35.0 руб.", result)

    }

    @Test
    fun transfersKt_mirFeeCalculation() {
        val cardType = "Мир"
        val thisMonthTransferredAmount = 0
        val transferAmount = 100_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 750.0 руб.", result)

    }

    @Test
    fun transfersKt_mirMinFeeCalculation() {
        val cardType = "Мир"
        val thisMonthTransferredAmount = 0
        val transferAmount = 100_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 35.0 руб.", result)

    }

    @Test
    fun transfersKt_isVkpayOnceTransferLimitChecked() {
        val cardType = "VK Pay"
        val thisMonthTransferredAmount = 0
        val transferAmount = 16_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Превышен лимит единовременного перевода VK Pay", result)

    }

    @Test
    fun transfersKt_isVkpayMonthTransferLimitChecked() {
        val cardType = "VK Pay"
        val thisMonthTransferredAmount = 0
        val transferAmount = 11_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Превышен месячный лимит переводв VK Pay", result)

    }

    @Test
    fun transfersKt_vkpayFeeCalculation() {
        val cardType = "VK Pay"
        val thisMonthTransferredAmount = 0
        val transferAmount = 10_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 0.0 руб.", result)

    }

    @Test
    fun transfersKt_mastercardStandardTransferFeeCalculation() {
        val cardType = "Mastercard"
        val thisMonthTransferredAmount = 0
        val transferAmount = 10_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 0.0 руб.", result)

    }

    @Test
    fun transfersKt_mastercardExtraTransferFeeCalculation() {
        val cardType = "Mastercard"
        val thisMonthTransferredAmount = 0
        val transferAmount = 150_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 470.6 руб.", result)

    }

    @Test
    fun transfersKt_maestroStandardTransferFeeCalculation() {
        val cardType = "Maestro"
        val thisMonthTransferredAmount = 0
        val transferAmount = 10_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 0.0 руб.", result)

    }

    @Test
    fun transfersKt_maestroExtraTransferFeeCalculation() {
        val cardType = "Maestro"
        val thisMonthTransferredAmount = 0
        val transferAmount = 150_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 470.6 руб.", result)

    }

    @Test
    fun transfersKt_paySystemCheck() {
        val cardType = "unknown"
        val thisMonthTransferredAmount = 0
        val transferAmount = 150_000_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Неизвестная платежная система, перевод заблокирован", result)

    }
    @Test
    fun transfersKt_maestroMinTransferFeeCalculation() {
        val cardType = "Maestro"
        val thisMonthTransferredAmount = 0
        val transferAmount = 100_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 20.6 руб.", result)

    }
    @Test
    fun transfersKt_mastercardMinTransferFeeCalculation() {
        val cardType = "Maestro"
        val thisMonthTransferredAmount = 0
        val transferAmount = 100_00
        val result = ru.netology.transfer(cardType, thisMonthTransferredAmount, transferAmount)
        assertEquals("Комиссия за перевод: 20.6 руб.", result)

    }
}