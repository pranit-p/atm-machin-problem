package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals


class AutoTellerMachineTest: StringSpec({
    "should print a receipt if money is withdrawn successfully" {
        val fakePrinter = FakePrinter("",0)
        val fakeBankingService = FakeBankingService(true)
        AutoTellerMachine(fakePrinter,fakeBankingService).withdraw(10)
        fakePrinter.messageString shouldBe "Amount withdrawn Successfully"
        fakePrinter.totalReceipt shouldBe 1
    }

    "should throw exception if banking service throws an exception" {
        val fakePrinter = FakePrinter("",0)
        val fakeBankingService = FakeBankingService(false)
        AutoTellerMachine(fakePrinter,fakeBankingService).withdraw(10)
        fakePrinter.messageString shouldBe "Amount is not withdrawn Successfully"
    }
    "test should print a receipt if money is withdrawn successfully using mokk" {
        val fakePrinter =  mockk<Printer>()
        val fakeBankingService = mockk<BankingService>()
        every { fakeBankingService.withdraw(10) } returns Unit
        AutoTellerMachine(fakePrinter,fakeBankingService).withdraw(10)

        verify { fakePrinter.print("Amount withdrawn Successfully") }
        fakePrinter.messageString shouldBe "Amount withdrawn Successfully"


    }


})

