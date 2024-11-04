package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoBonusNumberTest {
    private Lotto winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스_번호를_생성한다() {
        assertThatNoException()
                .isThrownBy(() -> new LottoBonusNumber(winningNumbers, 8));
    }

    @Test
    void 보너스_번호가_범위를_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBonusNumber(winningNumbers, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBonusNumber(winningNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호를_반환한다() {
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(winningNumbers, 8);
        assertThat(lottoBonusNumber.getValue()).isEqualTo(8);
    }
}
