package lotto.util;

import lotto.domain.Cost;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static lotto.exception.ErrorMessages.DIVISIBLE_BY_THOUSAND_COST_ERROR;
import static lotto.util.WinningNumbersParser.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersParserTest {
    @Test
    @DisplayName("당첨 번호는 쉼표로 구분한다")
    void 당첨_번호는_쉼표로_구분한다(){
        List<Integer> lottoNumbers = parse("1,2,3,4,5,6");

        assertThat(lottoNumbers).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

}