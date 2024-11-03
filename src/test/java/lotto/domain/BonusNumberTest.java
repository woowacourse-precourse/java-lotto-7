package lotto.domain;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    WinningNumbers winningNumbers;

    @BeforeEach
    void setUp(){
        winningNumbers= new WinningNumbers(List.of(1,2,3,4,5,6));
    }

    @ParameterizedTest
    @ValueSource(ints={0,46})
    void 로또범위를_벗어나는_숫자를_입력하면_예외_발생(int input){
        assertThatThrownBy(() -> new BonusNumber(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining(ErrorMessage.INVALID_RANGE);
    }

}