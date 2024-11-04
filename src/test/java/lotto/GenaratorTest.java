package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenaratorTest {

    @Test
    void testAutoGen() {
        Genarator genarator = new Genarator();
        int amount = 5000;


        List<Lotto> lottos = genarator.autoGen(amount);


        assertEquals(5, lottos.size(), "생성된 로또 개수가 맞지 않습니다.");

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            assertEquals(6, numbers.size(), "로또 번호는 6개의 숫자여야 합니다.");

            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            assertEquals(6, uniqueNumbers.size(), "로또 번호에는 중복이 없어야 합니다.");

            for (int number : numbers) {
                assertTrue(number >= 1 && number <= 45, "로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
