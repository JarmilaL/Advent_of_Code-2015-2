package com.lenyiova;

import java.util.List;

public interface Repository {

    void saveData(List<int[]> data);
    List<int[]> getData();
}
