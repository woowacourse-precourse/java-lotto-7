package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호를 정상적으로 입력한다")
    @Test
    void success_lotto() {
        //given, when
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> numbers = lotto.getNumbers();

        //then
        Assertions.assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void exception_overSixSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 적다면 예외가 발생한다")
    @Test
    void exception_underSixSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void exception_duplicateNum() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45가 아니라면 예외가 발생한다")
    @Test
    void exception_overBoundary() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 1000)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 출력한다")
    @Test
    void success_printLottoList() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        String string = lotto.toString();

        //then
        Assertions.assertThat(string).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
