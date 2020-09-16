package providers

import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import providers.definition.UuidProvider

class UuidProviderImp : UuidProvider {
    override val uuid: String
        get() = uuid4().toString()
}