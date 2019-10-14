package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;
public class Main {

    public static void main(String[] args) {

//        String A = "";
//        String B = "A";
//        String C = "B";
//        String D = "AABC";
//        String E = "AABCY";
//        String F = "BAR";
//        String G = "AEIOUVWXY";
//
//        out.println(numberOfAnagram(A));
//        out.println(numberOfAnagram(B));
//        out.println(numberOfAnagram(C));
//        out.println(numberOfAnagram(D));
//        out.println(numberOfAnagram(E));
//        out.println(numberOfAnagram(F));
//        out.println(numberOfAnagram(G));
        out.println(numberOfAnagram(args[0]));

    }

    private static int numberOfAnagram(String s) {
        // check if the string is empty
        if (s.length() == 0){
            return 0;
        }

        // two lists that have vowels and consonants of the given string
        ArrayList<String> vowels = new ArrayList<String>();
        ArrayList<String> consonants = new ArrayList<String>();

        // two sets that have unique vowels and unique consonants of the given string (no duplicates)
        Set<String> uniqueVowels = new HashSet<String>();
        Set<String> uniqueConsonants = new HashSet<String>();

        String tmp = "";
        for (int i = 0; i<s.length(); i++){
            tmp = s.substring(i, i+1);
            if (tmp.equals("A")||tmp.equals("E")||tmp.equals("I")||tmp.equals("O")||tmp.equals("U")){
                vowels.add(tmp);
                uniqueVowels.add(tmp);
            } else {
                consonants.add(tmp);
                uniqueConsonants.add(tmp);
            }
        }
        // if the string is just one consonant, then return 1
        if (consonants.size() == 1 && vowels.size() == 0){
            return 1;
        }
        // if the string contains two or more consonants than vowels,
        // or contains more vowels than consonants, then return 0
        if (consonants.size() - vowels.size() >= 2 || vowels.size() > consonants.size()){
            return 0;
        }
        return factorial(uniqueVowels.size()) * factorial(uniqueConsonants.size());

    }
    private static int factorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }

}

