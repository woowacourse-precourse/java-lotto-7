package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("무작위로 6개의 숫자를 생성한다.")
    @Test
    void 무작위로_6개의_숫자를_생성한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            Lotto lotto = new Lotto();
            assertThat(lotto.getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
        }, List.of(8, 21, 23, 41, 42, 43));
    }


    @DisplayName("당첨 번호를 지닌 로또와 비교한다.")
    @Test
    void 당첨_번호를_지닌_로또와_비교한다() {
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(8, 19, 23, 32, 33, 43));
        assertThat(lotto1.matchNumbers(lotto2)).isEqualTo(3);
    }

    @DisplayName("보너스 번호와 비교한다.")
    @Test
    void 보너스_번호와_비교한다() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        assertThat(lotto.matchBonusNumber(8)).isEqualTo(true);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
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

    @DisplayName("로또 번호에 범위가 넘어선 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_범위가_넘어선_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46))).isInstanceOf(IllegalArgumentException.class);
    }
}
