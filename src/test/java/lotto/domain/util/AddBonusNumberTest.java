package lotto.domain.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AddBonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 추가되는지 테스트한다.")
    void bonusNumberTest() {
        String winningNumber = "1,2,3,4,5,6";
        String bonusNumber = "7";
        List<Integer> winningNumbers = CreateWinningNumber.create(winningNumber);

        List<Integer> numbers = AddBonusNumber.add(winningNumbers, bonusNumber);

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 숫자가 아니면 예외를 발생한다.")
    @ValueSource(strings = {"a", "?", "1.3", "가", "1a"})
    void bonusNumberTest1(String number) {
        String winningNumber = "1,2,3,4,5,6";
        List<Integer> winningNumbers = CreateWinningNumber.create(winningNumber);

        assertThatThrownBy(() -> AddBonusNumber.add(winningNumbers, number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외를 발생한다.")
    void bonusNumberTest2() {
        String winningNumber = "1,2,3,4,5,6";
        String bonusNumber = "46";
        List<Integer> winningNumbers = CreateWinningNumber.create(winningNumber);

        assertThatThrownBy(() -> AddBonusNumber.add(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}