package org.example;

import java.io.IOException;

import com.sun.jna.Native;

public class LibraryLoader {
    public static LibraryBridge INSTANCE;

    static {
        loadLib();
    }

    private static void loadLib() {
        try {
            final var file = Native.extractFromResourcePath("library.so", LibraryLoader.class.getClassLoader());
            INSTANCE = Native.load(file.getAbsolutePath(), LibraryBridge.class);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
