package com.blackstone.fake.providers.definition

interface NameProvider : Provider {
    val name: String
    val nameWithMiddle: String
    val firstName: String
    val lastName: String
    val prefix: String
    val suffix: String
    val title: String
}