package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @DisplayName("로또 번호가 6개를 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_DUPLICATED.getMessage());
    }

    @DisplayName("오름차순으로 정렬된 로또를 반환하는지 확인함.")
    @Test
    void 로또_번호_정렬을_확인한다() {
        List<Integer> testNumbers = List.of(6, 5, 4, 3, 2, 1);
        String answer = "[1, 2, 3, 4, 5, 6]";
        Lotto result = new Lotto(testNumbers);
        assertThat(result.getSortedLotto().toString()).isEqualTo(answer);
    }

    @DisplayName("로또가 특정 번호를 가지고 있는지 확인함.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또가_특정_숫자를_가지고_있는지_확인한다(int target) {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean result = testLotto.hasNumber(target);
        assertThat(result).isEqualTo(true);

    }

    @DisplayName("로또가 특정 번호를 가지고 있지 않은지 확인함.")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10, 11, 12})
    void 로또가_특정_숫자를_갖고있지_않은지_확인한다(int target) {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean result = testLotto.hasNumber(target);
        assertThat(result).isEqualTo(false);

    }

    @DisplayName("서로 다른 로또가 몇 개의 숫자를 공유하는지 확인함.")
    @Test
    void 로또가_서로_몇개의_숫자를_공유하는지_확인() {
        Lotto testLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto testLotto2 = new Lotto(List.of(4, 5, 6, 8, 9, 10));

        assertThat(testLotto1.countDuplication(testLotto2)).isEqualTo(3);
    }

    @DisplayName("서로 다른 로또가 몇 개의 숫자를 공유하는지 확인함2.")
    @Test
    void 로또가_서로_몇개의_숫자를_공유하는지_확인2() {
        Lotto testLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto testLotto2 = new Lotto(List.of(4, 5, 6, 1, 9, 10));

        assertThat(testLotto1.countDuplication(testLotto2)).isEqualTo(4);
    }

    @DisplayName("로또가 범위 외의 숫자를 가지고 있는지 확인합니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 100, -100})
    void 범위_외_로또_숫자_확인(int target) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, target)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}
