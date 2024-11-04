package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusNumberTest {

    @Test
    void 보너스_번호의_범위가_올바르지_않은_경우_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 3, 4, 7, 10, 30));
        assertThatThrownBy(() -> new LottoBonusNumber(50, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 3, 4, 7, 10, 30));
        assertThatThrownBy(() -> new LottoBonusNumber(4, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
