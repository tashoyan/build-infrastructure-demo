package com.github.tashoyan.demo

import org.apache.commons.lang3.Validate

object Lib {

  def reverseString(str: String): String = {
    Validate.notNull(str, "Argument must not be null")
    str.reverse
  }

}
