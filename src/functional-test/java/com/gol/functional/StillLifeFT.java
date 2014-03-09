package com.gol.functional;

import com.gol.Grid;
import org.junit.Test;

import static com.gol.functional.dsl.GridDSL.a;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StillLifeFT {
    private static final String NEW_LINE = System.getProperty("line.separator");

    public static final String BLOCK =
            "----" + NEW_LINE +
                    "-xx-" + NEW_LINE +
                    "-xx-" + NEW_LINE +
                    "----";

    @Test
    public void block() {
        a(BLOCK).remains_unchanged().after(1).generations();
    }


    private static final String BEEHIVE =
            "-----" + NEW_LINE +
                    "--xx--" + NEW_LINE +
                    "-x--x-" + NEW_LINE +
                    "--xx--" + NEW_LINE +
                    "-----";

    @Test
    public void beehive() {
        a(BEEHIVE).remains_unchanged().after(1).generations();
    }
}
