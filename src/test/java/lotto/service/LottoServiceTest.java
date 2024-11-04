package lotto.service;

import lotto.model.UserLotto;

import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 구입금액_정상_입력_테스트() {
        assertThat(lottoService.calculateLottoCount("1000")).isEqualTo(1);
        assertThat(lottoService.calculateLottoCount("8000")).isEqualTo(8);
        assertThat(lottoService.calculateLottoCount("15000")).isEqualTo(15);
    }

    @ParameterizedTest
    @ValueSource(strings = { "100", "1500", "-1", "천원", "", " ", "0", "12345678000" })
    void 정상_입력이_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> lottoService.calculateLottoCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_결과_검증_테스트() {
        List<List<Integer>> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(List.of(1, 2, 3, 4, 5, 6)); // 1등 (6개)
        purchasedLotto.add(List.of(1, 2, 3, 4, 5, 7)); // 2등 (5개 + 보너스)
        purchasedLotto.add(List.of(1, 2, 3, 4, 5, 45)); // 3등 (5개)
        purchasedLotto.add(List.of(1, 2, 3, 4, 44, 45)); // 4등 (4개)
        purchasedLotto.add(List.of(1, 2, 3, 43, 44, 45)); // 5등 (3개)
        lottoService.setPurchasedLotto(purchasedLotto);

        UserLotto userLotto = new UserLotto();
        userLotto.setNumbers("1,2,3,4,5,6");
        userLotto.setBonusNumber("7");

        lottoService.matchLotto(userLotto);

        assertThat(WinningLotto.THREE_MATCH.getMatchCount()).isEqualTo(1);
        assertThat(WinningLotto.FOUR_MATCH.getMatchCount()).isEqualTo(1);
        assertThat(WinningLotto.FIVE_MATCH.getMatchCount()).isEqualTo(1);
        assertThat(WinningLotto.FIVE_MATCH_BONUS.getMatchCount()).isEqualTo(1);
        assertThat(WinningLotto.SIX_MATCH.getMatchCount()).isEqualTo(1);
    }
}
