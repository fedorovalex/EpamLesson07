package task;

import java.util.*;

public class Solution {

    public static <T> T counting(List<? extends T> circle) {

        if (circle == null || circle.isEmpty()) {
            return null;
        }
        Iterator<T> iterator = new AlwaysSecondCyclicIterator<T>(new ArrayList<>(circle));

        T selected = null;

        while (iterator.hasNext()) {
            selected = iterator.next();
            iterator.remove();
        }
        return selected;
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
