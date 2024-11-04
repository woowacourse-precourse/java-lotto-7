package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeTest {

    @DisplayName("일치 번호 개수와 보너스 번호 일치 여부에 맞는 등수를 알려준다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0,false,FAIL", "0,true,FAIL",
            "1,false,FAIL", "1,true,FAIL",
            "2,false,FAIL", "2,true,FAIL",
            "3,false,FIFTH", "3,true,FIFTH",
            "4,false,FOURTH", "4,true,FOURTH",
            "5,false,THIRD", "5,true,SECOND",
            "6,false,FIRST", "6,true,FIRST"
    })
    void 일치_번호_개수와_보너스_번호_일치_여부에_맞는_등수를_알려준다(String matchCount, String bonusFlag, String prize) {
        int givenMatchCount = Integer.parseInt(matchCount);
        boolean givenBonusFlag = Boolean.parseBoolean(bonusFlag);

        assertEquals(
                Prize.getMatchPrize(givenMatchCount, givenBonusFlag),
                Prize.valueOf(prize)
        );
    }
}
