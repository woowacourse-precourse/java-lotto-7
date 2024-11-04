package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

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
    @CsvSource(value = {"1,true", "7,false"})
    void 로또_번호에_보너스_번호_포함_여부를_확인하는_테스트(int element, boolean expected) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.isBonusNumberMatching(element)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:3", "1,2,3,4:4", "1,2,3,4,5:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    void 로또_번호가_몇개나_일치하는지_확인하는_테스트(String element, int expected) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> list = Arrays.stream(element.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        assertThat(lotto.getMatchingNumberCount(list)).isEqualTo(expected);
    }
}
