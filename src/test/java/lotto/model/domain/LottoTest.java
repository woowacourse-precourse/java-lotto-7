package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.handler.LottoErrorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    void 문자열_변환_테스트() {
        //given
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        //when
        String toString = new Lotto(integerList).toString();
        //then
        assertThat("[1, 2, 3, 4, 5, 6]")
                .isEqualTo(toString);
    }

    @Test
    void 여섯개_넘어가는_예외_테스트() {
        //given
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7);

        //when,then
        assertThatThrownBy(
                () -> new Lotto(integerList))
                .isInstanceOf(LottoErrorHandler.class);
    }

    @Test
    void 숫자_범위_예외_테스트() {
        //given
        List<Integer> integerList = List.of(46, 2, 3, 4, 5, 6);

        //when,then
        assertThatThrownBy(
                () -> new Lotto(integerList))
                .isInstanceOf(LottoErrorHandler.class);
    }

    @Test
    void 중복_예외_테스트() {
        //given
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 5);

        //when,then
        assertThatThrownBy(
                () -> new Lotto(integerList))
                .isInstanceOf(LottoErrorHandler.class);
    }
}
