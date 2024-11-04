package lotto.domain.winning;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Number;
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
        int number = 9;
        WinningLotto winningLotto = WinningLotto.of(numbers);

        BonusNumber bonusNumber = BonusNumber.valueOf(winningLotto, number);

        assertThat(bonusNumber).isNotNull();
        assertThat(bonusNumber.getValue()).isEqualTo(number);
        assertThat(bonusNumber).isInstanceOf(Number.class);
    }

    @DisplayName("당첨 번호에 포함된 숫자가 입력될 경우 예외")
    @Test
    void 중복_숫자_입력_예외() {
        WinningLotto winningLotto = WinningLotto.of(numbers);

        assertThatThrownBy(() -> BonusNumber.valueOf(winningLotto, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }
}
