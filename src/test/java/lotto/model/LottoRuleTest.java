package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoRuleTest {

    @Test
    void 일치하는_번호가_6개일_때는_SIX_MATCH_반환() {
        LottoRule rule = LottoRule.getWinInfo(6, false);
        assertThat(rule).isEqualTo(LottoRule.SIX_MATCH);
    }

    @Test
    void 일치하는_번호가_5개이고_보너스가_일치할_때는_FIVE_MATCH_BONUS_반환() {
        LottoRule rule = LottoRule.getWinInfo(5, true);
        assertThat(rule).isEqualTo(LottoRule.FIVE_MATCH_BONUS);
    }

    @Test
    void 일치하는_번호가_5개이고_보너스가_일치하지_않을_때는_FIVE_MATCH_반환() {
        LottoRule rule = LottoRule.getWinInfo(5, false);
        assertThat(rule).isEqualTo(LottoRule.FIVE_MATCH);
    }

    @Test
    void 일치하는_번호가_4개일_때는_FOUR_MATCH_반환() {
        LottoRule rule = LottoRule.getWinInfo(4, false);
        assertThat(rule).isEqualTo(LottoRule.FOUR_MATCH);
    }

    @Test
    void 일치하는_번호가_3개일_때는_THREE_MATCH_반환() {
        LottoRule rule = LottoRule.getWinInfo(3, false);
        assertThat(rule).isEqualTo(LottoRule.THREE_MATCH);
    }

    @Test
    void 일치하는_번호가_2개_이하일_때는_null_반환() {
        LottoRule ruleWithTwoMatches = LottoRule.getWinInfo(2, false);
        LottoRule ruleWithOneMatch = LottoRule.getWinInfo(1, false);
        LottoRule ruleWithNoMatch = LottoRule.getWinInfo(0, false);

        assertThat(ruleWithTwoMatches).isNull();
        assertThat(ruleWithOneMatch).isNull();
        assertThat(ruleWithNoMatch).isNull();
    }
}