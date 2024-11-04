package io.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputLottoHandlerTest {

    InputLottoHandler inputLottoHandler = new InputLottoHandler();

    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외 처리")
    @Test
    void isDivisibleByThousand() {
        // given
        int number = 120001;

        // when // then
        assertThatThrownBy(() -> inputLottoHandler.isDivisibleByThousand(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 단위로 입력해주세요.");
    }

    @DisplayName("로또 당첨 번호가 6개가 아닌 경우 예외 처리")
    @Test
    void checkLength() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5);

        // when // then
        assertThatThrownBy(() -> inputLottoHandler.checkLength(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개가 되어야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외 처리")
    @Test
    void isDuplicate() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,5);

        // when // then
        assertThatThrownBy(() -> inputLottoHandler.isDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자는 없어야 됩니다.");
    }
    
    @DisplayName("로또 번호 1 ~ 45까지의 숫자가 아닌 경우 예외 처리")
    @Test
    void checkRange() {
        // given
        int number = 46;

        // when // then
        assertThatThrownBy(() -> inputLottoHandler.checkRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}