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

## Download
### Maven
```xml
<dependency>
  <groupId>dev.fuxing</groupId>
  <artifactId>hibernate-validator-enum</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Gradle
```groovy
compile group: 'dev.fuxing', name: 'hibernate-validator-enum', version: '0.1.0'
```
