package com.stupnv.vocabulary.utils;

import java.util.*;

public class ListUtils {

    public static <T> List<T> getNElemetsFromList(List<T> inputList, int count) {
        List<T> list = new ArrayList<>(inputList);
        int listSize = list.size();
        if (listSize <= count) {
            return list;
        }

        if (100 * (float) count / (float) listSize > 50f) {
            Collections.shuffle(list);
            return list.subList(0, count);
        }

        Set<T> newList = new HashSet<>();
        while (newList.size() < count) {
            newList.add(list.get((int) (Math.random() * (listSize))));
        }
        return new ArrayList<>(newList);
    }
}
