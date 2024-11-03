package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호를 저장하는 numbers는 변경할 수 없어야 한다.")
    @Test
    void 로또_번호를_저장하는_numbers는_변경할_수_없어야_한다(){
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(numbers))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 로또_번호의_개수가_6개를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @Test
    void 로또_번호의_개수가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("로또 번호에 1 미만이거나 45를 초과하는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideIntegerList")
    void 로또_번호에_1_미만이거나_45를_초과하는_숫자가_있으면_예외가_발생한다(List<Integer> wrongNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(wrongNumbers))
                .withMessageStartingWith("[ERROR]");
    }


    static Stream<List<Integer>> provideIntegerList() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(41, 42, 43, 44, 45, 46)
        );
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
