package com.github.tashoyan.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Provides a function to redirect Java Util Logging to SLF4J.
 * See here: <a href="https://www.slf4j.org/legacy.html#jul-to-slf4j">jul-to-slf4j</a>
 * and here: <a href="https://www.slf4j.org/api/org/slf4j/bridge/SLF4JBridgeHandler.html">SLF4JBridgeHandler</a>.
 */
public final class JulSlf4jBridge {

    private static final Logger LOGGER = LoggerFactory.getLogger(JulSlf4jBridge.class);

    private static boolean isJulRedirected;

    private JulSlf4jBridge() {
        /* No instances */
    }

    /**
     * Enables the redirect of Java Util Logging to SLF4J.
     */
    public static synchronized void redirectJul() {
        if (isJulRedirected) {
            LOGGER.info("Java Util Logging is already redirected to SLF4J");
            return;
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Redirecting Java Util Logging to SLF4J");
        }
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        isJulRedirected = true;
    }

}
