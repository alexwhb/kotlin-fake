package com.blackstone.fake.providers

import com.benasher44.uuid.uuid4
import com.blackstone.fake.providers.definition.UuidProvider

class UuidProviderImp : UuidProvider {
    override val uuid: String get() = uuid4().toString()
}