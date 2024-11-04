package lotto.model;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
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
    @CsvSource({
            "'1,7,8,9,10,11', 1",
            "'1,2,7,8,9,10', 2",
            "'1,2,3,7,8,9', 3",
            "'1,2,3,4,7,8', 4",
            "'1,2,3,4,5,7', 5",
            "'1,2,3,4,5,6', 6"
    })
    @DisplayName("구매한 로또와 당첨 번호에 대해 추첨 결과를 계산한다.")
    void 당첨_번호_추첨_테스트(String numbers, int expectedResult) {
        // given
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(numberList);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        int result = lotto.calculateDrawResult(winningLotto);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "7, false",
            "8, false",
    })
    @DisplayName("구매한 로또와 보너스 번호에 대해 추첨 결과를 계산한다.")
    void 보너스_번호_추첨_테스트(int number, boolean expectedResult) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.hasBonusNum(number);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
