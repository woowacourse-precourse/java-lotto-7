package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호 갯수 6개 체크")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중복 체크")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    static Stream<List<Integer>> provideIntArrays() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @DisplayName("로또 번호 범위 1~45 체크")
    @ParameterizedTest
    @MethodSource("provideIntArrays")
    void 로또_번호가_1과_45_사이의_값이_아니면_예외가_발생한다(List<Integer> elements) {
        assertThatThrownBy(() -> new Lotto(elements))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 오름차순 정렬 체크")
    @Test
    void 로또_번호가_오름차순이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 6, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
