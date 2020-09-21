package com.blackstone.fake.providers.definition

interface AddressProvider : Provider {
    val city: String
    val streetAddress: String
    val buildingNumber: String
    val zipCode: String
    val state: String
    val stateAbbreviation: String
}