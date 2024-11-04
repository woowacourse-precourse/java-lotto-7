package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @DisplayName("priceValidator_메서드_테스트_01")
    @Test
    void 천원_단위_입력이_아니면_예외가_발생한다() {
        String input = "11100";

        assertThatThrownBy(() -> Validator.priceValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("priceValidator_메서드_테스트_02")
    @Test
    void 가격_입력이_정수가_아니면_예외가_발생한다() {
        String input = "1000won";

        assertThatThrownBy(() -> Validator.priceValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("priceValidator_메서드_테스트_03")
    @Test
    void 음수가_입력된_경우_예외가_발생한다() {
        String input = "-11100";

        assertThatThrownBy(() -> Validator.priceValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("winningNumValidator_메서드_테스트_01")
    @Test
    void 당첨_번호가_숫자쉼표숫자_패턴이_아니면_예외가_발생한다() {
        String input = "1,5,2,6,9,";
        String input2 = "1,5,2,6.9";

        assertThatThrownBy(() -> Validator.winningNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.winningNumValidator(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("lottoNumValidator_메서트_테스트_01")
    @Test
    void 번호가_1_에서_45_사이의_숫자가_아니면_예외가_발생한다() {
        String input = "0";
        String input2 = "46";
        String input3 = "0a";

        assertThatThrownBy(() -> Validator.lottoNumValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.lottoNumValidator(input2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.lottoNumValidator(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
