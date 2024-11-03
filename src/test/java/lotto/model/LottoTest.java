package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto purchasedLotto;

    @BeforeEach
    void setUp() {
        purchasedLotto = new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10));
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lottoNumberMatchingCount")
    public void 로또_번호_일치_개수_확인(List<Integer> winningNumbers, int expectedCount) {
        assertEquals(expectedCount, purchasedLotto.getMatchingCount(winningNumbers));
    }

    private static Stream<Arguments> lottoNumberMatchingCount() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 2),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 4),
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), 6)
        );
    }

    @Test
    void 로또_번호_5개_일치_시_보너스_번호_확인() {
        assertTrue(purchasedLotto.hasBonusNumber(Arrays.asList(1, 2, 7, 8, 9, 11), 10));
    }

    @Test
    void 로또_번호_5개_일치하지_않으면_보너스_번호_확인_실패() {
        assertFalse(purchasedLotto.hasBonusNumber(Arrays.asList(1, 2, 7, 8, 5, 4), 6));
    }

    @Test
    void 로또_번호_5개_일치하나_보너스_번호_없음() {
        assertFalse(purchasedLotto.hasBonusNumber(Arrays.asList(1, 2, 7, 8, 9, 13), 12));
    }
}
