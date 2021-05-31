package ru.training.at.hw6.utils;

import ru.training.at.hw6.entities.MetalsColorsInfo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonDataList {

    public List<String> getResultsFromJson(MetalsColorsInfo info) {

        List<String> resultList = new LinkedList<>();

        int summaryResult = Integer.parseInt(info.getSummary()[0])
                + Integer.parseInt(info.getSummary()[1]);

        String elementsResult = Stream.of(info.getElements())
                .collect(Collectors.joining(", "));

        String vegResult = Stream.of(info.getVegetables())
                .collect(Collectors.joining(", "));

        resultList.add("Summary: " + summaryResult);
        resultList.add("Elements: " + elementsResult);
        resultList.add("Color: " + info.getColor());
        resultList.add("Metal: " + info.getMetal());
        resultList.add("Vegetables: " + vegResult);

        return resultList;
    }
}
