package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @DisplayName("숫자가 겹칠시 예외를 반환한다.")
    @Test
    void test1() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(6, 6, 6, 6, 6, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 초과하여 생성시 예외 반환한다")
    @Test
    void test2() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("각 숫자가 1 ~ 45 가 아닐 시 예외 반환한다")
    @Test
    void test3() {
        assertThatThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 10000)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
