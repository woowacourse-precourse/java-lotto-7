package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("정상적인 로또 번호 입력 테스트")
    void 정상적인_로또_번호_입력_테스트() {
        //given
        Lotto lotto1 = new Lotto("1,2,3,4,5,6");
        Lotto lotto2 = new Lotto(" 1, 2, 3,, 4, 5, 6");

        //when
        List<Integer> numbers1 = lotto1.getNumbers();
        List<Integer> numbers2 = lotto2.getNumbers();

        //then
        assertThat(numbers1.size()).isEqualTo(6);
        assertThat(numbers2.size()).isEqualTo(6);
        assertThat(numbers1).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(numbers2).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("6개가 아닌 당첨 번호 입력 테스트")
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 6, 7"))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1, 2, 3, 4, 5"))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("중복되는 로또 번호 입력 테스트")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 5"))
                .withMessage("[ERROR] 로또 번호는 중복되면 안됩니다.");
    }

    @Test
    @DisplayName("1~45 사이를 벗어난 로또 번호 입력 테스트")
    void 입력된_번호가_1부터_45_사이에_속하지_않은_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1, 2, 46, 4, 32, 22"))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("34, 12, 0, 4, 13, 23"))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("6, 9, 3, 12, -1, 32"))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("정수가 아닌 입력 테스트")
    void 정수가_입력되지_않은_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1, 2, 3, 4.4, 5, 6"))
                .withMessage("[ERROR] 정수를 입력해주세요.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1, 2, 3, a, 5, 6"))
                .withMessage("[ERROR] 정수를 입력해주세요.");
    }
}
