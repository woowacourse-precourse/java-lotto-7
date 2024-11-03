package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAnswerTest {

    @Test
    @DisplayName("로또 결과와 티켓이 일치할 때")
    void getLottoRank() {
        //given
        List<Integer> lottoAnswers = List.of(1,2,3,4,5,6);
        Integer bonusNumber = 7;
        LottoAnswer lottoAnswer = new LottoAnswer(lottoAnswers, bonusNumber);

        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(lottoNumbers);

        Rank rank = Rank.SIX_MATCHES;
        //when
        Rank lottoRank = lottoAnswer.getLottoRank(lotto);

        //then
        assertThat(lottoRank).isEqualTo(rank);
    }


}