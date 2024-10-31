package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {

    @DisplayName("정상적인 보너스 번호 입력시 false를 반환한다")
    @Test
    void 정상적인_보너스_번호_입력시_false를_반환한다() {
        // given
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        String userInput = "7";
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // when
        boolean result = bonusNumberValidator.isNotValidBonusNumber(userInput, winningNumbers);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("숫자가 아닌 값을 입력하는 경우 true를 반환한다")
    @Test
    void 숫자가_아닌_값을_입력하는_경우_true를_반환한다() {
        // given
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        String userInput = "a";
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // when
        boolean result = bonusNumberValidator.isNotValidBonusNumber(userInput, winningNumbers);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("로또 범위를 넘는 숫자 포함시 true를 반환한다")
    @Test
    void 로또_범위를_넘는_숫자_포함시_true를_반환한다() {
        // given
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        String userInput = "46";
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // when
        boolean result = bonusNumberValidator.isNotValidBonusNumber(userInput, winningNumbers);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("당첨 번호와 중복되는 경우 true를 반환한다")
    @Test
    void 당첨_번호와_중복되는_경우_true를_반환한다() {
        // given
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        String userInput = "1";
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // when
        boolean result = bonusNumberValidator.isNotValidBonusNumber(userInput, winningNumbers);

        // then
        assertThat(result).isTrue();
    }
}