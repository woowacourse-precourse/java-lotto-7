package lotto.view.input;

import lotto.buyer.service.InsertMoneyService;
import lotto.lotto.domain.*;
import lotto.lotto.service.LottoGenerator;
import lotto.lotto.domain.LottoMachine;
import lotto.money.domain.Money;
import lotto.buyer.infrastructure.UserInputInsertMoney;
import lotto.money.infrastructure.DivideThousandCalculator;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;
import lotto.view.input.service.InputService;
import lotto.view.input.hanlder.infrastructure.MoneyHandler;
import lotto.view.output.service.PurchaseCountViewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    private static Money money;
    private static LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        InsertMoneyService insertMoneyService = new UserInputInsertMoney(new MoneyHandler(new MoneyInputTest()));
        money = insertMoneyService.insert();
        lottoMachine = new LottoMachine(new DivideThousandCalculator(), new LottoGeneratorTest(), new PurchaseOutputViewTest());
    }

    @Test
    @DisplayName("입력 테스트 8000원")
    void lottoBuyerTest() {
        assertThat(money.getMoney()).isEqualTo(8000L);
    }

    @Test
    @DisplayName("로또 생성기 (정렬)")
    void lottoCrateTest() {
        String excepted = String.join("\n",
                "[40, 41, 42, 43, 44, 45]",
                "[34, 35, 36, 37, 38, 39]",
                "[28, 29, 30, 31, 32, 33]",
                "[22, 23, 24, 25, 26, 27]",
                "[16, 17, 18, 19, 20, 21]",
                "[10, 11, 12, 13, 14, 15]",
                "[4, 5, 6, 7, 8, 9]",
                "[2, 3, 42, 43, 44, 45]\n"
        );
        LottoTickets lottoTickets = lottoMachine.purchaseLottoTickets(money);
        assertThat(lottoTickets.toString()).isEqualTo(excepted);
    }

    @Test
    @DisplayName("당첨 번호를 입력해 주세요")
    void winningLottoTest() {
        WinningLotto winningLotto = lottoMachine.createWinningLotto();

        assertThat(winningLotto.toString()).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("보너스 번호를 입력해주세요")
    void BonusLottoTest() {
        WinningLotto winningLotto = lottoMachine.createWinningLotto();
        BonusNumber bonusNumber = lottoMachine.createBonusNumber(winningLotto);

        assertThat(bonusNumber.toString()).isEqualTo("7");
    }
}

class MoneyInputTest implements InputService {
    @Override
    public String input() {
        return "8000";
    }
}

class PurchaseOutputViewTest implements PurchaseCountViewService {
    @Override
    public void view(int count) {
    }
}

class LottoGeneratorTest implements LottoGenerator {
    @Override
    public LottoTickets lottoTickets(int count) {
        return LottoTickets.of(List.of(
                new Lotto(List.of(45, 44, 43, 42, 41, 40)),
                new Lotto(List.of(39, 38, 37, 36, 35, 34)),
                new Lotto(List.of(33, 32, 31, 30, 29, 28)),
                new Lotto(List.of(27, 26, 25, 24, 23, 22)),
                new Lotto(List.of(21, 20, 19, 18, 17, 16)),
                new Lotto(List.of(15, 14, 13, 12, 11, 10)),
                new Lotto(List.of(9, 8, 7, 6, 5, 4)),
                new Lotto(List.of(45, 44, 43, 42, 2, 3))
        ));
    }

    @Override
    public BonusNumber bonusNumber(WinningLotto winningLotto) {
        return BonusNumber.of("7");
    }

    @Override
    public WinningLotto winningLotto() {
        return WinningLotto.of("1,2,3,4,5,6");
    }
}
