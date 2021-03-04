package com.lenyiova;

import java.util.List;

public class MemoryRepository implements Repository {
    private List<int[]> data;

    public MemoryRepository() {}

    public void saveData(List<int[]> data) {
        this.data = data;
    }

    public List<int[]> getData() {
        return this.data;
    }
}
