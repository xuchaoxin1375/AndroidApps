package com.zjgsu.xcx.fragment

/**
 * Calls the given block on a nullable variable.
Inside run, the object's members are accessed without its name.
run returns the length of the given String if it's not null
 */
fun main() {
    fun getNullableLength(ns: String?): Int? {
        println("for \"$ns\":")
        val value = ns?.run {
            /*
                the run{} function is similar to mean that: object.run(this){ the code block in the run funciton}
             */
            /**
             * Calls the given block on a nullable variable.
            todo:Inside run, the object's members are accessed without its name.
            run{} returns the length of the given String if it's not null
             */
            println("\tis empty? " + isEmpty())                    // 2
            println("\tlength = $length")
            /*test the return value of the run{}*/
//            length
//            "ok"
        }
        return ns?.run {
            println("testing the return directly.")
            length
        }
//        println("the value of the value of the run{} returned:$value")
    }
    getNullableLength(null)
    getNullableLength("")
    val value = getNullableLength("some string with Kotlin")
    print("print the value returned by run{}:$value")
}