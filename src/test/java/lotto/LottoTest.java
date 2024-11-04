package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 로또_번호가_로또_번호의_숫자_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호들이 중복되지 않고, 범위 내에 있고, 6개인 경우")
    @Test
    void 유효한_로또_객체를_생성하면_예외가_발생하지_않는다() {
        assertSimpleTest(() ->
                assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 45))).doesNotThrowAnyException()
        );
    }

    @Test
    void 로또가_오름차순으로_정렬된다() {
        assertSimpleTest(() -> {
            // given
            Lotto lotto = new Lotto(List.of(6, 5, 13, 23, 16, 43));

            // when
            lotto.sort();

            // then
            assertThat(lotto.indexOf(5)).isEqualTo(0);
            assertThat(lotto.indexOf(6)).isEqualTo(1);
            assertThat(lotto.indexOf(13)).isEqualTo(2);
            assertThat(lotto.indexOf(16)).isEqualTo(3);
            assertThat(lotto.indexOf(23)).isEqualTo(4);
            assertThat(lotto.indexOf(43)).isEqualTo(5);
        });
    }
}
