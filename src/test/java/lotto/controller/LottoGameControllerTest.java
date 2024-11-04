package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameControllerTest {
    private LottoMachine lottoMachine;
    private LottoGameController controller;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
        controller = new LottoGameController();
    }

    @DisplayName("당첨 번호가 유효할 때 예외가 발생하지 않는다.")
    @Test
    void 당첨번호가_유효할때_예외가_발생하지않는다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> new Lotto(winningNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스번호가_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        assertThatThrownBy(() -> Lotto.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 유효할 때 예외가 발생하지 않아야 한다.")
    @Test
    void 보너스번호가_유효할때_예외가_발생하지않는다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThatCode(() -> Lotto.validateBonusNumber(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }
}