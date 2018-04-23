package com.project.java8.domain;

import java.util.*;
import java.util.stream.Collectors;

public class SortStringsUtil {

    private static List<String> listOfTech = Arrays.asList("Java","Spring","Kafta","Docker","Maven","Gradle","Git","Angular");

    public static void main(String[] args) {
        SortStringsUtil sortStrings = new SortStringsUtil();
        sortStrings.stringLengthSortUsingAnonClass();
        sortStrings.strinLengthSortUsingLambda();
        sortStrings.stringLengthSortUsingMethodRef();
        sortStrings.stringFilter();


    }

    private void stringFilter() {
        List<String> filterListOfTech = listOfTech.stream()
                .filter(s -> s.length() % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(filterListOfTech);
    }

    private void stringLengthSortUsingMethodRef() {
      //  List<String> sortedListofTech = listOfTech.stream()
       //                                            .sorted(SortStringsUtil::compareString)
        //                                            .collect(Collectors.toList());
        List<String> sortedListofTech = listOfTech.stream()
                //.sorted(Comparator.comparingInt(String::length)
                .sorted(Comparator.reverseOrder())
                //        .thenComparing(Comparator.naturalOrder()))
                  .collect(Collectors.toList());

        System.out.println(sortedListofTech);

    }

    private void strinLengthSortUsingLambda() {
        Collections.sort(listOfTech, (s1,s2)->compareString(s1,s2));
        //Collections.sort(listOfTech, (s1,s2)->s2.length() - s1.length());
        System.out.println(listOfTech);
    }

    private void stringLengthSortUsingAnonClass() {

        Collections.sort(listOfTech, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        System.out.println(listOfTech);
    }

    public static int compareString(String s1, String s2) {
        return s1.length() - s2.length();
    }


}
