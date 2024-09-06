package org.example;

import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public interface LibraryBridge extends Library {
    class GoSlice extends Structure {
        public static class ByValue extends GoSlice implements Structure.ByValue {
        }

        public Pointer data;
        public long len;
        public long cap;

        @Override
        protected List<String> getFieldOrder() {
            return List.of("data", "len", "cap");
        }
    }

    class GoString extends Structure {
        public static class ByValue extends GoString implements Structure.ByValue {
        }

        public String p;
        public long n;

        @Override
        protected List<String> getFieldOrder() {
            return List.of("p", "n");
        }
    }

    boolean Contains(GoSlice.ByValue values,
                     GoString.ByValue value);
}
