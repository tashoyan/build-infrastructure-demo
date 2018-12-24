package com.github.tashoyan.demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        URL url = Main.class.getResource(resourceName);
        if (url == null) {
            throw new InternalError("Resource not found: " + resourceName + "; corrupted installation");
        }

        try {
            Path path = Paths.get(url.toURI());
            List<String> lines = Files.readAllLines(path);
            return String.join("\n", lines);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Failed to parse resource " + resourceName, e);
        }
    }

}
