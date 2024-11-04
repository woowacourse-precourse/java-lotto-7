package lotto.lotto.domain;

import lotto.money.domain.Benefit;
import lotto.money.service.BenefitCalculator;
import lotto.money.domain.Money;
import lotto.money.infrastructure.WinningBenefitCalculator;
import lotto.money.infrastructure.PurchaseAmount;
import lotto.money.infrastructure.WinningAmountCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RateOfReturnTest {
    private static Money insertMoney;
    private BenefitCalculator benefitCalculator;
    private LottoTickets lottoTickets;
    private Lotto lotto;

    @BeforeEach
    void init() {
        insertMoney = PurchaseAmount.of("1000");
        benefitCalculator = new WinningBenefitCalculator(new WinningAmountCalculator());
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoTickets = LottoTickets.of(List.of(lotto));
    }

    @Test
    @DisplayName("수익률 테스트 1등")
    void firstPlaceRateOfReturn() {
        verifyRateOfReturn("1,2,3,4,5,6", "7", "200,000,000.0");
    }

    @Test
    @DisplayName("수익률 테스트 2등")
    void secondPlaceRateOfReturn() {
        verifyRateOfReturn("1,2,3,4,5,7", "6", "3,000,000.0");

    }

    @Test
    @DisplayName("수익률 테스트 3등")
    void thirdPlaceRateOfReturn() {
        verifyRateOfReturn("1,2,3,4,5,8", "9", "150,000.0");

    }

    @Test
    @DisplayName("수익률 테스트 4등")
    void fourthPlaceRateOfReturn() {
        verifyRateOfReturn("1,2,3,4,7,8", "9", "5,000.0");

    }

    @Test
    @DisplayName("수익률 테스트 5등")
    void fifthPlaceRateOfReturn() {
        verifyRateOfReturn("1,2,3,7,8,9", "10", "500.0");
    }

    @Test
    @DisplayName("수익률 테스트 꼴등")
    void lastPlaceRateOfReturn() {
        List<WinningLotto> losingLottos = List.of(
                WinningLotto.of("1,2,7,8,9,10"),
                WinningLotto.of("1,7,8,9,10,11"),
                WinningLotto.of("7,8,9,10,11,12")
        );
        losingLottos.forEach(winningLotto -> verifyRateOfReturn(winningLotto, "13", "0.0"));
    }

    private void verifyRateOfReturn(String winningNumber, String bonusNumber, String expectedRateOrReturn) {
        WinningLotto winningLotto = WinningLotto.of(winningNumber);
        BonusNumber bonus = BonusNumber.of(bonusNumber);
        Benefit benefit = benefitCalculator.execute(lottoTickets, winningLotto, bonus);
        String rateOfReturn = benefit.getDecimalFormatByRateOfReturn(insertMoney);
        assertThat(rateOfReturn).isEqualTo(expectedRateOrReturn);
    }

    private void verifyRateOfReturn(WinningLotto winningLotto, String bonusNumber, String expectedRateOrReturn) {
        BonusNumber bonus = BonusNumber.of(bonusNumber);
        Benefit benefit = benefitCalculator.execute(lottoTickets, winningLotto, bonus);
        String rateOfReturn = benefit.getDecimalFormatByRateOfReturn(insertMoney);
        assertThat(rateOfReturn).isEqualTo(expectedRateOrReturn);
    }
}
