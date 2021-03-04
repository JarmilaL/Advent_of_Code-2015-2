package com.lenyiova;

import java.util.List;

public class RibbonLengthCounter {

    public int countRibbonLength(List<int[]> presentsDimensions) {
        int ribbonLength = 0;

        for(int[] entry : presentsDimensions) {
            ribbonLength += countRibbonForOnePresent(entry);
        }

        return ribbonLength;
    }

    private int countRibbonForOnePresent(int[] presentDimensions) {
        int a = presentDimensions[0];
        int b = presentDimensions[1];
        int c = presentDimensions[2];

        return 2 * a + 2 * b + a * b * c;
    }
}
