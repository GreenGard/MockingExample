package org.example.Calculator;

public class Calculator {

    public int add(String s) {
        String delimiter = ",|\n|%";

        if (s.startsWith("//")) {
            if (s.contains("[")) {
                while (s.contains("[")) {
                    delimiter = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                    s = s.substring(s.indexOf("]") + 1);
                    s = s.replace(delimiter, ",");
                }

                s = s.substring(s.indexOf("\n") + 1);
                delimiter = ",";
            } else {
                int delimiterPosition = s.indexOf("//") + 2;
                delimiter = s.substring(delimiterPosition, delimiterPosition + 1);
                s = s.substring(s.indexOf("n") + 1);
            }
        }
        return add(s, delimiter);
    }

    private static int add(final String s, final String delimiter) {
        int sum = 0;
        String message = "negatives not allowed\n";
        String[] sortedNumbersArray = s.split(delimiter);

        for (String number : sortedNumbersArray) {
            if (!number.isEmpty()) {
                if (Integer.parseInt(number) > 0) {
                    if (Integer.parseInt(number) < 1000) {
                        sum += Integer.parseInt(number);
                    }
                } else {
                    message += " " + number;
                    throw new IllegalArgumentException(message);
                }
            }
        }
        return sum;
    }
}

