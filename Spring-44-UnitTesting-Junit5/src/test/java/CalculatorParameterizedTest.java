import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    void test1(String arg){
        assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void test2(int num){
        assertEquals(0,num%3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    //@EmptySource
    //@NullSource
    //@NullAndEmptySource
    void test3(String arg){
        assertTrue(!arg.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void test4(String arg){
        assertNotNull(arg);
    }

    public static String[] stringProvider() {
        String[] str = {"Java","JS","TS"};
        return str;
    }

    @ParameterizedTest
    @CsvSource({
            "10,20,30",
            "20,20,40",
            "30,20,50"
    })
    void test5(int num1,int num2,int result){
        assertEquals(result,Calculator.add(num1,num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)
    void test6(int num1,int num2, int result){
        assertEquals(result, Calculator.add(num1,num2));
    }
}
