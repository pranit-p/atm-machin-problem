package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe



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
    "should print a receipt if money is withdrawn successfully using mokk" {
        val fakePrinter = FakePrinter("",0)
        val fakeBankingService = FakeBankingService(false)
        AutoTellerMachine(fakePrinter,fakeBankingService).withdraw(10)
        fakePrinter.messageString shouldBe "Amount is not withdrawn Successfully"
    }
    

})

