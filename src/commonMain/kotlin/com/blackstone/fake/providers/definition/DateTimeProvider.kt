package com.blackstone.fake.providers.definition

interface DateTimeProvider : Provider {
    val dateFormatter: String
    val timeFormatter: String
    val dateTimeFormatter: String
    val dateTimeTzFormatter: String
}