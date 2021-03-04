package com.lenyiova;

import java.util.List;

public class WrappingPaperCounter {

    public int countWrappingPaper(List<int[]> presentsDimensions) {
        int paperArea = 0;

        for (int[] entry : presentsDimensions) {
            paperArea += countPaperForOnePresent(entry);
        }

        return paperArea;
    }

     int countPaperForOnePresent(int[] presentDimensions) {
        int a = presentDimensions[0];
        int b = presentDimensions[1];
        int c = presentDimensions[2];

        return a * b + 2 * a * b + 2 * b * c + 2 * a * c;
    }

}
