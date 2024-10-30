package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {

    private BonusNumber bonusNumber;

    @BeforeEach
    public void setUp() {
        bonusNumber = new BonusNumber();
    }

    @Test
    @DisplayName("로또의 보너스 번호를 입력할 수 있다.")
    void 보너스_번호_입력_테스트() throws Exception {
        // given
        int number = 7;

        // when
        bonusNumber.updateNumber(number);

        // then
        assertThat(bonusNumber.getNumber()).isEqualTo(number);
    }
}
