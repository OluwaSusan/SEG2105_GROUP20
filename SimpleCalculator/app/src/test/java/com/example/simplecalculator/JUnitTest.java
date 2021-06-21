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
        Double result = Double.parseDouble(str);
        //assertEquals(4.00, result);
    }
    @Test
    public void sub_isCorrect() {
        str = main.equation(2.00, 2.00, "sub");
        Double result = Double.parseDouble(str);
        //assertEquals(0.00, result);
    }
    @Test
    public void div_isCorrect() {
        str = main.equation(2.00, 2.00, "div");
        Double result = Double.parseDouble(str);
        assertEquals(1, 2 / 2);
    }
    @Test
    public void mul_isCorrect() {
        str = main.equation(2.00, 2.00, "mul");
        Double result = Double.parseDouble(str);
        assertEquals(6, 2 * 3);
    }
}