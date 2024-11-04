package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    void 당첨_번호에_보너스_번호와_동일한_값이_있다면_IllegalArgumentException_발생(){
        Winning winning = Winning.create(List.of(1,2,3,4,5,6));

        Assertions.assertThatThrownBy(
                () -> winning.existByBonusNumber(5)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}