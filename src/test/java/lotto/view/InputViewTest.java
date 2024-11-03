package lotto.view;

import lotto.util.BonusNumberValidator;
import lotto.util.LottoAmountValidator;
import lotto.util.WinningNumberParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private LottoAmountValidator lottoAmountValidator;
    private WinningNumberParser winningNumberParser;
    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void setUp() {
        lottoAmountValidator = new LottoAmountValidator();
        winningNumberParser = new WinningNumberParser();
        bonusNumberValidator = new BonusNumberValidator();
    }

    @Test
    @DisplayName("로또 구입 금액 입력 테스트")
    void setLottoPriceTest() {
        // given
        String input = "14000";

        // when
        int result = lottoAmountValidator.validate(input);

        // then
        assertThat(result).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 구입 금액 입력 예외 테스트 1")
    void setLottoPriceExceptionTest() {
        // given
        String input = "999";

        // when & then
        assertThatThrownBy(() -> lottoAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액 입력 예외 테스트 2")
    void setLottoPriceExceptionTest2() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> lottoAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void setWinningNumbersTest() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> winningNumbers = winningNumberParser.parseWinningNumbers(input);

        // then
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 입력 예외 테스트 1")
    void setWinningNumbersExceptionTest() {
        // given
        String input = "1,2,3,4,5,6,7";

        // when & then
        assertThatThrownBy(() -> winningNumberParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 예외 테스트 2")
    void setWinningNumbersExceptionTest2() {
        // given
        String input = "1,2,3,4,5,5";

        // when & then
        assertThatThrownBy(() -> winningNumberParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    void setBonusNumberTest() {
        // given
        String input = "7";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        int result = bonusNumberValidator.validate(input, winningNumbers);

        // then
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호 입력 예외 테스트 1")
    void setBonusNumberExceptionTest() {
        // given
        String input = "46";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> bonusNumberValidator.validate(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력 예외 테스트 2")
    void setBonusNumberExceptionTest2() {
        // given
        String input = "1";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> bonusNumberValidator.validate(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}