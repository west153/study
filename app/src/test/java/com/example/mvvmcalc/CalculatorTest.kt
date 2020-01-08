package com.example.mvvmcalc

import com.example.mvvmcalc.utils.Calculator
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class CalculatorTest {
  @Test
  fun addTest() {
    // given
    val calculator = Calculator()

    // when
    val result = calculator.calculation("1+2")

    assertEquals("3", result)
  }
}
