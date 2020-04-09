package com.github.tashoyan.demo

import com.github.tashoyan.demo.Lib._
import org.scalatest.funsuite.AnyFunSuite

class LibTest extends AnyFunSuite {

  test("reverseString - null arg") {
    intercept[NullPointerException] {
      reverseString(null)
    }
  }

  test("reverseString - empty arg") {
    assert(reverseString("") === "", "Expected empty string")
  }

  test("reverseString - normal arg") {
    assert(reverseString("abc") === "cba")
  }

}
