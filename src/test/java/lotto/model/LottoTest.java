package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("hitTest")
    @DisplayName("일치하는 수 개수 테스트")
    void prize_findByHitAndBonusTest(Lotto lotto, String message, int hitCount) {
        Lotto sampleLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(sampleLotto.countHit(lotto), hitCount);
    }

    static Stream<Arguments> hitTest() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "6개 일치", 6),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 12)), "5개 일치", 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 11, 12)), "4개 일치", 4),
                Arguments.of(new Lotto(List.of(1, 2, 3, 10, 11, 12)), "3개 일치", 3),
                Arguments.of(new Lotto(List.of(1, 2, 9, 10, 11, 12)), "2개 일치", 2),
                Arguments.of(new Lotto(List.of(1, 8, 9, 10, 11, 12)), "1개 일치", 1),
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), "0개 일치", 0)
        );
    }
}
