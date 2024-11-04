package lotto.back.domain;

import java.util.List;
import lotto.global.exception.DuplicatedLottoNumberException;
import lotto.global.exception.InvalidLottoNumberCountException;
import lotto.global.exception.InvalidLottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DrawnNumbersTest {

    @Test
    @DisplayName("6개의 중복되지 않은 숫자가 들어왔을 때 추첨 번호 객체 생성")
    void 추첨번호_객체_생성_테스트() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        //when
        DrawnNumbers drawnNumbers = new DrawnNumbers(numbers);
        //then
        assertThat(drawnNumbers.getDrawnNumbers()).containsAll(numbers);
    }

    @Test
    @DisplayName("6개 중 중복된 숫자가 들어왔을 때 예외 발생")
    void 추첨번호_생성_예외_테스트1() {
        //given
        List<Integer> drawnNumbers = List.of(1, 2, 3, 4, 5, 5);
        //when
        //then
        assertThatThrownBy(() -> new DrawnNumbers(drawnNumbers)).isInstanceOf(DuplicatedLottoNumberException.class);
    }

    @Test
    @DisplayName("5개의 숫자가 들어왔을 때 예외 발생")
    void 추첨번호_생성_예외_테스트2() {
        //given
        List<Integer> drawnNumbers = List.of(1, 2, 3, 4, 5);
        //when
        //then
        assertThatThrownBy(() -> new DrawnNumbers(drawnNumbers)).isInstanceOf(InvalidLottoNumberCountException.class);
    }

    @Test
    @DisplayName("6개의 숫자 중 범위를 벗어나는 추첨 번호가 들어왔을 때 예외 발생")
    void 추첨번호_생성_예외_테스트3() {
        //given
        List<Integer> drawnNumbers = List.of(1, 2, 3, 4, 5, 46);
        //when
        //then
        assertThatThrownBy(() -> new DrawnNumbers(drawnNumbers)).isInstanceOf(InvalidLottoNumberRangeException.class);
    }
}