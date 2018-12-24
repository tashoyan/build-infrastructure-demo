package com.github.tashoyan.demo

import org.scalatest.FunSuite
import Lib._

class LibTest extends FunSuite {

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
