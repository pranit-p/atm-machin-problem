package com.example

class FakePrinter(var messageString :String,var totalReceipt :Int):Printer {
    override fun print(text: String) {
        totalReceipt += 1
        messageString=text
    }
}