package junit5.example.sivajunit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Siva2DisplayNameGeneratorDemo")
public class Siva2DisplayNameGeneratorDemo {


    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.Simple.class)
    class DisplayNameGenerationSimpleTest {
        @Test
        void testTest1() {

        }

        @Test
        void testTest2() {

        }

        @Test
        void testTest3() {

        }

        @Test
        void testTest4() {

        }

    }
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.Standard.class)
    class DisplayNameGenerationStandardTest {
        @Test
        void testTest1() {

        }

        @Test
        void testTest2() {

        }

        @Test
        void testTest3() {

        }

        @Test
        void testTest4() {

        }

    }
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
    class DisplayNameGenerationIndicativeSentencesTest {
        @Test
        void testTest1() {

        }

        @Test
        void testTest2() {

        }

        @Test
        void testTest3() {

        }

        @Test
        void testTest4() {

        }

    }
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Display_Name_Generation_Replace_Underscores_Test {
        @Test
        void test_Test1() {

        }

        @Test
        void test_Test2() {

        }

        @Test
        void test_Test3() {

        }

        @Test
        void test_Test4() {

        }

    }


    @Nested
    @IndicativeSentencesGeneration(separator = "->>>",
            generator = DisplayNameGenerator.IndicativeSentences.class)
    class IndicativeSentencesGenerationTest {
        @Test
        void testTest1() {

        }

        @Test
        void testTest2() {

        }

        @Test
        void testTest3() {

        }

        @Test
        void testTest4() {

        }

    }
}
