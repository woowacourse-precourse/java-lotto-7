package lotto.service.lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {

    @DisplayName("구입 금액만큼 로또를 발행한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "8000:8"}, delimiter = ':')
    void 로또_발행_개수_검증(int purchaseAmount, int purchaseCount) {
        //given
        LottoService lottoService = new LottoService();

        //when
        List<Lotto> lottoes = lottoService.createLottoes(purchaseAmount);

        //then
        Assertions.assertThat(lottoes.size()).isEqualTo(purchaseCount);
    }

    @DisplayName("발행된 로또는 1~45 사이 값이어야 한다.")
    @Test
    void 로또_범위_검증() {
        //given
        LottoService lottoService = new LottoService();
        int purchaseAmount = 1000;

        //when
        List<Lotto> lottoes = lottoService.createLottoes(purchaseAmount);

        //then
        Assertions.assertThat(lottoes.get(0).getNumbers())
                .allMatch(number -> LottoConstant.LOTTO_RANGE_LEFT <= number
                        && number <= LottoConstant.LOTTO_RANGE_RIGHT);
    }

    @DisplayName("발행된 로또의 숫자들은 6개다.")
    @Test
    void 로또_번호_개수_검증() {
        //given
        LottoService lottoService = new LottoService();
        int purchaseAmount = 1000;

        //when
        List<Lotto> lottoes = lottoService.createLottoes(purchaseAmount);

        //then
        Assertions.assertThat(lottoes.get(0).getNumbers().size())
                .isEqualTo(LottoConstant.LOTTO_NUMBER_COUNT);
    }
}