package lotto.domain.validator;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusValidatorTest {

    @ParameterizedTest
    @CsvSource({"asdf", "-1", "0", "a1b2", "1*2"})
    @DisplayName("보너스 숫자로 양수가 아닌 입력이 들어오는 경우")
    void whenIsNotPositiveNumberThenThrowException(String invalidBonus) {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when then
        Assertions.assertThatThrownBy(() -> BonusValidator.validate(invalidBonus, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 양수만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("보너스 숫자로 integer 범위를 넘어선 입력이 들어오는 경우")
    void whenOverIntegerRangeThenThrowException() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String invalidBonus = "2147483649";

        //when then
        Assertions.assertThatThrownBy(() -> BonusValidator.validate(invalidBonus, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 2,147,483,647보다 클 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 숫자로 1-45를 벗어난 숫자가 들어오는 경우")
    void whenOutOfRangeBonusNumberThenThrowException() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String invalidBonus = "46";

        //when then
        Assertions.assertThatThrownBy(() -> BonusValidator.validate(invalidBonus, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1-45 사이의 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("이미 로또 번호로 등록된 경우")
    void whenIsContainLottoNumbersThenThrowException() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String invalidBonus = "6";

        //when then
        Assertions.assertThatThrownBy(() -> BonusValidator.validate(invalidBonus, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이미 로또 번호로 사용된 번호입니다.");
    }
}
