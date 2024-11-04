package lotto.domain;

import lotto.constants.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    void 로또_번호가_45를_초과할_떄 () {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 99)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 로또_번호가_1_미만일_때 () {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 로또_번호가_비었을_때 () {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBER_NOT_EMPTY);
    }

    @Test
    void 정렬_후_반환하는_getter () {
        // given
        Lotto lotto = new Lotto(List.of(32, 1, 42, 23, 15, 25));
        List<Integer> result;

        // when
        result = lotto.getSortNumbers();

        // then
        assertThat(result.toString()).isEqualTo(List.of(1, 15, 23, 25, 32, 42).toString());
    }
}
