package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBonusNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBonusNumberTest {
    private Lotto winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
    }

    @Test
    void 보너스_번호가_범위를_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBonusNumber(winningNumbers, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다")
    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBonusNumber(winningNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
