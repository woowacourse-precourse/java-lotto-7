package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {
    @DisplayName("당첨_번호의_개수가_6개가_넘어가면_예외가_발생하는 경우 테스트")
    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생하는_경우_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개 입니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생하는 경우 테스트.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생하는_경우_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 하나가 범위를 벗어나면 예외가 발생하는 경우 테스트.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -9})
    void 당첨_번호가_범위를_벗어나면_예외가_발생하는_경우_테스트(int invalidNumber) {
        assertThatThrownBy(() -> new WinningNumber(List.of(invalidNumber, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자는 1 이상 45 이하입니다.");
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생하는 경우 테스트.")
    void 당첨_번호의_개수가_6개_미만이면_예외가_발생하는_경우_테스트() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개 입니다.");
    }

    @Test
    @DisplayName("유효한 당첨 번호 리스트가 주어지면 WinningNumber 객체가 정상적으로 생성되는 경우 테스트.")
    void 유효한_당첨_번호_리스트가_주어지면_WinningNumber_객체가_정상적으로_생성되는_경우_테스트() {
        WinningNumber WinningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(WinningNumber.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
