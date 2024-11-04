package lotto;

import java.util.List;
import lotto.util.LottoPrizeRankType;
import lotto.util.WinningLottoStore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    LottoManager lottoManager;

    @BeforeEach
    void init() {
        lottoManager = new LottoManager();
        WinningLottoStore.setUpLottoStore(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @DisplayName("로또가 1~45사이의 6자리 숫자인지 확인한다.")
    @Test
    void assertDrawLottoLength() {
        Assertions.assertThat(lottoManager.drawLottoTicket().getNumbers()).hasSize(6);
        Assertions.assertThat(lottoManager.drawLottoTicket().getNumbers())
                .allMatch(num -> num > 0 && num <= 45);
    }

    @DisplayName("로또 결과에서 보너스 번호를 정상적으로 LottoPrizeRankType과 매칭하는지 확인한다.")
    @Test
    void failMatchLottoResultAndPrizeRank() {
        final Lotto secondRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Assertions.assertThat(lottoManager.getLottoResults(secondRankLotto))
                .isNotEqualByComparingTo(LottoPrizeRankType.THIRD);
    }

    @DisplayName("로또 결과가 정상적으로 LottoPrizeRankType과 매칭되는지 확인한다.")
    @Test
    void matchLottoResultAndPrizeRank() {
        final Lotto firstRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto secondRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        final Lotto thirdRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        final Lotto fourthRankLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        final Lotto fifthRankLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        final Lotto zeroRankLotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        Assertions.assertThat(lottoManager.getLottoResults(firstRankLotto))
                .isEqualByComparingTo(LottoPrizeRankType.FIRST);
        Assertions.assertThat(lottoManager.getLottoResults(secondRankLotto))
                .isEqualByComparingTo(LottoPrizeRankType.SECOND);
        Assertions.assertThat(lottoManager.getLottoResults(thirdRankLotto))
                .isEqualByComparingTo(LottoPrizeRankType.THIRD);
        Assertions.assertThat(lottoManager.getLottoResults(fourthRankLotto))
                .isEqualByComparingTo(LottoPrizeRankType.FOURTH);
        Assertions.assertThat(lottoManager.getLottoResults(fifthRankLotto))
                .isEqualByComparingTo(LottoPrizeRankType.FIFTH);
        Assertions.assertThat(lottoManager.getLottoResults(zeroRankLotto))
                .isEqualByComparingTo(LottoPrizeRankType.ZERO);
    }
}