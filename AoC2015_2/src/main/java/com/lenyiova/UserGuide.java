package com.lenyiova;

import java.util.List;

public class UserGuide {

    public static void printFirstInstructions() {
        System.out.println("Hello :) This program helps you to find out how much wrapping paper and ribbons you need for your presents.");
        System.out.println("You can give us the dimensions of your presents all at once as a stream or one by one.");
        System.out.println("For stream input press A, for single input press B.");
    }

    public static void printInstructionsForInputStream() {
        System.out.println("Prepare your input so that every set of dimensions is on different line.");
        System.out.println("It is crucial to enter the dimensions in this format: 2x4x10");
    }

    public static void printInstructionsForSingleInputs() {
        System.out.println("Enter the first set of dimensions and press 'enter', than enter the second set and so on. To execute the program write START.");
        System.out.println("It is crucial to enter the dimensions in this format: 2x4x10");
    }

    public static void printInfoForInvalidTry() {
        System.out.println("You have entered an invalid input. Please, try again.");
    }

    public static void printInfoForTooManyInvalidAttempts() {
        System.out.println("You were not able to enter valid input for several times. The program will be shut down.");
    }

    public static void printPaperResult(int result) {
        System.out.println("You need " + result + " units of paper.");
    }

    public static void printRibbonResult(int result) {
        System.out.println("You need " + result + " units of ribbon.");
    }

    public static void printInvalidInputs(List<String> invalidInputs) {
        System.out.println("Some of your inputs were not valid: ");
        invalidInputs.forEach(System.out::println);
    }

    public static void printEmptyOrder() {
        System.out.println("Your order is empty, nothing to count.");
    }

}
