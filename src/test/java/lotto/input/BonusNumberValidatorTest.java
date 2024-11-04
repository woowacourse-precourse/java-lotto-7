package lotto.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enums.ErrorMessages.*;

class BonusNumberValidatorTest {
    private BonusNumberValidator bonusNumberValidator;
    List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        bonusNumberValidator = new BonusNumberValidator();
        winningNumbers = List.of(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("입력이 유효할 때 보너스 번호 반환 테스트")
    void bonusNumberIsValid() {
        //given
        String input = "7";
        int actualBonusNumber = 7;

        //when
        int expectedBonusNumber = bonusNumberValidator.validateInput(input, winningNumbers);

        //then
        Assertions.assertThat(actualBonusNumber).isEqualTo(expectedBonusNumber);
    }

    @Test
    @DisplayName("입력에 숫자 이외의 문자가 입력되었을 경우 예외 발생 테스트")
    void bonusNumberIsInvalidFormat() {
        String input = "7abc";

        Assertions.assertThatThrownBy(() -> bonusNumberValidator.validateInput(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BONUS_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 로또 범위(1~45)를 벗어났을때 예외 발생 테스트")
    void bonusNumberIsOutOfRange() {
        String input = "50";

        Assertions.assertThatThrownBy(() -> bonusNumberValidator.validateInput(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BONUS_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생 테스트")
    void bonusNumberIsDuplicated() {
        String input = "1";

        Assertions.assertThatThrownBy(() -> bonusNumberValidator.validateInput(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS_NUMBER.getMessage());
    }
}