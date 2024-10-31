package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void 금액_파싱_테스트(){
        String money = "12300";

        assertThat(InputParser.parseMoney(money)).isEqualTo(12300);
    }

    @Test
    void 당첨번호_파싱_테스트(){
        String numbers = "1,2,3,4,5,6";

        assertThat(InputParser.parseNumbers(numbers)).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void 보너스번호_파싱_테스트(){
        String bonusNumber = "7";

        assertThat(InputParser.parseBonusNumber(bonusNumber)).isEqualTo(7);
    }

}