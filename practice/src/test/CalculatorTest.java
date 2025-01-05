package test;

import main.callback.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    private Calculator calculator;
    private String FILE_PATH;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        FILE_PATH = getClass().getResource("../a.txt").getPath();
    }

    @Test
    @DisplayName(" 값이 잘 들어가나")
    void sumOfNumbers() throws Exception {
        // given
        //when
        Integer sum = calculator.calSum(FILE_PATH);
        //then
        assertEquals(10, sum);
    }

    @Test
    @DisplayName("곱을 반환해준다.")
    void multiplyOfNumbers() throws Exception {
        // given

        //when

        Integer mul = calculator.multiply(FILE_PATH);
        //the n
        assertEquals(24, mul);

    }

    @Test
    @DisplayName("문자열 연결")
    void concat() throws Exception {
        // givenv
        String concatenate = calculator.concatenate(FILE_PATH);
        //when

        assertEquals(concatenate.toString(), "1234");
        //then
    }

}