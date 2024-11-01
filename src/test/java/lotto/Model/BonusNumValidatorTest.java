package lotto.Model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Constants;
import org.junit.jupiter.api.Test;

class BonusNumValidatorTest {
    @Test
    void 보너스번호_범위초과(){
        assertThatThrownBy(()-> new BonusNumValidator("56", List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.BONUS_NUM_RANGE_ERROR);
    }

    @Test
    void 보너스번호_문자열포함에러(){
        assertThatThrownBy(() -> new BonusNumValidator("1q",List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.BONUS_NUM_PARSE_ERROR);
    }

    @Test
    void 보너스번호_공백에러(){
        assertThatThrownBy(() -> new BonusNumValidator("",List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.BONUS_NUM_BLANK_ERROR);
    }

    @Test
    void 보너스번호_중복에러(){
        assertThatThrownBy(() -> new BonusNumValidator("1",List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.BONUS_NUM_DUPLICATE_ERROR);
    }
}