package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        String COMMA_DELIMITER = ",";

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\Ressources\\dl.txt"))) {
        String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }

        Map<Integer, Integer> mapa = new HashMap<>();
        for (List<String> record : records) {
            String cut = record.get(0).substring(record.get(0).length()-2);
            record.set(0, cut.trim());
            for (String rec : record) {
                Integer value = Integer.parseInt(rec);
                Integer count;
                if(mapa.get(value) != null) {
                    count = mapa.get(value) + 1;
                    mapa.put(Integer.valueOf(value),count);
                } else {
                    mapa.put(Integer.valueOf(value),1);
                }
            }
        }
//        Stream<Map.Entry<Integer,Integer>> sorted =
//                mapa.entrySet().stream()
//                        .sorted(Map.Entry.comparingByValue());
//        sorted.forEach(System.out::println);
        for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Number " + key + " appeared " + value + " times");
        }
    }
}

