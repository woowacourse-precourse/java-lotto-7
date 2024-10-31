package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCommitteeTest {
    @Test
    void 로또를_주면_당첨을_반환한다() {
        // given
        Answer answer = new Answer(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoCommittee committee = new LottoCommittee();
        committee.setAnswer(answer);

        // when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoPrize prize = committee.getLottoPrize(lotto);

        // then
        assertThat(prize).isEqualTo(LottoPrize.FIRST);
    }
}