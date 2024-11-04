package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 정상적으로 생성됨")
    void makeBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        BonusNumber bonusNumber = new BonusNumber("7", winningLotto);

        assertThat(bonusNumber.getValue()).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닐 시 예외 발생")
    void notNumberException() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber("a", winningLotto))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1에서 45 사이가 아닐 시 예외 발생")
    void invalidNumberRangeException() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber("0", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber("46", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복일 시 예외 발생")
    void bonusNumberDuplicate() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber("1", winningLotto))
                        .isInstanceOf(IllegalArgumentException.class);
    }

}