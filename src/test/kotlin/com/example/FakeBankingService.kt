package com.example

class FakeBankingService(var flag:Boolean) :BankingService{
    override fun withdraw(amount: Int) {
       if(flag==false) throw Exception("Something went is wrong")
    }
}