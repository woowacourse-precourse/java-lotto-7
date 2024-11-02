package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    void 로또_번호는_1부터_45사이의_숫자여야_한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 45, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또를_자동으로_발행한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    Lotto generatedLotto = Lotto.generateLotto();
                    assertThat(generatedLotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
