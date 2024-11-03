package lotto.model;

import lotto.utils.constants.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager(1000);
    }

    @Test
    void 로또를_구매하고_개수확인() {
        int numberOfLotto = lottoManager.purchaseLotto();
        assertThat(numberOfLotto).isEqualTo(1);
        assertThat(lottoManager.getPurchasedLotto()).hasSize(1);
    }

    @Test
    void 수익률_계산() {
        lottoManager.purchaseLotto(); // 로또 구매
        List<LottoPrize> results = Arrays.asList(LottoPrize.LOTTO_MATCH_1ST, LottoPrize.LOTTO_MATCH_2ND);
        double profitRate = lottoManager.resultProfitRate(results); // 수익률 계산

        assertThat(profitRate).isGreaterThan(0); // 수익률은 0보다 커야 함
    }

    @Test
    void 로또_번호_검증() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        boolean isValid = lottoManager.validateLotto(lottoNumbers, bonusNumber); // 로또 번호 검증
        assertThat(isValid).isTrue(); // 유효한 번호여야 함
    }
}
