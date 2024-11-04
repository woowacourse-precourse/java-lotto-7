package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoHolderTest {
    
    @DisplayName("모든 로또가 낙첨일 때 수익률은 0%")
    @Test
    void 모든_로또가_낙첨일때_수익률() {
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        LottoCollection lottoCollection = new LottoCollection(purchasedLottos);
        LottoHolder lottoHolder = new LottoHolder(lottoCollection);

        DrawnLotto drawnLotto = new DrawnLotto("13,14,15,16,17,18", "19");

        lottoHolder.calculateRankCounts(drawnLotto);
        double profitRate = lottoHolder.calculateProfitRate();

        assertThat(profitRate).isEqualTo(0.0);
    }

    @DisplayName("일부 로또가 당첨되었을 때 정확한 수익률 계산")
    @Test
    void 일부_로또가_당첨되었을때_수익률() {
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)), // 4등 당첨
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)) // 낙첨
        );
        LottoCollection lottoCollection = new LottoCollection(purchasedLottos);
        LottoHolder lottoHolder = new LottoHolder(lottoCollection);

        DrawnLotto drawnLotto = new DrawnLotto("1,2,3,4,5,6", "7");

        // when
        lottoHolder.calculateRankCounts(drawnLotto);
        double profitRate = lottoHolder.calculateProfitRate();

        // then
        int totalPrize = 2000000000 + 30000000 + 50000; // 1등 + 2등 + 4등 상금 합계
        int totalCost = 4000; // 로또 구매 비용
        double expectedProfitRate = (double) totalPrize / totalCost * 100;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @DisplayName("수익률이 100%를 넘을 때 정확한 수익률 계산")
    @Test
    void 수익률이_100_퍼센트를_넘을때_수익률() {
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        LottoCollection lottoCollection = new LottoCollection(purchasedLottos);
        LottoHolder lottoHolder = new LottoHolder(lottoCollection);

        DrawnLotto drawnLotto = new DrawnLotto("1,2,3,4,5,6", "7");

        lottoHolder.calculateRankCounts(drawnLotto);
        double profitRate = lottoHolder.calculateProfitRate();

        int totalPrize = 2000000000;
        int totalCost = 1000;
        double expectedProfitRate = (double) totalPrize / totalCost * 100;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
