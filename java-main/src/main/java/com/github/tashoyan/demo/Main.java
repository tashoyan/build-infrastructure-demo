package com.github.tashoyan.demo;

import com.github.tashoyan.log.JulSlf4jBridge;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.github.tashoyan.demo.Lib.reverseString;

/**
 * Dummy main class.
 */
public final class Main {

    private static final String HEADER_RESOURCE = "header-message";

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private Main() {
        // No instances
    }

    /**
     * Dummy main method.
     *
     * @param args
     *            Arguments are ignored.
     */
    public static void main(String[] args) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Running with args: {}", String.join(",", args));
        }

        JulSlf4jBridge.redirectJul();

        System.out.println(getHeaderMessage());

        String str = "dummy";
        System.out.println("Reversed '" + str + "' is '" + reverseString(str) + "'");
    }

    private static String getHeaderMessage() {
        return getMessageFromResource(HEADER_RESOURCE);
    }

    private static String getMessageFromResource(String resourceName) {
        InputStream resourceStream = Main.class.getResourceAsStream(resourceName);
        if (resourceStream == null) {
            throw new InternalError("Resource not found: " + resourceName + "; corrupted installation");
        }
        try {
            return IOUtils.toString(resourceStream, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse resource " + resourceName, e);
        } finally {
            try {
                resourceStream.close();
            } catch (IOException e) {
                LOGGER.error("Error closing resource stream", e);
            }
        }
    }

}
