package lotto.lotto.domain;

import lotto.money.domain.Benefit;
import lotto.money.service.BenefitCalculator;
import lotto.money.infrastructure.WinningBenefitCalculator;
import lotto.money.infrastructure.WinningAmountCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningCalculatorTest {
    private BenefitCalculator benefitCalculator;
    private LottoTickets lottoTickets;
    private Lotto lotto;

    @BeforeEach
    void init() {
        benefitCalculator = new WinningBenefitCalculator(new WinningAmountCalculator());
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoTickets = LottoTickets.of(List.of(lotto));
    }

    @Test
    @DisplayName("1등")
    void firstPlace() {
        verifyBenefit("1,2,3,4,5,6", "7", "2000000000");
    }

    @Test
    @DisplayName("2등")
    void secondPlace() {
        verifyBenefit("1,2,3,4,5,7", "6", "30000000");
    }

    @Test
    @DisplayName("3등")
    void thirdPlace() {
        verifyBenefit("1,2,3,4,5,8", "9", "1500000");
    }

    @Test
    @DisplayName("4등")
    void fourthPlace() {
        verifyBenefit("1,2,3,4,7,8", "9", "50000");
    }

    @Test
    @DisplayName("5등")
    void fifthPlace() {
        verifyBenefit("1,2,3,7,8,9", "10", "5000");
    }

    @Test
    @DisplayName("꼴등")
    void lastPlace() {
        List<WinningLotto> losingLottos = List.of(
                WinningLotto.of("1,2,7,8,9,10"),
                WinningLotto.of("1,7,8,9,10,11"),
                WinningLotto.of("7,8,9,10,11,12")
        );
        losingLottos.forEach(winningLotto -> verifyBenefit(winningLotto, "13", "0"));
    }

    private void verifyBenefit(String winningNumbers, String bonusNumber, String expectedBenefit) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers);
        BonusNumber bonus = BonusNumber.of(bonusNumber);
        Benefit benefit = benefitCalculator.execute(lottoTickets, winningLotto, bonus);
        assertThat(benefit.toString()).isEqualTo(expectedBenefit);
    }

    private void verifyBenefit(WinningLotto winningLotto, String bonusNumber, String expectedBenefit) {
        BonusNumber bonus = BonusNumber.of(bonusNumber);
        Benefit benefit = benefitCalculator.execute(lottoTickets, winningLotto, bonus);
        assertThat(benefit.toString()).isEqualTo(expectedBenefit);
    }
}
