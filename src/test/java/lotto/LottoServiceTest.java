package lotto;

import lotto.domain.*;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoServiceTest {

    private final static int MIN_COST = 1000;
    private LottoService lottoService;
    private Consumer consumer;
    private LottoRankManager lottoRankManager;
    private LottoPrize lottoPrize;

    @BeforeEach
    void 사전_세팅() {
        lottoService = new LottoService();
        consumer = new Consumer(2000);
        lottoRankManager = new LottoRankManager(consumer);
        lottoRankManager.initLottoRank();
        lottoPrize = LottoPrize.createLottoPrize(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoPrize = LottoPrize.createLottoBonus(lottoPrize.getLottoPrizeNumbers(), 7);
    }

    @DisplayName("로또 구매 실패 1000 미만")
    @Test
    void 로또_구매_실패_1000미만() {
        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                lottoService.buyLottoes(consumer, MIN_COST - 100));

        assertEquals(throwable.getMessage(), "");
    }

    @DisplayName("로또 랭크 계산 테스트")
    @Test
    void 로또_랭킹_계산() {
        //given
        consumer.buyLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        lottoService.calculationLottoRank(consumer, lottoRankManager, lottoPrize);

        //then
        assertEquals(1, lottoRankManager.getLottoRankResult().get(LottoRank.FIRST_RANK));
    }

    @DisplayName("매칭 번호 찾기 테스트")
    @Test
    void 로또매칭번호_찾기() {
        //given
        consumer.buyLotto(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));

        //when
        lottoService.findMatchingNumbers(lottoRankManager, consumer.getLottoes(), lottoPrize.getLottoPrizeNumbers(), lottoPrize.getBonusNumber());

        //then
        assertEquals(1, lottoRankManager.getLottoRankResult().get(LottoRank.FOURTH_RANK));
    }

    @DisplayName("결과 로또 테스트")
    @Test
    void 로또_결과() {
        //given
        consumer.buyLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        lottoService.calculationLottoRank(consumer, lottoRankManager, lottoPrize);
        double yield = lottoService.resultLotto(lottoRankManager);
        double expectedYield = ((double) lottoRankManager.getPrizeSum() / consumer.getMoney()) * 100;
        expectedYield = Math.round(expectedYield * 10) / 10.0;

        //then
        assertEquals(expectedYield, yield);
    }

}