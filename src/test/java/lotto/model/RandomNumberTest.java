package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {
    private RandomNumber randomNumber;

    @BeforeEach
    public void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    void 로또_번호가_6개_생성되었는지_테스트() {
        List<Integer> numbers = randomNumber.generate();
        assertEquals(6, numbers.size());
    }

    @Test
    void 로또_번호가_1_에서_45_사이에_있는지_테스트() {
        List<Integer> numbers = randomNumber.generate();
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    void 로또_번호가_오름차순으로_정렬되었는지_테스트() {
        List<Integer> numbers = randomNumber.generate();
        for (int i = 0; i < numbers.size() - 1; i++) {
            assertTrue(numbers.get(i) < numbers.get(i + 1));
        }
    }
}

