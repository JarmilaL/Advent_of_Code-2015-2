package com.lenyiova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestApp {
    InputReader inputReader;
    WrappingPaperCounter paperCounter;
    List<String> fakeOrder;
    RibbonLengthCounter ribbonCounter;

    @BeforeEach
    public void createInstance() {
        inputReader = new InputReader();
        paperCounter = new WrappingPaperCounter();
        fakeOrder = new ArrayList<>();
        ribbonCounter = new RibbonLengthCounter();
    }

    @Test
    public void testPaperCounter() {
        FakeMemoryRepository fakeMemoryRepository = new FakeMemoryRepository();
        int[] a = {2, 4, 5};
        int[] b = {1, 3, 10};
        int[] c = {2, 2, 4};
        fakeMemoryRepository.addFakeData(a);
        fakeMemoryRepository.addFakeData(b);
        fakeMemoryRepository.addFakeData(c);
        Assertions.assertEquals(217, paperCounter.countWrappingPaper(fakeMemoryRepository.getData()));
    }

    @Test
    public void testRibbonCounter() {
        FakeMemoryRepository fakeMemoryRepository = new FakeMemoryRepository();
        int[] a = {2, 4, 5};
        int[] b = {1, 3, 10};
        int[] c = {2, 2, 4};
        fakeMemoryRepository.addFakeData(a);
        fakeMemoryRepository.addFakeData(b);
        fakeMemoryRepository.addFakeData(c);
        Assertions.assertEquals(114, ribbonCounter.countRibbonLength(fakeMemoryRepository.getData()));
    }

//    @DisplayName("Invalid characters")
//    @Test
//    public void testInvalidEntry1() {
//        Assertions.assertFalse(inputReader.validateOneEntry("23ksdh42"));
//    }

//    @Test
//    public void testValidEntry() {
//        Assertions.assertTrue(inputReader.validateOneEntry("2x10x4"));
//    }

//    @DisplayName("Missing input")
//    @Test
//    public void testInvalidInputList1() {
//        Assertions.assertEquals(fakeOrder.size(), inputReader.primaryInputValidation(fakeOrder).size());
//    }

//    @DisplayName("Exclude invalid input")
//    @Test
//    public void testInvalidInputList2() {
//        fakeOrder.add("2x10x4");
//        fakeOrder.add("23ksdh42");
//        Assertions.assertEquals(1, inputReader.primaryInputValidation(fakeOrder).size());
//    }

//    @DisplayName("Missing dimension")
//    @Test
//    public void testThreeDimensions1() {
//        String[] s = {"2", "5"};
//        Assertions.assertFalse(inputReader.secondaryInputValidation(s));
//    }

//    @DisplayName("Too many dimension")
//    @Test
//    public void testThreeDimensions2() {
//        String[] s = {"2", "5", "10", "7"};
//        Assertions.assertFalse(inputReader.secondaryInputValidation(s));
//    }

//    @DisplayName("Three dimension")
//    @Test
//    public void testThreeDimensions3() {
//        String[] s = {"2", "5", "10"};
//        Assertions.assertTrue(inputReader.secondaryInputValidation(s));
//    }

//    @DisplayName("Paper for one present")
//    @Test
//    public void testOnePresentCounter() {
//        int[] dimensions = {1, 2, 3};
//        Assertions.assertEquals(24, paperCounter.countPaperForOnePresent(dimensions));
//    }

//    @DisplayName("Ribbon for one present")
//    @Test
//    public void testOnePresentRibbonCounter() {
//        int[] dimensions = {1, 2, 3};
//        Assertions.assertEquals(12, ribbonCounter.countRibbonForOnePresent(dimensions));
//    }



}
