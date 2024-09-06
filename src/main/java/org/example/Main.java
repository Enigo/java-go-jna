package org.example;

import java.util.List;

import com.sun.jna.Memory;

public class Main {

    public boolean containsGo(final List<String> valuesToCheck, final String valueToCheck) {
        final var values = convertValues(valuesToCheck);
        final var size = values[0].size();
        try (final var memory = new Memory((long) values.length * size)) {
            var offset = 0L;
            for (final var value : values) {
                value.write();
                memory.write(offset, value.getPointer().getByteArray(0, size), 0, size);
                offset += size;
            }

            final var valuesAsSlice = new LibraryBridge.GoSlice.ByValue();
            valuesAsSlice.data = memory;
            valuesAsSlice.len = values.length;
            valuesAsSlice.cap = values.length;

            return LibraryLoader.INSTANCE.Contains(valuesAsSlice, getGoString(valueToCheck));
        }
    }

    private static LibraryBridge.GoString[] convertValues(final List<String> valuesToCheck) {
        final var values = (LibraryBridge.GoString[]) new LibraryBridge.GoString().toArray(valuesToCheck.size());
        var i = 0;
        for (final var pair : valuesToCheck) {
            values[i].p = pair;
            values[i++].n = pair.length();
        }
        return values;
    }

    private static LibraryBridge.GoString.ByValue getGoString(final String value) {
        final var valueAsGoString = new LibraryBridge.GoString.ByValue();
        valueAsGoString.p = value;
        valueAsGoString.n = valueAsGoString.p.length();
        return valueAsGoString;
    }
}