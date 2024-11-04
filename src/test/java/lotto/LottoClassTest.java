package lotto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class LottoClassTest {
    @Test
    void 생성자_유효성_검사_정상_케이스() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertEquals(numbers, lotto.getNumbers());
    }

    @Test
    void 생성자_유효성_검사_숫자_개수() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers), "[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 생성자_유효성_검사_숫자_범위() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers), "[ERROR] 로또 번호는 1과 45사이의 숫자입니다");
    }

    @Test
    void 생성자_유효성_검사_중복_숫자() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers), "[ERROR] 중복된 숫자가 있습니다.");
    }

    @Test
    void 랜덤_번호_생성() {
        Lotto lotto = Lotto.generateRandomNumbers();
        assertEquals(6, lotto.getNumbers().size());
        lotto.getNumbers().forEach(number -> {
            assertTrue(number >= 1 && number <= 45);
        });
    }
}
