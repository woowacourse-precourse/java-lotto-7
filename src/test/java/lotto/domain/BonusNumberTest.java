package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("범위 밖 보너스 숫자 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -5})
    void rangeTest(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자 포함 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "6,true", "10,false", "45,false"})
    void bonusNumberTest(int number, boolean expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(number);
        assertThat(bonusNumber.hasBonusNumber(lotto)).isEqualTo(expected);
    }

}
