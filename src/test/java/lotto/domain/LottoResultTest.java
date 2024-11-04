package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {
    @ParameterizedTest
    @CsvSource(value = {"0,false,NONE", "0,true,NONE", "1,false,NONE", "1,true,NONE",
            "2,false,NONE", "2,true,NONE", "3,false,FIFTH", "3,true,FIFTH",
            "4,false,FOURTH", "4,true,FOURTH", "5,false,THIRD", "5,true,SECOND",
            "6,false,FIRST", "6,true,FIRST"})
    @DisplayName("findLottoResult - 맞춘 개수와 보너스 숫자 판별 여부로 결과가 정확히 정해진다.")
    void findLottoResult(int matchedCount, boolean isBonusMatched, LottoResult expected) {
        LottoResult lottoResult = LottoResult.findLottoResult(matchedCount, isBonusMatched);
        assertThat(lottoResult).isEqualTo(expected);
    }
}


