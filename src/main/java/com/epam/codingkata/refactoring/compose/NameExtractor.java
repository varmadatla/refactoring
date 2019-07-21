package com.epam.codingkata.refactoring.compose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameExtractor {

    public List<String> getAllNames(String fullName) {
        List<String> allNames = new ArrayList<>();

        if (fullName != null && fullName.trim().length() > 0) {
            if (fullName.contains(" ")) {
                String[] names = fullName.split(" ");
                // identify first, middle and last names
                allNames.add(names[0]);

                if (names.length > 2) {
                    String[] middleNames = Arrays.copyOfRange(names, 1, names.length-1);
                    String middleName = String.join(" ", middleNames);
                    allNames.add(middleName);
                }

                allNames.add(names[names.length-1]);
            } else {
                allNames.add(fullName);
            }
        }

        return allNames;
    }
}
