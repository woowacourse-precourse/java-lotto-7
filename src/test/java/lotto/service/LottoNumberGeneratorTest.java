package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {
    private static final int RANGE_START_NUMBER = 1;
    private static final int RANGE_END_NUMBER = 45;
    private static final int LOTTO_COUNT_NUMBER = 6;

    LottoNumberGenerator lottoNumberGenerator;
    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @RepeatedTest(100)
    void 랜덤으로_테스트해도_통과하면_성공() {
        //given
        //when
        List<Integer> numbers = lottoNumberGenerator.createLottoNumbers(RANGE_START_NUMBER,RANGE_END_NUMBER,LOTTO_COUNT_NUMBER);
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        //then
        assertEquals(LOTTO_COUNT_NUMBER, numbers.size(), "로또 번호 개수는 6개여야 합니다.");
        assertTrue(numbers.stream().allMatch(number -> number >= RANGE_START_NUMBER && number <= RANGE_END_NUMBER), "로또 번호는 범위내에 있어야 합니다");
        assertEquals(numbers.size(), uniqueNumbers.size(), "숫자는 중복되면 안 됩니다.");
    }
}
