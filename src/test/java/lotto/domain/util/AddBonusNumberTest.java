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
}