package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.domain.Lotto;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순으로 출력되어야 한다.")
    @Test
    void 로또_번호가_오름차순으로_출력되어야_한다() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(new Lotto(List.of(6, 5, 4, 3, 2, 1)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(new Lotto(List.of(1, 11, 21, 31, 41, 45)).toString()).isEqualTo("[1, 11, 21, 31, 41, 45]");
    }

    @DisplayName("로또는 정해진 개수만큼 생성되어야 한다.")
    @Test
    void 로또는_정해진_개수만큼_생성되어야_한다() {
        int maxCount = 50;
        for (int i = 1; i < maxCount; i++) {
            assertThat(Lotto.generateLottos(i).size()).isEqualTo(i);
        }
    }

    @DisplayName("로또는 1장 이상 구매할 수 없다.")
    @Test
    void 로또는_1장_이상_구매할_수_있다() {
        int[] failCases = {0, -1, -100};

        for (int failCase : failCases) {
            assertThatThrownBy(() -> Lotto.generateLottos(failCase))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
