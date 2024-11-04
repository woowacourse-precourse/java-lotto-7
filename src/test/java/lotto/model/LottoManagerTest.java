package lotto.model;

import lotto.utils.constants.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoManagerTest {

    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager(1000);
    }

    @Test
    @DisplayName("로또를 구매하고 개수 확인")
    void 로또를_구매하고_개수확인() {
        //given
        int numberOfLotto = lottoManager.purchaseLotto();

        assertThat(numberOfLotto).isEqualTo(1);
        assertThat(lottoManager.getPurchasedLotto()).hasSize(1);
    }

    @Test
    void 수익률_계산() {
        lottoManager.purchaseLotto(); // 로또 구매
        List<LottoPrize> results = Arrays.asList(LottoPrize.LOTTO_MATCH_1ST);
        double profitRate = lottoManager.resultProfitRate(results); // 수익률 계산

        assertThat(profitRate).isGreaterThan(199999999); // 로또 1등은 20억이므로 199999999%보다 커야 함
    }

    @Test
    void 로또_번호_검증() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        boolean isValid = lottoManager.validateLotto(lottoNumbers, bonusNumber); // 로또 번호 검증
        assertThat(isValid).isTrue(); // 유효한 번호여야 함
    }

    @Test
    @DisplayName("로또의 번호 Prize가 잘 작동하는지 검증")
    void lotto_Test() {
        //given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5,6);
        int bonusNumber = 7;
        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); //1등
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); //2등
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 18))); //3등
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 4, 7, 18))); //4등
        purchasedLotto.add(new Lotto(List.of(1, 2, 3, 7, 12, 18))); //5등
        purchasedLotto.add(new Lotto(List.of(1, 2, 7, 12, 18, 20))); //제로

        //when
        List<LottoPrize> resultPrize = lottoManager.isLottoResult(lottoNumbers, bonusNumber, purchasedLotto);

        //then

        assertThat(resultPrize).isNotEmpty();
        assertThat(resultPrize.size()).isEqualTo(6); // 예상한 크기와 일치해야 함
        assertThat(resultPrize).contains(LottoPrize.LOTTO_MATCH_1ST); // 1등 로또 번호 확인
        assertThat(resultPrize).contains(LottoPrize.LOTTO_MATCH_2ND); // 2등 로또 번호 확인
        assertThat(resultPrize).contains(LottoPrize.LOTTO_MATCH_3RD); // 3등 로또 번호 확인
        assertThat(resultPrize).contains(LottoPrize.LOTTO_MATCH_4TH); // 4등 로또 번호 확인
        assertThat(resultPrize).contains(LottoPrize.LOTTO_MATCH_5TH); // 5등 로또 번호 확인
        assertThat(resultPrize).contains(LottoPrize.LOTTO_MATCH_ZERO); // 꼴등 로또 번호 확인
    }

}
