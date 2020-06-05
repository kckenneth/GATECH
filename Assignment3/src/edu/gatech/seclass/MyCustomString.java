package edu.gatech.seclass;

import java.util.ArrayList;

public class MyCustomString implements MyCustomStringInterface {

    private String s;

    @Override
    public String getString() {
        return s;
    }

    @Override
    public void setString(String s) {
        this.s = s;
    }

    @Override
    public int countNumbers() {
        if (s == null) {
            throw new NullPointerException();
        } else if (s.equals("")) {
            return 0;
        } else {
            s = s.replaceAll("[^0-9]+", " ");
            String[] digitOnly = s.trim().split("\\s+");
            if (digitOnly.length == 1 && digitOnly[0].equals("")) {
                return 0;
            } else {
                return digitOnly.length;
            }
        }
    }

    @Override
    public String addNumber(int n, boolean reverse) {

        if (s == null) {
            throw new NullPointerException();
        }

        if (n < 0) {
            throw new IllegalArgumentException();
        }

        String[] ss = s.trim().split("\\s+");

        for (int j = 0; j < ss.length; j++) {
            String c = ss[j];
            char[] StrChr = c.toCharArray();
            String temp = "";
            int startidx = 0, endidx = 0;

            for (int i = 0; i < StrChr.length; i++) {
                if (Character.isDigit(StrChr[i])) {
                    temp += StrChr[i];
                    if (endidx == 0) {
                        startidx = i;
                        endidx = i + 1;
                    }
                } else if (!temp.isEmpty()) {
                    endidx = i;
                    String newNum = Integer.toString(Integer.parseInt(temp) + n);
                    if (reverse) {
                        StringBuilder newNumReverse = new StringBuilder();
                        newNumReverse.append(newNum);
                        newNum = (newNumReverse.reverse()).toString();
                    }

                    String subs = c.substring(startidx, endidx);
                    subs = subs.replace(temp, newNum);
                    c = c.substring(0, startidx) + subs + c.substring(endidx);
                    endidx = 0;
                    temp = "";
                    ss[j] = c;
                }
            }

            if (!temp.isEmpty()) {
                endidx = c.length();
                String newNum = Integer.toString(Integer.parseInt(temp) + n);
                if (reverse) {
                    StringBuilder newNumReverse = new StringBuilder();
                    newNumReverse.append(newNum);
                    newNum = (newNumReverse.reverse()).toString();
                }
                String subs = c.substring(startidx, endidx);
                subs = subs.replace(temp, newNum);
                c = c.substring(0, startidx) + subs + c.substring(endidx);
                temp = "";
                ss[j] = c;

            }
        }

        String ans = String.join(" ", ss);

        return ans;

    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (startPosition < 1 || startPosition > endPosition) {
            throw new IllegalArgumentException();
        }
        if (endPosition > s.length()) {
            throw new MyIndexOutOfBoundsException();
        }

        String StrOfInterest = s.substring(startPosition - 1, endPosition);
        StrOfInterest = StrOfInterest.replaceAll("0", "ZERO");
        StrOfInterest = StrOfInterest.replaceAll("1", "ONE");
        StrOfInterest = StrOfInterest.replaceAll("2", "TWO");
        StrOfInterest = StrOfInterest.replaceAll("3", "THREE");
        StrOfInterest = StrOfInterest.replaceAll("4", "FOUR");
        StrOfInterest = StrOfInterest.replaceAll("5", "FIVE");
        StrOfInterest = StrOfInterest.replaceAll("6", "SIX");
        StrOfInterest = StrOfInterest.replaceAll("7", "SEVEN");
        StrOfInterest = StrOfInterest.replaceAll("8", "EIGHT");
        StrOfInterest = StrOfInterest.replaceAll("9", "NINE");

        s = s.substring(0, startPosition - 1) + StrOfInterest + s.substring(endPosition);

    }

}
