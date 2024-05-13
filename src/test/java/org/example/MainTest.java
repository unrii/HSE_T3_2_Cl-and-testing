package org.example;

import static org.junit.Assert.*;
import org.junit.Test;


public class MainTest {

    @Test
    public void _min() {
        assertEquals(1,Main._min(Main.read("tests/test1.txt")));
        assertEquals(1,Main._min(Main.read("tests/test2.txt")));
        assertEquals(1,Main._min(Main.read("tests/test3.txt")));
    }

    @Test
    public void _max() {
        assertEquals(4,Main._max(Main.read("tests/test1.txt")));
        assertEquals(9,Main._max(Main.read("tests/test2.txt")));
        assertEquals(9,Main._max(Main.read("tests/test3.txt")));
    }

    @Test
    public void _sum() {
        assertEquals(10,Main._sum(Main.read("tests/test1.txt")));
        assertEquals(121,Main._sum(Main.read("tests/test2.txt")));
        assertEquals(134,Main._sum(Main.read("tests/test3.txt")));
    }

    @Test
    public void _mult() {
        assertEquals(24,Main._mult(Main.read("tests/test1.txt")));
        assertEquals(1568669696,Main._mult(Main.read("tests/test2.txt")));
        assertEquals(1459617792,Main._mult(Main.read("tests/test3.txt")));
    }
    @Test
    public void _scenario(){
        int res1 = Main._mult(Main.read("tests/test1.txt")) - Main._sum(Main.read("tests/test1.txt"));
        int res2 = Main._mult(Main.read("tests/test2.txt")) - Main._sum(Main.read("tests/test2.txt"));
        int res3 = Main._mult(Main.read("tests/test3.txt")) - Main._sum(Main.read("tests/test3.txt"));
        assertEquals(14, res1);
        assertEquals(1568669575, res2);
        assertEquals(1459617658, res3);
    }
}