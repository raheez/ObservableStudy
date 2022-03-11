package com.app.observablestudy.TestClass


open class FirstClass {

    internal val a = 20
    private val b = 20
    protected val c = 20 //class or member can be PROTECTED inside class
    public val d = 20
}

class SecondClass : FirstClass() {
    val test_a = a // a is accessible          // internal is accessible within same module
    //val test_b = b //b is not accessible    // private is not accessible in derived class
    val test_c = c //c is accessible        // is visible in derived class
    val test_d = d //b is accessible        // public is accessible within the project
}

