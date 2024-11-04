package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName(" 로또번호 생성 성공")
    void createLottoSuccessTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또번호 갯수 불일치 실패")
    void lottoCountFailTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("중복되는 로또번호 예외")
    void lottoDuplicateNumberFailTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복되는 로또 번호가 존재합니다.");
    }

    @Test
    @DisplayName("로또번호 범위 초과 예외")
    void LottoNumberRangeFailTest() {
        // given
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또번호 범위 미달 예외")
    void LottoNumberNotRangeFailTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또번호 정렬 확인")
    void LottoNumSortSuccessTest() {
        // given
        List<Integer> numbers = Arrays.asList(3, 1, 4, 6, 5, 2);
        Lotto lotto = new Lotto(numbers);

        // when
        String lottoString = lotto.toString();

        // then
        assertThat(lottoString).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
