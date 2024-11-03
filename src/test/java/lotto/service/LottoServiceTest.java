package lotto.service;

import static lotto.global.util.ErrorMessage.INVALID_AMOUNT_RANGE;
import static lotto.global.util.ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT;
import static lotto.global.util.LottoConst.MAX_PRICE;
import static lotto.global.util.LottoConst.MIN_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.lottery.domain.Lotto;
import lotto.lottery.service.LottoService;
import lotto.mock.FakeRandomHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService = new LottoService(new FakeRandomHolder(List.of(1, 2, 3, 4, 5, 6)));

    @Test
    @DisplayName("1000원 단위로 구매하면 로또를 살 수 있다")
    void purchaseLotto() throws Exception {
        // given
        String amount = "2000";

        // when
        List<Lotto> lottos = lottoService.purchaseLottos(amount);

        // then
        assertThat(lottos).hasSize(2)
                .extracting("numbers")
                .containsExactlyInAnyOrder(List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("구매 금액 범위를 초과하면 에러를 반환한다")
    void OverThePrice() throws Exception {
        // given
        String amount = "101000";

        // then
        assertThatThrownBy(() -> lottoService.purchaseLottos(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_AMOUNT_RANGE.getMessage(), MIN_PRICE, MAX_PRICE));
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력 할 경우 에러를 반환한다")
    void NotDigits() throws Exception {
        // given
        String amount = "10100a";

        // then
        assertThatThrownBy(() -> lottoService.purchaseLottos(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_FORMAT.getMessage());
    }

}