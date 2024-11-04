package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.domain.Lotto;
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유니크한 로또 번호 6개를 받으면 로또가 생성된다.")
    void testValidLottoTest() {
        assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또는 번호들을 오름차순으로 정렬한다.")
    void testSortLottoNumbers() {
        Lotto lotto = new Lotto(List.of(5, 3, 6, 1, 2, 4));

        assertThat(lotto.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);  // 정렬된 순서 확인
    }
}
