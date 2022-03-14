package com.app.observablestudy.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.observablestudy.R
import com.app.observablestudy.TestClass.*
import java.util.*
import kotlin.collections.ArrayList


class StudyBasicsActivity : AppCompatActivity() {

    companion object {
        const val NAME = "ryan"
        fun getName(): String {
            return "hi"
        }
    }

    private var i = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_basics)
        testCollections()
    }

    private fun testInterface() {
        val mR1 = CustomButton()
        mR1.name = "yamaha R1"
        mR1.onClick()
    }

    private fun testInheritance() {
        val mR1 = Engine("100cc")
        mR1.name = "yamaha R1" //since name is open property it can be overriden in subclass
        mR1.address =
            "xyz" // since address is not open it is not overriden in subclass, but still it can be access since its superclass property.
    }

    private fun testAbstractClass() {
        //val mDog = AbstractAnimal() //cannot create instance of abstract class
        var mDog = TestAnimal()
        mDog.mName = "syberian huskey" // can access parent class object because of inheritance
        mDog.testOpenMethod()
    }

    private fun testExtensionFunction() {
        var mDog = Dog()
        mDog.mColor = "red"
        var mColor = "red"

        Log.d("extension_function", "" + mDog.getColorBreed(mDog.mColor))
        Log.d("infix_function", " extension ${mDog getColorBreed mColor}")
        Log.d("infix_function", " member ${mDog getColor mColor}")
    }

    fun Dog.getBreed(): String {
        return "huskey"
    }

    infix fun Dog.getColorBreed(color: String): String { //for making an infix function just add infix keyword and only 1 parameter should be present
        return "${color} huskey"
    }


    private fun testClassInitialisation() {
        val mEngine = Engine("1000cc")
        mEngine.engineType

        val mBenzEngine = Engine("3000", 6)
        mBenzEngine.xyz
        Log.d("override", "" + mBenzEngine.xyz)
    }


    private fun testScopeFunctions() {
        testLetFunction()
        testAlsoFunction()
        testApplyFunction()
        testRunFunciton()
        testWithFunciton()

    }

    private fun testWithFunciton() {

        var mPerson: Person? = null
//        var mPerson = Person()
        with(mPerson) {
            this?.name = "gautham"
            this?.age = 26
            this?.address = "palakkad"
            Log.d("person_details", "with_scope-->\n")
            mPerson?.displayDetails()

        }

    }

    private fun testRunFunciton() {
        var mPerson: Person? = null
        mPerson?.run {
            name = "ajas"
            age = 35
            address = "kochi"
            Log.d("run scope", "display details")
            Log.d("person_details", "run_scope-->\n")
            this.displayDetails()
        }


    }

    private fun testApplyFunction() {
        val list = mutableListOf<Int>(1, 2, 3, 4, 5, 10, 20)
        var a = list?.apply {
            list.add(10)
        }

        val person = Person()
        var mPerson = person?.apply {
            name = "junaid"
            address = "edappal"
            age = 33
        }

        mPerson?.also {
            mPerson.displayDetails()
        }
    }


    private fun testLetFunction() {
        var number1: Int? = null
        number1 = 10
        val x = number1?.let {
            val number2 = it + 1
            number2
        } ?: 3
        Log.d("let_scope", "" + x)
    }


    private fun testAlsoFunction() {
        var list = mutableListOf<Int>(1, 2, 3)
        var a = list
        a = list?.also {
            it.add(10)
            it.add(100)
            it.add(1000)
            it.remove(2)
        }
    }


    private fun testDataClass() {
        val mCBR1 = Bike("CBR")
        val mCBR2 = Bike("CBR")

        val mAMG1 = Engine("AMG")
        val mAMG2 = Engine("AMG")

        if (mCBR1.equals(mCBR2)) {
            Log.d("data_class_bool_val", "true")
        } else {
            Log.d("data_class_bool_val", "false")
        }

        if (mAMG1.equals(mAMG2)) {
            Log.d("class_bool_val", "true")
        } else {
            Log.d("class_bool_val", "false")
        }
    }

    //functions as expression
    fun getMax(a: Int, b: Int): Int = if (a > b) {
        Log.d("a", "is higher")
        a
    } else {
        Log.d("b", "is higher")
        b
    }


    fun getSquaredi() = (i * i).also {
        i++
    }


    //region array

    fun testCollections() {
//        testArray()
//        testMutabaleAndImmutable()
//        testMutabaleAndImmutableHashMap()
//        testMutabaleAndImmutableSet()
        testArrayListAndVectors()

    }

    private fun testArrayListAndVectors() {

        val mArrayList = ArrayList<String>()
        mArrayList.add("hello")
        mArrayList.add("hi")
        mArrayList.add("how")
        mArrayList.add("are")
        mArrayList.add("you")

        val mIterator = mArrayList.iterator()
        while (mIterator.hasNext()){
            Log.d("mArrayList",""+mIterator.next())
        }


        val mVectorList = Vector<String>()
        mVectorList.add("i")
        mVectorList.add("am")
        mVectorList.add("fine")
        mVectorList.add("deaar")

        val mIteratorVector = mVectorList.iterator()
        while (mIteratorVector.hasNext()){
            Log.d("mVectorList",""+mIteratorVector.next())
        }
    }

    private fun testMutabaleAndImmutableHashMap() {
        var mImmutableHashMap = mapOf<String, String>("a" to "b", "c" to "d", "e" to "f") //immutable and fixed size
        for (element in mImmutableHashMap){
            Log.d("mImmutable_Hash_map",""+element.key)
        }

        var mMutableMap = mutableMapOf<String,String>()//mutable and non-fixed size
        mMutableMap.put("a","b_m")
        mMutableMap.put("c","d_m")
        mMutableMap.put("e","f_m")
        mMutableMap.put("g","h_m")
        for (element in mMutableMap){
            Log.d("mutable_Hash_map",""+element.value)
        }
    }

    private fun testMutabaleAndImmutableSet() {
        //Set ->unique elements

        var mImmutableSet = setOf<Int>(1,2,3,22,10,9,2,22) //mutable
        for (element in mImmutableSet){
//            Log.d("mImmutable_Set",""+element)
        }

        var mMutableSet = mutableSetOf<Int>() //mutable
        mMutableSet.add(2)
        mMutableSet.add(3)
        mMutableSet.add(4)
        mMutableSet.add(9)
        mMutableSet.add(9)
        mMutableSet.add(20)

        mMutableSet.remove(3)
        for (element in mMutableSet){
//            Log.d("mutable_Set",""+element)
        }


        //HashSet -> order of elements is not garunteed.

        var mMutableHashSet = hashSetOf<Int>() //mutable
        mMutableHashSet.add(2)
        mMutableHashSet.add(311)
        mMutableHashSet.add(430)
        mMutableHashSet.add(9)
        mMutableHashSet.add(9)
        mMutableHashSet.add(30)
        mMutableHashSet.add(231)
        mMutableHashSet.add(25)
        mMutableHashSet.add(23)
        for (element in mMutableHashSet){
            Log.d("mutable_Hash_set",""+element)
        }

    }

    private fun testMutabaleAndImmutable() {
        var mImmutableList = listOf<String>("muhammed", "raheez", "rahman") // immutable,fixed size
        for (element in mImmutableList) {
            Log.d("array_elements", " " + element)
        }


        var mMutableList = mutableListOf<String>()
        mMutableList.add("muhammed")
        mMutableList.add("raheez")
        mMutableList.add("rahman")

        mMutableList.set(1, "ran")
        for (element in mMutableList) {
            Log.d("array_elements", " " + element)
        }

    }

    fun testArray() {

        var mArray = Array<Int>(5) { 0 }


        for (elements in mArray) {
            //Log.d("array_elements"," "+elements.toString())
            println(elements.toString())
        }
    }

}

