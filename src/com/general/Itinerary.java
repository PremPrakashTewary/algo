package com.general;

import java.util.HashMap;
import java.util.Map;

public class Itinerary
{
    public static void main(String[] args)
    {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printResult(dataSet);

        /*Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            String sentence = scanner.next();
            String[] split = sentence.split("\\.");
            for (String s: split)
            {
                System.out.println("SS "+ s);
            }
        }*/
    }

    private static void printResult(Map<String, String> dataset)
    {
        Map<String, String> reverseMap = new HashMap<>();

        for (Map.Entry<String, String> entry: dataset.entrySet())
        {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        String start = null;
        for (Map.Entry<String, String> entry: dataset.entrySet())
        {
            if (!reverseMap.containsKey(entry.getKey()))
            {
                start = entry.getKey();
                break;
            }
        }

        if (start == null)
        {
            System.out.println("Invalid Input");
            return;
        }
        String to = dataset.get(start);
        while (to != null)
        {
            System.out.print(start +  "->" + to + ", ");
            start = to;
            to = dataset.get(to);
        }
    }
}
