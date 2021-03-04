package com.lenyiova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputReader {
    private final List<String> invalidInputs = new ArrayList<>();

    public List<int[]> read() {
        List<String> input = manageInput(letUserSelectInputWay());
        return convertDataToNumbers(input);
    }

    private String letUserSelectInputWay() {
        Scanner sc = new Scanner(System.in);
        int tryCounter = 0;

        UserGuide.printFirstInstructions();
        String selectedInputWay = sc.nextLine().toLowerCase().trim();

        if (selectedInputWay.equals("a")) {
            UserGuide.printInstructionsForInputStream();
        } else if (selectedInputWay.equals("b")) {
            UserGuide.printInstructionsForSingleInputs();
        } else {
            tryCounter++;
            if (tryCounter >= 5) {
                UserGuide.printInfoForTooManyInvalidAttempts();
                System.exit(1);
            } else {
                UserGuide.printInfoForInvalidTry();
                letUserSelectInputWay();
            }
        }
        return selectedInputWay;
    }

    private List<String> manageInput(String selectedInputWay) {
        List<String> input = new ArrayList<>();
        switch (selectedInputWay) {
            case "a": input = inputStreamToList();
                break;
            case "b": input = inputsToList();
                break;
        }
        return input;
    }

    private List<String> inputStreamToList() {
        List<String> input = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            do {
                line = br.readLine();
                input.add(line);
            } while (line != null && !line.isEmpty());
        } catch (IOException ex) {
            System.err.println("Something went wrong. Reading from console was unsuccessful.");
        }

        return input;
    }

    private List<String> inputsToList() {
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String lastInput = "";

        while (!lastInput.equals("start")) {
            lastInput = sc.nextLine().toLowerCase().trim();
            input.add(lastInput);
        }
        return input;
    }

    private List<int[]> convertDataToNumbers(List<String> rawData) {
        List<String> validData = primaryInputValidation(rawData);
        List<int[]> convertedData = convertStringsToNumbers(validData);

        return convertedData;
    }

    private List<String> primaryInputValidation(List<String> rawData) {
        if (rawData.isEmpty()) {
            UserGuide.printEmptyOrder();
        }
        return rawData.stream().filter(entry -> validateOneEntry(entry)).collect(Collectors.toList());
    }

    private Boolean validateOneEntry(String entry) {
        for (char c : entry.toCharArray()) {
            if ((int)c != 120 && ((int)c < 48 || (int)c > 57)) {
                invalidInputs.add(entry);
                return false;
            }
        }
        return true;
    }

    private List<String[]> splitInputStrings(List<String> input) {
        return input.stream().map(entry -> entry.split("x")).filter(entry -> secondaryInputValidation(entry)).collect(Collectors.toList());
    }

    private Boolean secondaryInputValidation(String[] array) {
        if (array.length != 3) {
            invalidInputs.add(String.join("x", array));
            return false;
        }
        return true;
    }

    private List<int[]> convertStringsToNumbers(List<String> validData) {
        List<String[]> dataInArrays = splitInputStrings(validData);
        return dataInArrays.stream().map(entry -> convertAndSortOneArray(entry)).collect(Collectors.toList());
    }

    private int[] convertAndSortOneArray(String[] stringArray) {
        int[] intArray = new int[3];
        for (int i = 0; i < 3; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        Arrays.sort(intArray);
        return intArray;
    }
}

