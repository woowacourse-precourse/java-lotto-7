package lotto.application.validator;

import lotto.domain.cost.Cost;
import lotto.domain.lotto.WinningLottoImpl;
import lotto.domain.lotto.vo.LottoNumber;
import lotto.infrastructure.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputValidatorTest {
    private final LottoInputValidator lottoInputValidator = new LottoInputValidator();

    @Test
    @DisplayName("올바른 당첨 번호를 검증할 수 있다.")
    void 구분자_입력_검증() {
        // given
        String numbers = "1, 2, 3, 4, 5, 6";
        String bonus = "7";

        // when
        WinningLottoImpl winningLotto = lottoInputValidator.validateWinningLotto(numbers, bonus);

        // then
        assertThat(winningLotto.basicNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.bonusNumber()).isEqualTo(7);
    }

    @ParameterizedTest
    @DisplayName("올바른 구입 금액을 검증할 수 있다.")
    @ValueSource(strings = {"1000", "3000", "50000"})
    void 구입_금액_입력_검증(String costInput) {
        // given
        // when
        Cost cost = lottoInputValidator.validateCost(costInput);

        // then
        assertThat(cost.value()).isEqualTo(Integer.parseInt(costInput));
    }

    @Test
    @DisplayName("값이 생략된 당첨 번호 입력을 예외처리 할 수 있다.")
    void 구분자_입력_예외() {
        // given
        String numbers = "1, 2, , 3, 4, 5, 6";
        String bonus = "7";

        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.INVALID_INTEGER);
    }

    @ParameterizedTest
    @DisplayName("지정 구분자 이외의 구분자가 포함된 당첨 번호 입력을 예외처리 할 수 있다.")
    @CsvSource(value = {"1. 2, 3, 4, 5, 6; 7", "1! 2! 3! 4! 5! 6; 7"}, delimiter = ';')
    void 다른_구분자_입력_예외() {
        // given
        String numbers = "1. 2, 3, 4, 5, 6";
        String bonus = "7";

        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.INVALID_INTEGER);
    }

    @ParameterizedTest
    @DisplayName("정수가 아닌 값이 포함된 당첨 번호 입력을 예외처리 할 수 있다.")
    @CsvSource(value = {"1.23, 2, 3, 4, 5, 6; 7", "1, 2, 3, 4, 5, 6; 7.0"}, delimiter = ';')
    void 정수_이외_입력_예외(String numbers, String bonus) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.INVALID_INTEGER);
    }

    @ParameterizedTest
    @DisplayName("범위를 벗어난 값이 포함된 당첨 번호 입력을 예외처리 할 수 있다.")
    @CsvSource(value = {"1, 2, 3, 4, 5, 46; 7", "-1, 2, 3, 4, 5, 6; 7", "0, 2, 3, 4, 5, 6; 7"}, delimiter = ';')
    void 로또_범위_벗어난_입력_예외(String numbers, String bonus) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
    }

    @ParameterizedTest
    @DisplayName("중복된 당첨 번호 입력을 예외처리 할 수 있다.")
    @CsvSource(value = {"1, 2, 3, 4, 5, 5; 7", "1, 2, 3, 4, 5, 6; 3"}, delimiter = ';')
    void 중복_입력_예외(String numbers, String bonus) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.DUPLICATE);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 빈 문자열 입력을 예외처리 할 수 있다.")
    @CsvSource(value = {"   ; 1", "1, 2, 3, 4, 5, 6;", ";"}, delimiter = ';')
    void 당첨번호_빈_문자열_입력_예외(String numbers, String bonus) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.EMPTY_INPUT);
    }

    @ParameterizedTest
    @DisplayName("6개가 아닌 당첨 번호를 예외처리 할 수 있다.")
    @CsvSource(value = {"1, 2, 3; 4", "1; 2", "1, 2, 3, 4, 5, 6, 7; 8"}, delimiter = ';')
    void 당첨_번호_개수_예외(String numbers, String bonus) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.INVALID_LOTTO_COUNT);
    }

    @ParameterizedTest
    @DisplayName("요구사항에 맞지 않는 금액을 예외처리 할 수 있다.")
    @ValueSource(strings = {"10", "1001"})
    void 금액_입력_예외(String costInput) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateCost(costInput))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.INVALID_PURCHASE_UNIT);
    }

    @ParameterizedTest
    @DisplayName("0 이하의 금액 입력을 예외처리 할 수 있다.")
    @ValueSource(strings = {"-1", "0"})
    void 금액_범위_입력_예외(String costInput) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateCost(costInput))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.PURCHASE_LESS_THAN_ONE);
    }

    @ParameterizedTest
    @DisplayName("정수가 아닌 금액 입력을 예외처리 할 수 있다.")
    @ValueSource(strings = {"1.23", "1000.0"})
    void 금액_형식_예외(String costInput) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateCost(costInput))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.INVALID_INTEGER);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열 금액 입력을 예외처리 할 수 있다.")
    @ValueSource(strings = {"", "   "})
    void 금액_빈_문자열_예외(String costInput) {
        // given
        // when & then
        assertThatThrownBy(() -> lottoInputValidator.validateCost(costInput))
                .isInstanceOf(IllegalArgumentException.class)
                .describedAs(ExceptionMessage.EMPTY_INPUT);
    }
}