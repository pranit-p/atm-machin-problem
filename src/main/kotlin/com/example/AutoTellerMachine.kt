package com.example


class AutoTellerMachine(val printer:Printer,val banking:BankingService){
    fun withdraw(amount: Int) {
        try{
            banking.withdraw(amount)
            printer.print("Amount withdrawn Successfully")
        }catch(e:Exception){
            printer.print("Amount is not withdrawn Successfully")
        }

    }
}
