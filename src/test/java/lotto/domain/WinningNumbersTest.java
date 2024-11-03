package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {
    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4", "5", "6"})
    void 당첨_번호와_보너스_번호가_중복되면_예외처리(int number) {
        //given
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        //when & then
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }
}