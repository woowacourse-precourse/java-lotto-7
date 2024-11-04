package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("6개가 아닌 당첨 번호 입력 테스트")
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("1~45 사이를 벗어난 로또 번호 입력 테스트")
    void 입력된_번호가_1부터_45_사이에_속하지_않은_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 46, 4, 32, 22)))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(34, 12, 0, 4, 13, 23)))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(6, 9, 3, 12, -1, 32)))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
