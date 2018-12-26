package com.github.tashoyan.demo;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.github.tashoyan.demo.Lib.reverseString;

/**
 * Dummy main class.
 */
public final class Main {

    private static final String HEADER_RESOURCE = "header-message";

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
                // TODO Log error
                System.err.println(e.getMessage());
            }
        }
    }

}
