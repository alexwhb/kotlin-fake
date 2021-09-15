package com.blackstone.fake.providers.definition

interface PhoneNumberProvider : Provider {
    fun formats(): String
}