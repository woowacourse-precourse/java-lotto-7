package lotto.domain.lotto;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

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

    @DisplayName("로또 당첨 번호를 입력할 수 있다.")
    @Test
    void 로또_당첨_번호_입력_테스트() throws Exception{
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        // when
        lotto.addNumbers(numbers);

        // then
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

}
