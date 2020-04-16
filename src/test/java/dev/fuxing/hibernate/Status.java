package dev.fuxing.hibernate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Fuxing Loh
 * @since 2020-04-17 at 03:10
 */
public enum Status {
    DRAFT("DRAFT"),
    DELETED("DELETED"),
    PUBLISHED("PUBLISHED"),

    UNKNOWN_TO_SDK_VERSION(null);

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Use this in place of valueOf to convert the raw string returned by the service into the enum value.
     *
     * @param value real value
     * @return Status corresponding to the value
     */
    @JsonCreator
    public static Status fromValue(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Status.values()).filter(e -> e.toString().equals(value)).findFirst()
                .orElse(UNKNOWN_TO_SDK_VERSION);
    }

    public static Set<Status> knownValues() {
        return Stream.of(values()).filter(v -> v != UNKNOWN_TO_SDK_VERSION).collect(Collectors.toSet());
    }
}
