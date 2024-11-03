package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void _3개가_일치하는_경우() {
        //given
        int answerAgreement = 3;
        int bonusAgreement = 1;

        //when
        Rank rank = Rank.findRank(answerAgreement, bonusAgreement);

        //then
        assertThat(rank).isEqualTo(Rank.THREE_MATCHES);
    }

    @Test
    void _3개밑으로_일치하는_경우() {
        //given
        int answerAgreement = 0;
        int bonusAgreement = 1;

        //when
        Rank rank = Rank.findRank(answerAgreement, bonusAgreement);

        //then
        assertThat(rank).isEqualTo(Rank.SMALL_MATCHES);
    }
}