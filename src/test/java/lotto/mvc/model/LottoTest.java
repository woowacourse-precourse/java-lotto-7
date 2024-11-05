package lotto.mvc.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 객체 생성자에 대한 검증")
class LottoTest {
    @Test
    @DisplayName("예외 테스트 - 로또 번호의 개수가 6개가 넘어가는 경우")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외 테스트 - 로또 번호에 중복된 숫자가 있는 경우")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외 테스트 - 로또 번호의 개수가 6개보다 적은 경우")
    void test3() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 테스트 - 변경 불가능한 리스트가 넘어올 경우")
    void test4() {
        assertThat(new Lotto(List.of(1, 2, 4, 3, 5, 6)).equals(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }
}
