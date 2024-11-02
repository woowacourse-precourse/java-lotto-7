package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    void 당첨번호와_중복되는_보너스번호가_존재할시_예외가_발생한다() {
        //given
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 1;
        //when
        //then
        assertThatThrownBy(() -> WinningNumbers.from(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"46, 2, 3, 4, 5, 6", "0, 1, 2, 3, 4, 5"})
    void 범위밖에_있는_당첨번호가_존재할시__예외가_발생한다(String lottoNumbers) {
        //given
        List<Integer> lotto = Arrays.stream(lottoNumbers.split(", "))
                .map(Integer::parseInt)
                .toList();
        Integer bonusNumber = 1;
        //when
        //then
        assertThatThrownBy(() -> WinningNumbers.from(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 숫자 범위는 최소 1부터 최대 45까지 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 범위밖에_있는_보너스번호가_존재할시__예외가_발생한다(int bonusNumber) {
        //given
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        //when
        //then
        assertThatThrownBy(() -> WinningNumbers.from(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 숫자 범위는 최소 1부터 최대 45까지 가능합니다.");
    }
}