package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class ValidatorTest {

    @DisplayName("가격에 정수형 이외의 타입이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a","-"," ",""})
    void 가격에_정수형_이외의_타입이_입력되면_예외가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> Validator.validateLottoCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @DisplayName("가격에 0 이하의 수가 입력되면 예외가 발생한다.")
    @Test
    void 가격에_0_이하의_수가_입력되면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Validator.validateLottoCount("-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEGATIVE_OR_ZERO.getMessage());
    }

    @DisplayName("가격이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 가격이_1000원_단위가_아니면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Validator.validateLottoCount("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_AMOUNT.getMessage());
    }

    @DisplayName("당첨 번호 입력 시 중복되면 예외가 발생한다.")
    @Test
    void 당첨_번호_입력_시_중복되면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(new String[]{"1","1","3","4","5","6"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호가 6개 입력되지 않으면 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개_입력되지_않으면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(new String[]{"1","2","3","4","5"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_COUNT.getMessage());
    }

    @DisplayName("당첨 번호에 정수형 이외의 타입이 입력되면 예외가 발생한다.")
    @Test
    void 당첨_번호에_정수형_이외의_타입이_입력되면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(new String[]{"1","문자","3","4","5","6"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @DisplayName("당첨 번호는 1과 45 사이 외 입력되면 예외가 발생한다.")
    @Test
    void 당첨_번호는_1과_45_사이_외_입력되면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(new String[]{"1","16","34","48","51","6"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호에 정수형 이외의 타입이 입력되면 예외가 발생한다.")
    @Test
    void 보너스_번호에_정수형_이외의_타입이_입력되면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6),"str"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @DisplayName("보너스 번호는 1과 45 사이 외 입력되면 예외가 발생한다.")
    @Test
    void 보너스_번호는_1과_45_사이_외_입력되면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6),"48"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호는 당첨 번호와 중복되면 안된다.")
    @Test
    void 보너스_번호는_당첨_번호와_중복되면_안된다() {
        Assertions.assertThatThrownBy(() -> Validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6),"4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_WITH_WIN_NUMBER.getMessage());
    }

}