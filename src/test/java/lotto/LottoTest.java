package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    @DisplayName("로또 번호 6개 미만 예외 확인")
    @Test
    void checkLottoNumber5Error() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 범위 예외 확인")
    @ValueSource(ints = {0, 46, 100, -1})
    void checkBoundaryLottoNumbersError(int testNum) {
        WinningLotto.resetInstance();
        List<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        test.add(testNum);
        String errorMessage = "[ERROR] 로또 번호가 범위를 벗어나는 번호가 있습니다.";

        assertThatThrownBy(() -> new Lotto(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("정상 동작 확인")
    @ValueSource(ints = {1, 45, 10, 30})
    void checkLotto(int testNum) {
        WinningLotto.resetInstance();
        List<Integer> test = new ArrayList<>(Arrays.asList(3, 20, 33, 13, 44));
        test.add(testNum);

        assertDoesNotThrow(() -> new Lotto(test));
    }
}
