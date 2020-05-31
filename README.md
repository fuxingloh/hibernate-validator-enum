# Hibernate Validator Enum

So, `null` & unknown value handling for enum has always been an issue for me when converting from JSON to Java.

I saw an implementation on Amazon Java SDK packages. 
Really liked the design, I expanded on it to support JSON using the Jackson packages. 
I have also created @ValidEnum constraints to support using Hibernate Validator library.

## This project consist of
* IntelliJ Live Template
* ValidEnum annotation 
* JSON, Jackson support
* Enum `null`, `unknown value` handling.

## Examples

### Creating the enum with live template
> Using the live template to create enum, my keyword is: `UNKNOWN_TO_SDK_VERSION`
```java
public enum Status {
    ALLOWED("ALLOWED"),
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
```

### Adding bean validation
```java
public class Bean {
    @ValidEnum
    public Status status;
}
```

## Download
### Maven
```xml
<dependency>
  <groupId>dev.fuxing</groupId>
  <artifactId>hibernate-validator-enum</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Gradle
```groovy
compile group: 'dev.fuxing', name: 'hibernate-validator-enum', version: '1.0.0'
```
