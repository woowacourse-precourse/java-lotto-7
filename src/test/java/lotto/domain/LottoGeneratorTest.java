package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    private LottoGenerator generator;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        generator = new LottoGenerator();
        lotto = generator.generate();
    }

    @Test
    void 로또_번호가_6개인지_확인한다() {

        List<Integer> numbers = lotto.getNumbers();
        assertEquals(6, numbers.size(), "[ERROR] 로또 번호는 6개여야 합니다.");

        // 모든 번호가 1~45 사이에 있는지 확인
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45, "[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
        }
    }

    @Test
    void 로또_번호가_1과_45사이에_있는지_확인한다() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generate();

        List<Integer> numbers = lotto.getNumbers();

        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45, "[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
        }
    }

    @Test
    void 로또_번호가_중복이_없는지_확인한다() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generate();

        List<Integer> numbers = lotto.getNumbers();
        long uniqueCount = numbers.stream().distinct().count();
        assertEquals(6, uniqueCount, "[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }
}