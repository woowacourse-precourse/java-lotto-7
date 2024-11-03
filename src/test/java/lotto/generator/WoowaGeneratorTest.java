package lotto.generator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WoowaGeneratorTest {
    @Test
    @DisplayName("중복 X 체크")
    void testNotDuplicate() {
        Generator generator = new WoowaGenerator();
        List<Integer> numbers = generator.generateUniqueNumbers(1, 45, 6);

        Assertions.assertEquals(6, numbers.size());
        for (Integer number : numbers) {
            Assertions.assertTrue(0 <= number.compareTo(1));
            Assertions.assertTrue(number.compareTo(45) <= 0);
        }
        List<Integer> uniqueList = numbers.stream().distinct().toList();
        Assertions.assertEquals(0, Integer.compare(uniqueList.size(), numbers.size()));
    }
}