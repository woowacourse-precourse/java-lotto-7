package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100, 44214})
    void bonusNumberInRangeTest(int bonusNumber) {
        // given

        // when

        // then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해주세요.");
    }

    @DisplayName("보너스 번호에 음수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -45, -22, -11})
    void negativeBonusNumberTest(int bonusNumber) {
        // given

        // when

        // then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 음수를 입력할 수 없습니다.");
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호를 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void duplicatedBonusNumberTest(int bonusNumber) {
        // given

        // when

        // then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
    }

    @DisplayName("올바른 보너스 번호를입력하면 보너스 번호를 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 22, 45, 11, 44, 32, 23})
    void createBonusNumberTest(int bonusNumber) {
        // given

        // when

        // then
        assertThat(BonusNumber.of(bonusNumber, lotto).getBonusNumber())
                .isEqualTo(bonusNumber);

    }

}