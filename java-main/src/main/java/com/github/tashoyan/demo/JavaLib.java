package com.github.tashoyan.demo;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dummy Java library.
 */
public final class JavaLib {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaLib.class);

    private JavaLib() {
        // No instances
    }

    /**
     * Returns upper case string.
     *
     * @param str
     *            Original string.
     * @return String in the upper case.
     * @throws NullPointerException
     *             Argument is null.
     */
    public static String upperCaseString(String str) {
        Validate.notNull(str, "Argument must not be null");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("upper for '{}'", str);
        }

        return str.toUpperCase();
    }

}
