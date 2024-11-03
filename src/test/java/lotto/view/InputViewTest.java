package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Lotto;
import lotto.Utils;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final Utils utils = new Utils();

    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> utils.convertInputToCash("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> utils.convertInputToCash("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_0보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> utils.convertInputToCash("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
