package lotto.service.prize.impl;

import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.domain.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeServiceImplTest {

    private LottoPrizeServiceImpl lottoPrizeService;

    @BeforeEach
    void setUp() {
        lottoPrizeService = new LottoPrizeServiceImpl();
    }

    @Test
    @DisplayName("로또 당첨 검출")
    void 로또_당첨_검출_테스트() {
        // Given
        LottoDrawResult drawResult = new LottoDrawResult(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> lottoBundle = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5개 + 보너스 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)), // 5개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4개 당첨
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)) // 3개 당첨
        );

        // When
        List<LottoPrize> prizes = lottoPrizeService.getLottoPrizes(lottoBundle, drawResult);

        // Then
        assertEquals(5, prizes.size());
        assertEquals(LottoPrize.FIRST_PRIZE, prizes.get(0));
        assertEquals(LottoPrize.SECOND_PRIZE, prizes.get(1));
        assertEquals(LottoPrize.THIRD_PRIZE, prizes.get(2));
        assertEquals(LottoPrize.FOURTH_PRIZE, prizes.get(3));
        assertEquals(LottoPrize.FIFTH_PRIZE, prizes.get(4));
    }


}