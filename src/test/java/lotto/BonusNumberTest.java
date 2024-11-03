package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void throwWhenBonusNumberIsDuplicate() {

    }

    @DisplayName("보너스 번호의 범위가 1~45가 아닐 경우 예외가 발생한다.")
    @Test
    void throwWhenBonusNumberIsNotRange(){

    }

    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void throwWhenBonusNumberIsNotNumber(){

    }
}
