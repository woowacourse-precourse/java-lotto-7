package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 갯수가 6개가 아닐시 예외")
    @Test
    void lottoSizeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중복시 예외")
    @Test
    void lottoDuplicateNumberTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 범위 밖 숫자 포함시 예외")
    @Test
    void lottoNumberRangeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, -4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 성공 및 정렬")
    @Test
    void lottoNumberTest() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 숫자 일치 갯수 테스트")
    @ParameterizedTest
    @MethodSource("lottos")
    void lottoContainNumberTest(List<Integer> numbers,List<Integer> winningNumbers,int expected) {
        Lotto lotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(winningNumbers);
        assertThat(winningLotto.countSameNumbers(lotto)).isEqualTo(expected);
    }

    static Stream<Arguments> lottos() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6),List.of(5,6,7,8,9,10),2),
                Arguments.of(List.of(1,2,3,4,5,6),List.of(1,2,3,4,5,6),6),
                Arguments.of(List.of(1,2,3,4,5,6),List.of(7,8,9,10,11,12),0)
        );
    }

}
