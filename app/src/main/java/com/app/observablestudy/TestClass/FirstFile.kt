package com.app.observablestudy.TestClass


internal val a = 20
private val b = 20

//protected val c = 20 //class or member cannot be PROTECTED in top level
public val d = 20

class Accessibility {

    val test_a = a // a is visible          // private is accessible within same module
    val test_b = b  //b is accessible        // private is accessible within same file
    // val test_c = c  //c is not accessible    // class or member cannot be PROTECTED in top level
    val test_d = d  //b is accessible        // public is accessible within the project
}
