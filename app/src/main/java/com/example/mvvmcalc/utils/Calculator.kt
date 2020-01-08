package com.example.mvvmcalc.utils

import java.util.*


class Calculator {

  fun calculation(value: String): String {
    return calculation(toPostfix(value)).toString()
  }

  private fun toPostfix(value: String): List<Any> {
    val operatorStack = Stack<Char>()
    val postfix = arrayListOf<Any>()
    var num = 0
    var isNum = false

    value.forEach { c ->
      if (Character.isDigit(c)) {
        num = num * 10 + c.toString().toInt()
        isNum = true
      } else {
        if (isNum) {
          postfix.add(num)
          num = 0
          isNum = false
        }
        while (operatorStack.isNotEmpty() && getPriority(c) <= getPriority(operatorStack.peek())) {
          postfix.add(operatorStack.pop())
        }
        operatorStack.push(c)
      }
    }
    if (isNum) postfix.add(num)
    while (operatorStack.isNotEmpty()) {
      postfix.add(operatorStack.pop())
    }
    return postfix
  }

  private fun calculation(postfix: List<Any>): Int {
    val numStack = Stack<Int>()
    var num1: Int
    var num2: Int
    postfix.forEach {
      if (it is Char) {
        num2 = numStack.pop()
        num1 = numStack.pop()
        numStack.push(it.operate(num1, num2))
      } else
        numStack.add(it as Int)
    }
    return numStack.pop()
  }

  private fun getPriority(operator: Char): Int {
    return when (operator) {
      '*', '/' -> 2
      '+', '-' -> 1
      else -> 0
    }
  }


  private fun Char.operate(num1: Int, num2: Int): Int {
    return when (this) {
      '*' -> num1 * num2
      '/' -> num1 / num2
      '+' -> num1 + num2
      '-' -> num1 - num2
      else -> 0
    }
  }

}
