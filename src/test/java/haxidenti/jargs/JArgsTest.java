package haxidenti.jargs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JArgsTest {

    JArgs args;

    @BeforeEach
    public void init() {
        args = JArgs.parse("a b c -name Heller -age 18 -items knife ball -n 1 2 3 -44 5".split("\\s"));
    }

    @Test
    void first() {
        assertEquals("a", args.first("main"));
        assertEquals("Heller", args.first("name"));
        assertEquals("18", args.first("age"));
    }

    @Test
    void get() {
        assertEquals("a", args.get("main").get(0));
        assertEquals("b", args.get("main").get(1));
        assertEquals("c", args.get("main").get(2));
        assertEquals("knife", args.get("items").get(0));
        assertEquals("ball", args.get("items").get(1));
        assertEquals("1", args.get("n").get(0));
        assertEquals("2", args.get("n").get(1));
        assertEquals("3", args.get("n").get(2));
        assertEquals("-44", args.get("n").get(3));
        assertEquals("5", args.get("n").get(4));
    }
}