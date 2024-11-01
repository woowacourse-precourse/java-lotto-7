package lotto.service;
import lotto.domain.AutoLotto;
import lotto.domain.message.LottoPriceErrorMessage;
import lotto.domain.rule.LottoRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("유효한 금액을 입력하면 올바른 개수의 자동 로또가 생성된다")
    @Test
    void createAutoLottosByCorrectPrice() {
        String totalLottoPrice = "5000";
        int autoLottoCount = Integer.parseInt(totalLottoPrice) / LottoRules.AUTO_LOTTO_PRICE.getValue();

        List<AutoLotto> autoLottos = lottoService.createAutoLottosByLottoPrice(totalLottoPrice);

        assertThat(autoLottos).hasSize(autoLottoCount);
        autoLottos.forEach(lotto -> {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).allMatch(number ->
                    number >= LottoRules.MIN_NUMBER.getValue() && number <= LottoRules.MAX_NUMBER.getValue()
            );
        });
    }

    @DisplayName("로또 구입 금액이 유효하지 않으면 예외가 발생한다 - 나누어떨어지지 않는 경우")
    @Test
    void IsNotDivisibleByLottoPriceThrowException() {
        String invalidLottoPrice = "1500";

        assertThatThrownBy(() -> lottoService.createAutoLottosByLottoPrice(invalidLottoPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoPriceErrorMessage.INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO.getMessage());
    }


    @DisplayName("로또 구입 금액이 유효하지 않으면 예외가 발생한다 - 나누어떨어지지 않는 경우")
    @Test
    void LottoPriceIsZeroThrowException() {
        String invalidLottoPrice = "0";

        assertThatThrownBy(() -> lottoService.createAutoLottosByLottoPrice(invalidLottoPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoPriceErrorMessage.INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO.getMessage());
    }



}
