package task;

import java.util.*;

public class Solution {

    public static <T> T counting(List<? extends T> circle) {

        if (circle == null ||circle.isEmpty()) {
            return null;
        }

        List<T> circleCopy = new ArrayList<>(circle);

        int numberRetired = 0;
        while (circleCopy.size() > 1) {
            numberRetired = (numberRetired + 1) % circleCopy.size();
            circleCopy.remove(numberRetired);
        }
        return circleCopy.get(0);
    }


    public static Map<String, Integer> determineFrequencyWords(String text) {

        Map<String, Integer> frequencyWords = new HashMap<>();
        text = text.replaceAll("\\p{Punct}|\\—", " ").replaceAll("[\\s]{2,}", " ");
        for (String word: text.split(" ")) {
            word = word.toLowerCase();
            Integer frequency = frequencyWords.get(word);
            if (frequency == null) {
                frequencyWords.put(word, 1);
            }
            else {
                frequencyWords.put(word, ++frequency);
            }
        }
        return frequencyWords;
    }
}
