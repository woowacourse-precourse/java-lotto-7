package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidateTest {

    BonusNumberValidate bonusNumberValidate = new BonusNumberValidate();

    @Test
    @DisplayName("보너스번호_예외처리_테스트")
    void bonusNumberValidateTest() {
        String input = "10";
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        bonusNumberValidate.validate(input, winningNumber);
    }

    @Test
    @DisplayName("보너스번호_예외처리_입력값_자료형_테스트")
    void bonusNumberCheckTypeTest() {
        String input = "String";
        List<Integer> winningNumber = new ArrayList<>();
        assertThatThrownBy(() -> bonusNumberValidate.validate(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스번호_예외처리_입력값_범위_테스트")
    void bonusNumberCheckRangeTest() {
        String input = "50";
        List<Integer> winningNumber = new ArrayList<>();
        assertThatThrownBy(() -> bonusNumberValidate.validate(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스번호_예외처리_입력값_중복_테스트")
    void bonusNumberCheckDuplicateTest() {
        String input = "6";
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> bonusNumberValidate.validate(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}