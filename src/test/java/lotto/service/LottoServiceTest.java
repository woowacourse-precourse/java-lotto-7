package lotto.service;


import lotto.Lotto;
import lotto.common.LottoConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @Test
    void 로또_서비스_테스트() {
        LottoService lottoService = new LottoService();
        lottoService.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setBonusWinningNumber(7);

        assertThat(lottoService.getBonusWinningNumber()).isEqualTo(7);
        assertThat(lottoService.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 2000, 3000, 5000})
    void 로또_발행_테스트(int money) {
        LottoService lottoService = new LottoService();
        lottoService.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setBonusWinningNumber(7);
        lottoService.purchaseLottos(money);

        assertThat(lottoService.getLottos().size()).isEqualTo(money / LottoConstant.LOTTO_PRICE);
        assertThat(lottoService.getLottos()).allSatisfy(lotto -> {
            assertThat(lotto).isInstanceOf(Lotto.class);
        });
    }

    @Test
    void 당첨_확인_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoService lottoService = new LottoService();
                    lottoService.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
                    lottoService.setBonusWinningNumber(7);
                    lottoService.purchaseLottos(5000);
                    lottoService.checkLottos();
                    assertThat(lottoService.getWinningCount()).isEqualTo(List.of(1, 1, 1, 1, 1));
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 10),
                List.of(1, 2, 3, 4, 10, 11),
                List.of(1, 2, 3, 10, 11, 12)
        );
    }

    @Test
    void 수익률_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoService lottoService = new LottoService();
                    lottoService.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
                    lottoService.setBonusWinningNumber(7);
                    lottoService.purchaseLottos(2000);
                    lottoService.checkLottos();
                    assertThat(lottoService.calculateReturnRate()).isEqualTo((55000 / (float) 2000) * 100);
                },
                List.of(1, 2, 3, 4, 10, 11),
                List.of(1, 2, 3, 10, 11, 12)
        );
    }

}