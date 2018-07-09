package atm.bloodworkxgaming.woodenflint

import net.minecraftforge.common.config.Property
import java.io.Serializable

private object UNINITIALIZED_VALUE_PROP

class LazyProp<out T>(val defaultValue: T) : Lazy<T>, Serializable {
    @kotlin.jvm.Volatile
    private var _value: Any? = UNINITIALIZED_VALUE_PROP
    private var property: Property? = null
        set(value) {
            field = value
            this._value = UNINITIALIZED_VALUE_PROP
        }

    override val value: T
        get() {
            if (_value !== UNINITIALIZED_VALUE_PROP) {
                println("initializer = $_value")
                @Suppress("UNCHECKED_CAST")
                return _value as T
            }

            return synchronized(this) {
                val p = property ?: return defaultValue
                println("I'm here ${p.type}")

                if (_value !== UNINITIALIZED_VALUE_PROP) {
                    @Suppress("UNCHECKED_CAST") (_value as T)
                } else {
                    val typedValue = when (p.type) {
                        Property.Type.BOOLEAN -> if (p.isList) p.booleanList else p.boolean
                        Property.Type.STRING -> if (p.isList) p.stringList else p.string
                        Property.Type.INTEGER -> if (p.isList) p.intList else p.int
                        Property.Type.DOUBLE -> if (p.isList) p.doubleList else p.double
                        Property.Type.COLOR -> if (p.isList) p.string else p.string
                        Property.Type.MOD_ID -> if (p.isList) p.string else p.string
                        null -> null
                    }

                    println("typedValue = ${typedValue}")

                    _value = typedValue

                    @Suppress("UNCHECKED_CAST")
                    typedValue as T
                }
            }
        }

    override fun isInitialized(): Boolean = _value !== UNINITIALIZED_VALUE_PROP

    operator fun plusAssign(prop: Property?) {
        this.property = prop
    }

    override fun toString(): String = if (isInitialized()) value.toString() else "Lazy value not initialized yet."
}