package com.github.tashoyan.demo

import org.apache.commons.lang3.Validate
import org.slf4j.{Logger, LoggerFactory}

/**
  * Dummy library.
  */
object Lib {

  val logger: Logger = LoggerFactory.getLogger(getClass)

  /**
    * Returns reverse string.
    *
    * @param str String to reverse.
    * @return Reverse string.
    * @throws NullPointerException Argument is null.
    */
  def reverseString(str: String): String = {
    Validate.notNull(str, "Argument must not be null")

    if (logger.isDebugEnabled) {
      logger.debug("reverse for '{}'", str)
    }

    str.reverse
  }

}
