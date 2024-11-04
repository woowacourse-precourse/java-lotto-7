package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    @DisplayName("숫자 입력값이 비어있거나 공백인 경우 예외 발생")
    void 숫자_입력값이_비어있거나_공백인_경우_예외_발생() {
        // given
        String emptyInput = "";
        String blankInput = " ";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumber(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.DEFAULT_INPUT_ERROR);

        assertThatThrownBy(() -> Validator.validateNumber(blankInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.DEFAULT_INPUT_ERROR);
    }

    @Test
    @DisplayName("입력된 가격이 기준보다 낮거나 1000원 단위가 아니면 예외 발생")
    void 입력된_가격이_기준보다_낮거나_1000원_단위가_아니면_예외_발생() {
        // given
        int invalidPrice1 = 500;
        int invalidPrice2 = 4500;

        // when & then
        assertThatThrownBy(() -> Validator.validatePrice(invalidPrice1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.UNDER_PRICE_ERROR);

        assertThatThrownBy(() -> Validator.validatePrice(invalidPrice2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.UNIT_ERROR);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외 발생")
    void 로또_번호가_6개가_아니면_예외_발생() {
        // given
        List<Integer> invalidNumbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> invalidNumbers2 = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatThrownBy(() -> Validator.validateLottoNumbers(invalidNumbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.LOTTO_NUMBER_COUNT_ERROR);

        assertThatThrownBy(() -> Validator.validateLottoNumbers(invalidNumbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.LOTTO_NUMBER_COUNT_ERROR);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    void 로또_번호에_중복된_숫자가_있으면_예외_발생() {
        // given
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> Validator.validateLottoNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.DUPLICATE_NUMBER_ERROR);
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어나면 예외 발생")
    void 로또_번호가_범위를_벗어나면_예외_발생() {
        // given
        List<Integer> outOfRangeNumbers1 = List.of(0, 2, 3, 4, 5, 6);
        List<Integer> outOfRangeNumbers2 = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> Validator.validateLottoNumbers(outOfRangeNumbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.NUMBER_RANGE_ERROR);

        assertThatThrownBy(() -> Validator.validateLottoNumbers(outOfRangeNumbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.NUMBER_RANGE_ERROR);
    }

    @Test
    @DisplayName("보너스 번호가 하나의 숫자가 아닌 경우 예외 발생")
    void 보너스_번호가_하나의_숫자가_아닌_경우_예외_발생() {
        // given
        String invalidBonusNumber1 = "1, 2";
        String invalidBonusNumber2 = "1 2";
        String invalidBonusNumber3 = "abc";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumber(invalidBonusNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.NOT_NUMBER_ERROR);

        assertThatThrownBy(() -> Validator.validateNumber(invalidBonusNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.NOT_NUMBER_ERROR);

        assertThatThrownBy(() -> Validator.validateNumber(invalidBonusNumber3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.NOT_NUMBER_ERROR);
    }
}
