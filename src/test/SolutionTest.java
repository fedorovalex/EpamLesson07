package test;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static task.Solution.*;

public class SolutionTest {

    @Test
    public void determineFrequencyWordsTestOnEnglishText() throws Exception {
        String text = "One, one, one: two - two!!";
        Map<String, Integer> frequencyWords = determineFrequencyWords(text);
        Map<String, Integer> expectation = new HashMap<>();
        expectation.put("one", 3);
        expectation.put("two", 2);
        assertTrue(frequencyWords.equals(expectation));
    }

    @Test
    public void countingTestOnUnevenAmount() {
        List<Integer> circleOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer selected = counting(circleOfNumbers);
        assertEquals(selected, new Integer(3));
    }

    @Test
    public void countingTestOnEvenAmount() {
        List<String> circleOfNumbers = Arrays.asList("Петя", "Вова", "Ваня", "Женя", "Иван", "Лиза", "Маша", "Света");
        String selected = counting(circleOfNumbers);
        assertEquals(selected, "Петя");
    }
}