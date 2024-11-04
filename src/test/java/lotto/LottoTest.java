package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("로또 번호에 음수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -39, -44})
    void negativeLottoTest(int lotto) {
        // given

        // when

        // then
        assertThatThrownBy(() -> new Lotto(List.of(lotto, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 음수를 입력할 수 없습니다.");
    }

    @DisplayName("1~45 사이의 로또 번호를 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 3000, 200})
    void lottoInRangeTest(int lotto) {
        // given

        // when

        // then
        assertThatThrownBy(() -> new Lotto(List.of(lotto, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이의 숫자를 입력해주세요.");
    }

    @Test
    void createLottoTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> result;
        // when
        result = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers).isEqualTo(result);

    }

}
