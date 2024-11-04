package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        // given & when
        assertThatThrownBy(() -> Validator.validateAndParsePurchaseAmount("abc"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_PURCHASE_AMOUNT_TYPE_ERROR);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        // given & when
        assertThatThrownBy(() -> Validator.validateAndParsePurchaseAmount("1500"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_PURCHASE_AMOUNT_DIVISIBILITY_ERROR);
    }

    @DisplayName("구입 금액이 올바르면 예외가 발생하지 않는다.")
    @Test
    void 구입_금액이_올바르면_예외가_발생하지_않는다() {
        Validator.validateAndParsePurchaseAmount("2000");
    }

    @DisplayName("당첨 번호 입력 시 문자열이 포함된 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_문자열이_포함된_경우_예외가_발생한다() {
        // given & when
        assertThatThrownBy(() -> Validator.validateAndParseWinningNumbers("1,2,3,a,5,6"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_WINNING_NUMBERS_TYPE_ERROR);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given & when
        assertThatThrownBy(() -> Validator.validateAndParseWinningNumbers("1,2,3,3,5,6"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.DUPLICATE_WINNING_NUMBER_ERROR);
    }

    @DisplayName("당첨 번호가 범위를 벗어나는 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        // given & when
        assertThatThrownBy(() -> Validator.validateAndParseWinningNumbers("1,2,3,4,5,46"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_WINNING_NUMBER_RANGE_ERROR);
    }

    @DisplayName("당첨 번호의 개수가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
        // given & when
        assertThatThrownBy(() -> Validator.validateAndParseWinningNumbers("1,2,3,4,5"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_WINNING_NUMBER_COUNT_ERROR);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_문자열일_경우_예외() {
        // given
        String nonNumericBonusNumber = "a";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when & then
        assertThatThrownBy(() -> Validator.validateAndParseBonusNumber(nonNumericBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_BONUS_NUMBER_TYPE_ERROR);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외() {
        // given
        String outOfRangeBonusNumber = "46";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when & then
        assertThatThrownBy(() -> Validator.validateAndParseBonusNumber(outOfRangeBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_BONUS_NUMBER_RANGE_ERROR);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외() {
        // given
        String duplicateBonusNumber = "6";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when & then
        assertThatThrownBy(() -> Validator.validateAndParseBonusNumber(duplicateBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.DUPLICATE_BONUS_NUMBER_ERROR);
    }
}
