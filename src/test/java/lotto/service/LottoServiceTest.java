package lotto.service;
import lotto.domain.AutoLotto;
import lotto.domain.message.LottoErrorMessage;
import lotto.domain.message.LottoPriceErrorMessage;
import lotto.domain.rule.LottoRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import lotto.domain.WinningLotto;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    // AutoLotto
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
                .hasMessage(LottoPriceErrorMessage.INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO.getMessage());
    }


    @DisplayName("로또 구입 금액이 유효하지 않으면 예외가 발생한다 - 나누어떨어지지 않는 경우")
    @Test
    void LottoPriceIsZeroThrowException() {
        String invalidLottoPrice = "0";

        assertThatThrownBy(() -> lottoService.createAutoLottosByLottoPrice(invalidLottoPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoPriceErrorMessage.INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO.getMessage());
    }

    // WinningLotto
    @DisplayName("유효한 당첨 번호를 입력하면 WinningLotto 객체가 생성된다")
    @Test
    void createWinningLottoWithValidNumbers() {
        String validWinningNumbers = "1,2,3,4,5,6";

        WinningLotto winningLotto = lottoService.createWinningLotto(validWinningNumbers);

        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto.getNumbers()).hasSize(6);
        assertThat(winningLotto.getNumbers()).allMatch(number ->
                number >= LottoRules.MIN_NUMBER.getValue() && number <= LottoRules.MAX_NUMBER.getValue()
        );
    }

    @DisplayName("유효하지 않은 당첨 번호를 입력하면 예외가 발생한다 - 숫자 형식이 아닌 경우")
    @Test
    void createWinningLottoWithInvalidNumberFormat() {
        String invalidWinningNumbers = "1,2,three,4,5,6";

        assertThatThrownBy(() -> lottoService.createWinningLotto(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.WINNING_NUMBER_FORMAT_ERROR.getMessage());
    }

    @DisplayName("유효하지 않은 당첨 번호를 입력하면 예외가 발생한다 - 범위를 벗어난 숫자가 포함된 경우")
    @Test
    void createWinningLottoWithOutOfRangeNumbers() {
        String outOfRangeWinningNumbers = "1,2,3,4,5,50";

        assertThatThrownBy(() -> lottoService.createWinningLotto(outOfRangeWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.WINNING_NUMBER_FORMAT_ERROR.getMessage());
    }



}
