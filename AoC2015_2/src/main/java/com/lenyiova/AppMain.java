package com.lenyiova;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        Repository memoryRepository = new MemoryRepository();
        InputReader reader = new InputReader();
        WrappingPaperCounter paperCounter = new WrappingPaperCounter();
        RibbonLengthCounter ribbonCounter = new RibbonLengthCounter();

        memoryRepository.saveData(reader.read());
        UserGuide.printPaperResult(paperCounter.countWrappingPaper(memoryRepository.getData()));
        UserGuide.printRibbonResult(ribbonCounter.countRibbonLength(memoryRepository.getData()));
    }
}
