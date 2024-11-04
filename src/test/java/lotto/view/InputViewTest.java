package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.LottoUtils;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final LottoUtils lottoUtils = new LottoUtils();

    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoUtils.convertInputToCash("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoUtils.convertInputToCash("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_0_이하면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoUtils.convertInputToCash("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
