package fr.jbwittner.aoc2024;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        final FileHelper fileHelper = new FileHelper("input");

        final var inputData = fileHelper.loadLinesFromClasspath();

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        inputData.map(line -> line.trim().split("\\s+")) // Diviser chaque ligne en parties
                .forEach(parts -> {
                    firstList.add(Integer.parseInt(parts[0])); // Ajouter le premier entier
                    secondList.add(Integer.parseInt(parts[1])); // Ajouter le deuxième entier
                });

        firstList.sort(Integer::compareTo);
        secondList.sort(Integer::compareTo);

        List<Integer> difference = new ArrayList<>();

        for (int i = 0; i < firstList.size(); i++) {
            Integer value = Math.abs(firstList.get(i) - secondList.get(i));
            difference.add(value);
        }

        final Integer sum = difference.stream().reduce(0, Integer::sum);

        System.out.println(sum);

    }
}
