package lotto.service;
import lotto.domain.AutoLotto;
import lotto.domain.message.LottoErrorMessage;
import lotto.domain.message.LottoPriceErrorMessage;
import lotto.domain.rule.LottoRules;
import lotto.domain.rule.WinningRules;
import lotto.utils.DefaultErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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

    @DisplayName("로또 구입 금액이 유효하지 않으면 예외가 발생한다 - 나누어떨어지지 않는 경우 (1500)")
    @Test
    void IsNotDivisibleByLottoPriceThrowException() {
        String invalidLottoPrice = "1500";

        assertThatThrownBy(() -> lottoService.createAutoLottosByLottoPrice(invalidLottoPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoPriceErrorMessage.INVALID_LOTTO_PRICE_DIVISIBLE_OR_ZERO.getMessage());
    }


    @DisplayName("로또 구입 금액이 유효하지 않으면 예외가 발생한다 - 나누어떨어지지 않는 경우 (0)")
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

    @DisplayName("유효하지 않은 당첨 번호를 입력하면 예외가 발생한다 - 유효한 숫자 형식이 아닌 경우 (문자열) ")
    @Test
    void createWinningLottoWithInvalidNumberFormatString() {
        String invalidWinningNumbers = "1,2,three,4,5,6";

        assertThatThrownBy(() -> lottoService.createWinningLotto(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.WINNING_NUMBER_FORMAT_ERROR.getMessage());
    }

    @DisplayName("유효하지 않은 당첨 번호를 입력하면 예외가 발생한다 - 유효한 숫자 형식이 아닌 경우 (실수) ")
    @Test
    void createWinningLottoWithInvalidNumberFormatNotInteger() {
        String invalidWinningNumbers = "1,2,3.4,4,5,6";

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

    @DisplayName("유효하지 않은 보너스 번호를 입력하면 예외가 발생한다. - 유효한 숫자 형식이 아닌 경우 (문자열)")
    @Test
    void setWinningLottoBonusNumberWithString() {
        WinningLotto winningLotto = lottoService.createWinningLotto("1,2,3,4,5,6");
        String invalidWinningNumber = "number";

        assertThatThrownBy(() -> lottoService.setWinningLottoBonusNumber(winningLotto, invalidWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DefaultErrorMessage.INVALID_INTEGER_FORMAT.getMessage());
    }

    @DisplayName("유효하지 않은 보너스 번호를 입력하면 예외가 발생한다. - 범위를 벗어난 숫자가 포함된 경우")
    @Test
    void setWinningLottoBonusNumberWithOutOfRangeNumber() {
        WinningLotto winningLotto = lottoService.createWinningLotto("1,2,3,4,5,6");
        String invalidWinningNumber = "80";

        assertThatThrownBy(() -> lottoService.setWinningLottoBonusNumber(winningLotto, invalidWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.INVALID_LOTTO_NUMBER_IN_RANGE.getMessage());
    }

    @DisplayName("유효하지 않은 보너스 번호를 입력하면 예외가 발생한다. - 당첨 번호와 중복되는 경우")
    @Test
    void setWinningLottoBonusNumberWhenDuplicateLottoNumbersExist() {
        WinningLotto winningLotto = lottoService.createWinningLotto("1,2,3,4,5,6");
        String invalidWinningNumber = "6";

        assertThatThrownBy(() -> lottoService.setWinningLottoBonusNumber(winningLotto, invalidWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    // 수익률
    @DisplayName("로또 구매 : 8000원 당첨 금액 : 0 원 수익률 : 0 %")
    @Test
    void testReturnRate_0Percent() {
        LottoService lottoService = new LottoService();
        List<AutoLotto> autoLottos = lottoService.createAutoLottosByLottoPrice("8000");
        WinningLotto winningLotto = WinningLotto.createWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setWinningLottoBonusNumber(winningLotto, "7");

        float result = lottoService.calculateWinningStatistics(Map.of(
                WinningRules.THREE_MATCH, 0L,
                WinningRules.FOUR_MATCH, 0L,
                WinningRules.FIVE_MATCH, 0L,
                WinningRules.FIVE_MATCH_WITH_BONUS, 0L,
                WinningRules.SIX_MATCH, 0L
        ), autoLottos);

        assertThat(result).isEqualTo(0.0f);
    }

    @DisplayName("로또 구매 : 8000원 당첨 금액 : 5000 원 수익률 : 62.5 %")
    @Test
    void testReturnRate_62_5Percent() {
        LottoService lottoService = new LottoService();
        List<AutoLotto> autoLottos = lottoService.createAutoLottosByLottoPrice("8000");
        WinningLotto winningLotto = WinningLotto.createWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setWinningLottoBonusNumber(winningLotto, "7");

        float result = lottoService.calculateWinningStatistics(Map.of(
                WinningRules.THREE_MATCH, 1L,
                WinningRules.FOUR_MATCH, 0L,
                WinningRules.FIVE_MATCH, 0L,
                WinningRules.FIVE_MATCH_WITH_BONUS, 0L,
                WinningRules.SIX_MATCH, 0L
        ), autoLottos);

        assertThat(result).isEqualTo(62.5f);
    }


    @DisplayName("로또 구매 : 8000원 당첨 금액 : 10000 원 수익률 : 125 %")
    @Test
    void testReturnRate_125Percent() {
        LottoService lottoService = new LottoService();
        List<AutoLotto> autoLottos = lottoService.createAutoLottosByLottoPrice("8000");
        WinningLotto winningLotto = WinningLotto.createWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setWinningLottoBonusNumber(winningLotto, "7");

        float result = lottoService.calculateWinningStatistics(Map.of(
                WinningRules.THREE_MATCH, 2L,
                WinningRules.FOUR_MATCH, 0L,
                WinningRules.FIVE_MATCH, 0L,
                WinningRules.FIVE_MATCH_WITH_BONUS, 0L,
                WinningRules.SIX_MATCH, 0L
        ), autoLottos);

        assertThat(result).isEqualTo(125.0f);
    }

    @DisplayName("로또 구매 : 8000원 당첨 금액 : 2000000000 원 수익률 : 25000000 %")
    @Test
    void testReturnRate_25000000Percent() {
        LottoService lottoService = new LottoService();
        List<AutoLotto> autoLottos = lottoService.createAutoLottosByLottoPrice("8000");
        WinningLotto winningLotto = WinningLotto.createWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        lottoService.setWinningLottoBonusNumber(winningLotto, "7");

        float result = lottoService.calculateWinningStatistics(Map.of(
                WinningRules.THREE_MATCH, 0L,
                WinningRules.FOUR_MATCH, 0L,
                WinningRules.FIVE_MATCH, 0L,
                WinningRules.FIVE_MATCH_WITH_BONUS, 0L,
                WinningRules.SIX_MATCH, 1L
        ), autoLottos);

        assertThat(result).isEqualTo(25000000.0f);
    }




}
