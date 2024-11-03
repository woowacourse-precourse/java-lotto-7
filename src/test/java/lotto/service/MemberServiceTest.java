package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    private LottoMachine lottoMachine;
    private Member member;
    private LottoMachineService lottoMachineService;
    private MemberService memberService;

    @BeforeEach
    public void setup() {
        lottoMachine = LottoMachine.getInstance();
        member = Member.getInstance();
        lottoMachineService = new LottoMachineService();
        memberService = new MemberService();
    }

    @Test
    void 수익률_계산() {
        // given
        String amount = "8000";
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        // when
        lottoMachineService.inputLottoPurchaseAmount(amount);
        lottoMachineService.inputWinningNumbers(winningNumbers);
        lottoMachineService.inputBonusNumber(bonusNumber);
        member.saveIssuedLotto(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        lottoMachineService.giveCorrectCountAndMoney();
        memberService.calculateReturnOfRate();

        // then
        assertEquals(62.5, member.getReturnOfRate());
    }
}