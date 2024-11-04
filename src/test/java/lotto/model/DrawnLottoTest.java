package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class DrawnLottoTest {
    
    @DisplayName("유효한 당첨 번호와 보너스 번호로 DrawnLotto 객체 생성 성공")
    @Test
    void 유효한_당첨번호와_보너스번호_입력시_객체_성공적으로_생성() {
        String drawnNumbers = "1, 2, 3, 4, 5, 6";
        String bonusNumber = "7";
        
        assertThatCode(() -> new DrawnLotto(drawnNumbers, bonusNumber))
            .doesNotThrowAnyException();
    }
    
    @DisplayName("당첨 번호가 6개가 아니면 예외 발생")
    @Test
    void 당첨_번호가_6개가_아니면_예외_발생() {
        String drawnNumbers = "1, 2, 3, 4, 5";
        String bonusNumber = "6";

        assertThatThrownBy(() -> new DrawnLotto(drawnNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 포함되면 예외 발생")
    @Test
    void 당첨_번호에_숫자가_아닌_값이_포함되면_예외_발생() {
        String drawnNumbers = "1, 2, abc, 4, 5, 6";
        String bonusNumber = "7";

        assertThatThrownBy(() -> new DrawnLotto(drawnNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외 발생")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외_발생() {
        String drawnNumbers = "1, 2, 2, 3, 4, 5";
        String bonusNumber = "7";

        assertThatThrownBy(() -> new DrawnLotto(drawnNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외_발생() {
        String drawnNumbers = "1, 2, 3, 4, 5, 6";
        String bonusNumber = "6";

        assertThatThrownBy(() -> new DrawnLotto(drawnNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외 발생")
    @Test
    void 보너스_번호가_규정된_범위를_벗어나면_예외_발생() {
        String drawnNumbers = "1, 2, 3, 4, 5, 6";
        String bonusNumber = "0";

        assertThatThrownBy(() -> new DrawnLotto(drawnNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
