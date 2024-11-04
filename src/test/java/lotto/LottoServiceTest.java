package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoService.convertInputToCash("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoService.convertInputToCash("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_0_이하면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoService.convertInputToCash("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertInputToCash() {
    }

    @Test
    void parseWinningNumber() {
    }

    @Test
    void parseBonusNumber() {
    }

    @Test
    void getLotto() {
    }
}