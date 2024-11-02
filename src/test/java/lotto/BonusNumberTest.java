package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = WinningNumber.from("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호가 정상적으로 저장된다.")
    @Test
    void 보너스_번호가_정상적으로_저장된다() {
        BonusNumber.from("45", winningNumber);
    }

    @DisplayName("보너스 번호가 null일 경우 예외가 발생한다")
    @Test
    void 보너스_번호가_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from(null, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("3", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }


    @DisplayName("보너스 번호가 0 이하일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_0_이하일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("0", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호가 46 이상일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_46_이상일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("46", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호가 -23억 이하일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_마이너스_23억_이하일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("-2300000000", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호가 23억 이상일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_23억_이상일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("2300000000", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("보너스 번호에 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호에_문자가_입력될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("-1", winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("당첨 번호가 null일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_null일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("7", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
