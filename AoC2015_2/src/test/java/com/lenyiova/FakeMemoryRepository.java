package com.lenyiova;

import java.util.ArrayList;
import java.util.List;

public class FakeMemoryRepository implements Repository {
    private List<int[]> data = new ArrayList<>();

    public FakeMemoryRepository() {}

    public void saveData(List<int[]> data) {
        this.data = data;
    }

    public List<int[]> getData() {
        return this.data;
    }

    public void addFakeData(int[] fakeData) {
        data.add(fakeData);
    }
}
