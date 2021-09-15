package com.blackstone.fake.providers

import com.blackstone.fake.Fake.Companion.fake
import com.blackstone.fake.providers.definition.JobProvider

class JobProviderImp : BaseProvider(), JobProvider {
    override val field: String
        get() = getValue("field") { fake.fetch("job.field") }
    override val seniority: String
        get() = getValue("seniority") { fake.fetch("job.seniority") }
    override val position: String
        get() = getValue("position") { fake.fetch("job.position") }
    override val title: String
        get() = getValue("title") { fake.fetch("job.title") }
    override val keySkill: String
        get() = getValue("keySkill") { fake.fetch("job.key_skills") }
}