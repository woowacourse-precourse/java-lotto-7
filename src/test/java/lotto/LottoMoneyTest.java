package lotto;

import lotto.model.match.MatchInformation;
import lotto.model.money.LottoMoney;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMoneyTest {
    @Test
    void MatchSign_과_맞는_LottoMoney_를_조회한다() {
        System.out.println(LottoMoney.FOUR);
        LottoMoney lottoMoney = LottoMoney.from(MatchInformation.SIX_MATCH);
        assertThat(lottoMoney).isEqualTo(LottoMoney.SIX);
    }
}