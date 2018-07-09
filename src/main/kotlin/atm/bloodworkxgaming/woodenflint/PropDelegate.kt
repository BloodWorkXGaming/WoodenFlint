package atm.bloodworkxgaming.woodenflint

import net.minecraftforge.common.config.Property
import java.io.Serializable
import kotlin.reflect.KProperty

private object UNINITIALIZED_VALUE_DEL

@Suppress("UNCHECKED_CAST")
class PropDelegate<out T>(prop: Property) : Serializable {
    @kotlin.jvm.Volatile
    private var _value: Any? = UNINITIALIZED_VALUE_DEL
    private var property: Property = prop
        set(value) {
            field = value
            this._value = UNINITIALIZED_VALUE_DEL
        }

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): T {
        return when (property.type) {
            Property.Type.BOOLEAN -> if (property.isList) property.booleanList else property.boolean
            Property.Type.STRING -> if (property.isList) property.stringList else property.string
            Property.Type.INTEGER -> if (property.isList) property.intList else property.int
            Property.Type.DOUBLE -> if (property.isList) property.doubleList else property.double
            Property.Type.COLOR -> if (property.isList) property.string else property.string
            Property.Type.MOD_ID -> if (property.isList) property.string else property.string
            null -> null
        } as T
    }

    /*
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
        */

    // override fun isInitialized(): Boolean = _value !== UNINITIALIZED_VALUE_PROP

    operator fun plusAssign(prop: Property) {
        this.property = prop
    }

    // override fun toString(): String = if (isInitialized()) value.toString() else "Lazy value not initialized yet."
}