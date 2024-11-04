package lotto.domain;

import lotto.constant.LottoTestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
    void 로또_번호_범위_예외_테스트_1() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @Test
    void 로또_번호_범위_예외_테스트_2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @Test
    void 로또_번호_수_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @Test
    void 로또_문자열_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String expectedMessage = "[1, 2, 3, 4, 5, 6]\n";

        assertThat(lotto.toString()).isEqualTo(expectedMessage);
    }

    @Test
    void 로또_문자열_오름차순_정렬_테스트() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        String expectedMessage = "[1, 2, 3, 4, 5, 6]\n";

        assertThat(lotto.toString()).isEqualTo(expectedMessage);
    }
}
