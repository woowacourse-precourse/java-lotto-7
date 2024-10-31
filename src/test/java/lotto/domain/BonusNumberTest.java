package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    public void 보너스_번호와_같은_값_테스트() {
        int number = 10;

        BonusNumber bonusNumber = BonusNumber.of(number);

        assertThat(bonusNumber.isMatch(number)).isTrue();
    }

    @Test
    public void 보너스_번호와_다른_값_테스트() {
        int number = 10;
        BonusNumber bonusNumber = BonusNumber.of(9);

        assertThat(bonusNumber.isMatch(number)).isFalse();
    }

}
