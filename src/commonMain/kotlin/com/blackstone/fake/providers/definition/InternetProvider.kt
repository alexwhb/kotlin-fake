package com.blackstone.fake.providers.definition

interface InternetProvider : Provider {

    val freeEmail: String
    val domainSuffix: String
    val companyEmail: String
    val userName: String
    val password: String
    val domainName: String
    val slug: String
    val ipv4: String
    val ipv6: String
    val macAddress: String

}