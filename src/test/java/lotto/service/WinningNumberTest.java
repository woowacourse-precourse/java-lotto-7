package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("당첨번호 생성")
    @Test
    void 당첨번호_생성(){
        List<Integer> winningNumbers= Arrays.asList(1,2,3,4,5,6);
        WinningNumber winningNumber=new WinningNumber(winningNumbers);
        assertThat(winningNumber.getNumbers()).isEqualTo(winningNumbers);
    }

    @DisplayName("당첨 번호는 6개여야 한다")
    @Test
    void 당첨번호_개수_검증() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new WinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("중복된 당첨 번호가 있을 경우 예외 발생")
    @Test
    void 중복된_당첨번호_검증() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        assertThatThrownBy(() -> new WinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 번호가 있습니다.");
    }

    @DisplayName("당첨 번호가 범위를 벗어나는 경우 예외 발생")
    @Test
    void 범위를_벗어난_당첨번호_검증() {
        List<Integer> winningNumbers = Arrays.asList(0, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new WinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호가 범위를 벗어납니다.");
    }

    @DisplayName("null 값 입력 시 예외 발생")
    @Test
    void null_값_입력_검증() {
        assertThatThrownBy(() -> new WinningNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력하세요");
    }

    @DisplayName("당첨 번호가 46 이상인 경우 예외 발생")
    @Test
    void 당첨번호가_46이상인_경우_검증() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> new WinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호가 범위를 벗어납니다.");
    }
}