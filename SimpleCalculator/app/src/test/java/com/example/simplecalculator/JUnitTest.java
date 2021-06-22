package com.example.simplecalculator;

import org.junit.Test;
import static org.junit.Assert.*;
import com.example.simplecalculator.MainActivity;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JUnitTest {
    MainActivity main = new MainActivity();
    String str;

    @Test
    public void add_isCorrect() {
        str = main.equation(2.00, 2.00, "add");
        double result = Double.parseDouble(str);
        assertEquals(4.00, result, 0.001);
    }
    @Test
    public void sub_isCorrect() {
        str = main.equation(0.00, 0.05, "sub");
        double result = Double.parseDouble(str);
        assertEquals(-0.05, result, 0.001);
    }
    @Test
    public void div_isCorrect() {
        str = main.equation(4.25, 1.41666667, "div");
        double result = Double.parseDouble(str);
        assertEquals(3, result, 0.001);
    }
    @Test
    public void mul_isCorrect() {
        str = main.equation(1.2345, 3.00, "mul");
        double result = Double.parseDouble(str);
        assertEquals(3.7035, result, 0.001);
    }

    @Test
    public void backspace_functional(){
        str = main.bkspace("2+345", 4);
        assertEquals("2", str);
    }
}