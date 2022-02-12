package com.cyber;

import java.util.Arrays;

public class UnitTestingImpl {

    public int calculateSum(int[] data){
        int sum = 0;
        return Arrays.stream(data).sum();
    }

    // -----

    DataRepository dataRepository;

    public UnitTestingImpl() {
    }

    public UnitTestingImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public int calculateSumUsingDataService(){
        int sum = 0;
        return Arrays.stream(dataRepository.findAll()).sum();
    }

    public int calculateSumUsingDataServiceWithParameter(){
        int sum = 0;
        return Arrays.stream(dataRepository.findById(2)).sum();
    }




}
