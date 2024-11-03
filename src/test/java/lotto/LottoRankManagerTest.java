package lotto;

import lotto.domain.Consumer;
import lotto.domain.LottoRank;
import lotto.domain.LottoRankManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRankManagerTest {

    private LottoRankManager lottoRankManager;
    private Consumer consumer;

    @BeforeEach
    void 초기값_세팅() {
        consumer = new Consumer(2000);
        lottoRankManager = new LottoRankManager(consumer);
        lottoRankManager.initLottoRank();
    }

    @DisplayName("초기 로또 랭크 초기화")
    @Test
    void 로또_랭킹_초기화() {
        HashMap<LottoRank, Integer> lottoRankResult = lottoRankManager.getLottoRankResult();
        for (LottoRank rank : LottoRank.values()) {
            assertEquals(0, lottoRankResult.get(rank));
        }
    }

    @DisplayName("로또 랭크 업데이트 - 3개 일치")
    @Test
    void 로또_랭킹_3개일치() {
        lottoRankManager.updateLottoRank(3, false);
        assertEquals(1, lottoRankManager.getLottoRankResult().get(LottoRank.FAVE_RANK));
    }

    @DisplayName("로또 랭크 업데이트 - 5개 일치 + 보너스 번호 포함")
    @Test
    void 로또_랭킹2등() {
        lottoRankManager.updateLottoRank(5, true);
        assertEquals(1, lottoRankManager.getLottoRankResult().get(LottoRank.SECOND_RANK));
    }

    @DisplayName("로또 랭크 업데이트 - 5개 일치 + 보너스 번호 미포함")
    @Test
    void 로또_랭킹3등() {
        lottoRankManager.updateLottoRank(5, false);
        assertEquals(1, lottoRankManager.getLottoRankResult().get(LottoRank.THIRD_RANK));
    }

    @DisplayName("총 상금 계산 테스트")
    @Test
    void 로또_상금계산() {
        lottoRankManager.updateLottoRank(3, false);
        lottoRankManager.updateLottoRank(3, false);
        lottoRankManager.updateLottoRank(5, true);

        long prizeSum = lottoRankManager.getPrizeSum();
        long expectedSum = LottoRank.FAVE_RANK.getPrice() * 2 + LottoRank.SECOND_RANK.getPrice();
        assertEquals(expectedSum, prizeSum);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void 로또_수익율_계산() {
        lottoRankManager.updateLottoRank(3, false);
        lottoRankManager.updateLottoRank(5, true);

        double yield = lottoRankManager.calculateYield();
        long prizeSum = lottoRankManager.getPrizeSum();
        double expectedYield = ((double) prizeSum / consumer.getMoney()) * 100;
        expectedYield = Math.round(expectedYield * 10) / 10.0;
        assertThat(yield).isEqualTo(expectedYield);
    }

}