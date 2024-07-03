package junit5.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_11;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

public class J8ConditionalTestExecution {

    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        // ...
    }

    @TestOnMac
    void testOnMac() {
        // ...
    }

    @Test
    @EnabledOnOs({ LINUX, MAC })
    void onLinuxOrMac() {
        // ...
    }

    @Test
    @DisabledOnOs(WINDOWS)
    void notOnWindows() {
        // ...
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(MAC)
    @interface TestOnMac {
    }

//Conditional execution based on architecture

    @Test
    @EnabledOnOs(architectures = "aarch64")
    void onAarch64() {
        // ...
    }

    @Test
    @DisabledOnOs(architectures = "x86_64")
    void notOnX86_64() {
        // ...
    }

    @Test
    @EnabledOnOs(value = MAC, architectures = "aarch64")
    void onNewMacs() {
        // ...
    }

    @Test
    @DisabledOnOs(value = MAC, architectures = "aarch64")
    void notOnNewMacs() {
        // ...
    }

    //Java Runtime Environment Conditions

    @Test
    @EnabledOnJre(JAVA_8)
    void onlyOnJava8() {
        // ...
    }

    @Test
    @EnabledOnJre({ JAVA_9, JAVA_10 })
    void onJava9Or10() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JAVA_9, max = JAVA_11)
    void fromJava9to11() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JAVA_9)
    void fromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @EnabledForJreRange(max = JAVA_11)
    void fromJava8To11() {
        // ...
    }

    @Test
    @DisabledOnJre(JAVA_9)
    void notOnJava9() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JAVA_9, max = JAVA_11)
    void notFromJava9to11() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JAVA_9)
    void notFromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @DisabledForJreRange(max = JAVA_11)
    void notFromJava8to11() {
        // ...
    }
}
