package com.blackstone.fake.providers.definition

interface BarcodeProvider : Provider {
    val ean13: String
    val ean8: String
    val isbn10: String
    val isbn13: String
}