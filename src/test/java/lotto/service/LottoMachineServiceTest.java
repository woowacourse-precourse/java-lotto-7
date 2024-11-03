package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Member;
import lotto.enums.lotto.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineServiceTest {

    private LottoMachine lottoMachine;
    private Member member;
    private LottoMachineService lottoMachineService;

    @BeforeEach
    public void setup() {
        lottoMachine = LottoMachine.getInstance();
        member = Member.getInstance();
        lottoMachineService = new LottoMachineService();
    }

    // SUCCESS
    @Test
    void 로또_구입금액_입력받는다() {
        // given
        String purchaseAmount = "1000";

        // when
        lottoMachineService.inputLottoPurchaseAmount(purchaseAmount);

        // then
        assertEquals(1000, lottoMachine.getPurchaseAmount());
    }

    @Test
    void 보너스번호를_입력받는다() {
        // given
        String bonusNumber = "12";

        // when
        lottoMachineService.inputBonusNumber(bonusNumber);

        // then
        assertEquals(12, lottoMachine.getBonusNumber());
    }

    @Test
    void 로또_당첨번호를_입력받는다() {
        // given
        String numbers = "1,2,3,4,5,6";

        // when
        lottoMachineService.inputWinningNumbers(numbers);

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lottoMachine.getWinningLotto().getNumbers());
    }

    @Test
    void 로또를_발행한다() {
        // given
        String purchaseAmount = "8000";

        // when
        lottoMachineService.inputLottoPurchaseAmount(purchaseAmount);
        lottoMachineService.issueLottos();

        // then
        assertEquals(8, member.getIssuedLottos().size());
    }

    @Test
    void 당첨번호와_발행된_로또번호와_일치하는지_확인한다() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        Lotto issuedNumbers = new Lotto(List.of(1, 3, 5, 12, 13, 15));

        // when
        lottoMachineService.inputWinningNumbers(winningNumbers);

        // then
        assertEquals(3, lottoMachineService.correctLottoNumber(issuedNumbers));
    }

    @Test
    void 보너스번호가_일치하는지_확인한다() {
        // given
        String bonusNumber = "10";
        Lotto issuedNumbers = new Lotto(List.of(1, 3, 5, 12, 10, 15));

        // when
        lottoMachineService.inputBonusNumber(bonusNumber);

        // then
        assertTrue(lottoMachineService.correctBonusNumber(issuedNumbers));
    }

    @Test
    void 사용자에게_로또결과를_주는것을_확인한다() {
        // given
        String bonusNumber = "12";
        String numbers = "1,2,3,4,5,6";
        Lotto issuedNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 12));

        // when
        lottoMachineService.inputWinningNumbers(numbers);
        lottoMachineService.inputBonusNumber(bonusNumber);
        member.saveIssuedLotto(issuedNumbers);
        lottoMachineService.giveCorrectCountAndMoney();

        // then
        assertEquals(1, member.getLottoResults().get(LottoRank.SECOND));
    }

    // EXCEPTION
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3", "1,2,3,4"})
    void 로또번호_크기가_6이_아닌경우_예외를_던진다(String numbers) {
        assertThrows(IllegalArgumentException.class,
                () -> lottoMachineService.inputWinningNumbers(numbers));
    }
}