package lotto.service;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceImplTest {
    private final LottoServiceImpl lottoService = new LottoServiceImpl();

    @Test
    void 구입_금액에_해당하는_만큼_로또_발행() {
        int price = 10000;
        int expectedResult = 10;

        int actualCount = lottoService.calculateLottoCount(price);

        assertEquals(expectedResult, actualCount);
    }

    @Test
    void 로또번호_범위_사이의_중복되지_않은_정수_6개_반환() {
        List<Integer> numbers = lottoService.pickLottoNumbers();
        int expectedCount = 6;
        int expectedRangeStart = 1;
        int expectedRangeEnd = 45;

        assertTrue(numbers.stream().allMatch(num -> num >= expectedRangeStart && num <= expectedRangeEnd));
        assertEquals(expectedCount, numbers.size());
        assertEquals(expectedCount, numbers.stream().distinct().count());
    }
}