package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {

    @Test
    void 당첨_5개_일치_보너스_일치_테스트(){
        LottoPrize prize1 = LottoPrize.checkValue(5, true);
        assertThat(prize1).isEqualTo(LottoPrize.MATCH_5_WITH_BONUS);
    }

    @Test
    void 당첨_5개_일치_테스트(){
        LottoPrize prize1 = LottoPrize.checkValue(5, false);
        assertThat(prize1).isEqualTo(LottoPrize.MATCH_5);
    }

    @Test
    void 당첨_갯수_증가_확인_테스트(){
        LottoPrize prize = LottoPrize.MATCH_3;
        int matchCount = prize.getEachMatchCount();
        prize.increaseEachMatchCount();
        assertThat(prize.getEachMatchCount()).isEqualTo(matchCount + 1);
    }


}