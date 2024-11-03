package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private static final String ERROR_PREFIX = "[ERROR]";
    List<Integer> numbers;

    @BeforeEach
    void init() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("객체 생성 테스트")
    @Test
    void 객체생성_테스트() {
        Number number = Number.of(9);
        WinningNumbers winningNumbers = WinningNumbers.of(numbers);

        BonusNumber bonusNumber = BonusNumber.valueOf(winningNumbers, number);

        assertThat(bonusNumber).isNotNull();
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(number);
    }

    @DisplayName("당첨 번호에 포함된 숫자가 입력될 경우 예외")
    @Test
    void 중복_숫자_입력_예외() {
        Number number = Number.of(1);
        WinningNumbers winningNumbers = WinningNumbers.of(numbers);

        assertThatThrownBy(() -> BonusNumber.valueOf(winningNumbers, number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }
}
