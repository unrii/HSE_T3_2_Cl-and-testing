package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
    public static int _min(ArrayList<Integer> numbers) {
        int min = numbers.get(0);
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
    public static int _max(ArrayList<Integer> numbers) {
        int max = numbers.get(0);
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
    public static int _sum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
    public static int _mult(ArrayList<Integer> numbers) {
        int mult = 1;
        for (int number : numbers) {
            mult *= number;
        }
        return mult;
    }
    public static ArrayList<Integer> read(String f){
        File file = new File(f);
        try {
            Scanner in = new Scanner(file);
            ArrayList<Integer> intNumbers = new ArrayList<>();
            while (in.hasNextInt()){intNumbers.add(in.nextInt()); }
            in.close();
            return intNumbers;
        } catch (FileNotFoundException e) {
            return new ArrayList<Integer>(0);
        }
    }
}

