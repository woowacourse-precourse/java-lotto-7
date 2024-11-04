package lotto.domain.model;

import lotto.domain.model.bonus.BonusNumber;
import lotto.exception.bonus.BonusErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class BonusNumberTest {
    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = List.of(8, 21, 15, 33, 40, 42);
    }

    @Test
    @DisplayName("보너스 번호가 공백일 경우 예외가 발생한다.")
    void 보너스_번호가_공백일_경우_예외가_발생한다() {
        String invalidInput = "";

        assertThatNullPointerException()
                .isThrownBy(() -> new BonusNumber(invalidInput, winningNumbers))
                .withMessage(BonusErrorMessages.INVALID_EMPTY.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "-5", "7,8"})
    @DisplayName("보너스 번호가 숫자가 아니거나 음수이거나 쉼표를 포함할 경우 IllegalArgumentException이 발생한다.")
    void 보너스_번호가_숫자가_아니거나_음수_또는_쉼표를_포함할_경우_예외가_발생한다(String invalidInput) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(invalidInput, winningNumbers))
                .withMessage(BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1에서 45 범위를 벗어날 경우 예외가 발생한다.")
    void 보너스_번호가_범위를_벗어날_경우_예외가_발생한다() {
        // given
        String outOfRangeInput = "50";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(outOfRangeInput, winningNumbers))
                .withMessage(BonusErrorMessages.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        // given
        String duplicateInput = "21";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(duplicateInput, winningNumbers))
                .withMessage(BonusErrorMessages.DUPLICATE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("올바른 보너스 번호가 입력될 경우 정상적으로 생성된다.")
    void 올바른_보너스_번호가_입력될_경우_정상적으로_생성된다() {
        // given
        String validInput = "7";

        // when
        BonusNumber bonusNumber = new BonusNumber(validInput, winningNumbers);

        // then
        assertThat(bonusNumber.getNumber()).isEqualTo(7);
    }
}