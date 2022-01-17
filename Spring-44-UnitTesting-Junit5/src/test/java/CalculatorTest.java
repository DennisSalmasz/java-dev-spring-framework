import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll executed");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println("BeforeEach executed");
    }

    @AfterEach
    void tearDownEach(){
        System.out.println("AfterEach executed");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("AfterAll executed");
    }

    @Test
    void add() {
        System.out.println("add");
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);
    }
    @Test
    void test1() {
        System.out.println("test1");
        assertEquals("add",Calculator.operator);
    }

    @Test
    void test2() {
        System.out.println("test2");
        assertArrayEquals(new int[] {1,2,3},new int[] {1,2,3});
    }

    @Test
    void test3() {
        System.out.println("test3");
        String nullString = null;
        String notNullString = "TicketNG";

        assertNotNull(notNullString);
        assertNull(nullString);
    }

    @Test
    void test4() {
        System.out.println("test4");
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1,c2);
        assertNotSame(c1,c3);
    }
}