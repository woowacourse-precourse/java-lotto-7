package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void 숫자_6개를_뽑아_로또를_한장_발행한다(int lottoNumbersIndex) {
        List<Integer> testNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(testNumbers);

        assertThat(lotto.getNumbers()).contains(testNumbers.get(lottoNumbersIndex));
    }

    @ParameterizedTest
    @MethodSource("lottoWithMatchingNumberProvider")
    void 숫자_6개_중_당첨번호와_일치하는_개수를_확인한다(int expectedMatchingAmount, List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumber = new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6)
        );

        assertThat(lotto.checkMatchingAmountWith(winningNumber)).isEqualTo(expectedMatchingAmount);
    }
    static Stream<Object[]> lottoWithMatchingNumberProvider() {
        return Stream.of(
                new Object[]{6, Arrays.asList(1, 2, 3, 4, 5, 6)}, //6개 일치
                new Object[]{5, Arrays.asList(1, 2, 3, 4, 5, 7)}, //5개 일치
                new Object[]{5, Arrays.asList(1, 2, 3, 4, 5, 8)}, //5개 일치
                new Object[]{4, Arrays.asList(1, 2, 3, 4, 8, 9)}, //4개 일치
                new Object[]{3, Arrays.asList(1, 2, 3, 8, 9, 10)}, //3개 일치
                new Object[]{2, Arrays.asList(1, 2, 8, 9, 10, 11)}, //2개 일치
                new Object[]{1, Arrays.asList(1, 8, 9, 10, 11, 12)}, //1개 일치
                new Object[]{0, Arrays.asList(8, 9, 10, 11, 12, 13)} //0개 일치
        );
    }

    @Test
    void 보너스번호가_일치하면_true를_반환한다() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        int bonusNumber = 7;

        assertThat(lotto.contains(bonusNumber)).isTrue();
    }

    @Test
    void 보너스번호가_불일치하면_false를_반환한다() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 7;

        assertThat(lotto.contains(bonusNumber)).isFalse();
    }
}
