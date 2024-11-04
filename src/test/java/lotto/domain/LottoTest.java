package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또 번호가 6개가 아니면 예외를 발생 한다.")
    @Test
    void validateCountExceptionTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위가 아니면 예외가 발생한다.")
    @Test
    void validateWithinRangeExceptionTest() {
        assertThatThrownBy(() -> new Lotto(List.of(100, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateUniqueExceptionTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto클래스 생성 테스트")
    @Test
    void newInstanceTest() {
        Lotto lotto1 = Lotto.newInstance();
        Lotto lotto2 = Lotto.newInstance();

        // 두 객체가 서로 다른 객체임을 테스트한다.
        assertThat(lotto1).isNotSameAs(lotto2);
    }

}
