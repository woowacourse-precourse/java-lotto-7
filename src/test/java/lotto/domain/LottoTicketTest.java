package lotto.domain;

import lotto.dto.MatchResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTicketTest {
    LottoNumberGenerator lottoNumberGenerator;
    LottoTicket lottoTicket;

    @BeforeEach
    void init() {
        lottoNumberGenerator = new LottoNumberGenerator();
        PurchaseAmount purchaseAmount = PurchaseAmount.from("5000");
        lottoTicket = LottoTicket.of(lottoNumberGenerator, purchaseAmount);
    }

    @DisplayName("5000원어치 로또 구매 시, 당첨 결과가 5개인지 확인한다.")
    @Test
    void matchResultCountTest() {
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,7");
        BonusNumber bonusNumber = BonusNumber.from("8", winningNumber);

        List<MatchResult> matchResults = lottoTicket.gatherMatchResult(winningNumber, bonusNumber);

        Assertions.assertThat(matchResults.size()).isEqualTo(5);
    }
}
