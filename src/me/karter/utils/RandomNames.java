package me.karter.utils;

import java.util.Random;

public class RandomNames {
    public static String GenerateName() {

        String alphabet = "abcdefghijklmnopqrstuvwxyz" ; //    26 / 0-25
        String vowels = "aeiou"; //    5 / 0-4
        String sibilancy = "bcdfghjklmnpqrstvwxyz";
        String result = "";

        int VowelCounter = 0;
        int SibilancyCounter = 0 ;

        Random rand = new Random();
        int namelenght = rand.nextInt(3)+4;

        for(int i = 0; i<namelenght; i++) {

            char name = alphabet.charAt(rand.nextInt(26));

            if (searchVowels(name) == true) {VowelCounter++; SibilancyCounter = 0;}else {SibilancyCounter++; VowelCounter = 0;} //Counters

            if(VowelCounter == 3) { name = sibilancy.charAt(rand.nextInt(5)); VowelCounter = 0; SibilancyCounter = 1; }  // if there is more then 2 vowels in a row.
            if (SibilancyCounter == 4) {name = vowels.charAt(rand.nextInt(5)); SibilancyCounter = 0; VowelCounter = 1;} // if there is more then 3 sibilancy in a row.


            result += name;

        }

        //Capitalizing the first letter
        result = result.substring(0, 1).toUpperCase() + result.substring(1);

        return result;

    }


    // Checking if a char is Vowel or not
    public static boolean searchVowels(char check_vowel) {
        String vowels = "aeýoui"; //    6 / 0-5

        for (int i=0; i<=5; i++) {
            if (check_vowel == vowels.charAt(i)) { return true; }
        }

        return false;
    }
}
