package lotto.view.input;

import lotto.buyer.domain.InsertMoneyService;
import lotto.buyer.domain.Money;
import lotto.buyer.infrastructure.InsertMoney;
import lotto.lotto.domain.LottoMachine;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.NumberGenerator;
import lotto.lotto.infrastructure.RandomNumberGenerate;
import lotto.lotto.infrastructure.WonCalculator;
import lotto.view.input.domain.InputService;
import lotto.view.input.hanlder.infrastructure.MoneyHandler;
import lotto.view.output.domain.ViewService;
import lotto.view.output.infra.MoneyOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    private static Money money;

    @BeforeEach
    void init() {
        InsertMoneyService insertMoneyService = new InsertMoney(new MoneyHandler(new MoneyInputTest()));
        money = insertMoneyService.insert();

    }

    @Test
    @DisplayName("입력 테스트 8000원")
    void lottoBuyerTest() {
        assertThat(money.getMoney()).isEqualTo(8000L);
    }

    @Test
    @DisplayName("로또 생성기 (정렬)")
    void lottoCrate() {
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
        LottoMachine lottoMachine = new LottoMachine(new WonCalculator(), new NumberGenerateTest());
        LottoTickets lottoTickets = lottoMachine.purchaseLottoTickets(money);
        assertThat(lottoTickets.toString()).isEqualTo(excepted);
    }

}

class MoneyInputTest implements InputService {
    @Override
    public String input() {
        return "8000";
    }
}

class NumberGenerateTest implements NumberGenerator {
    private static int start = 0;
    List<List<Integer>> list = List.of(
            new ArrayList<>(List.of(45, 44, 43, 42, 41, 40)),
            new ArrayList<>(List.of(39, 38, 37, 36, 35, 34)),
            new ArrayList<>(List.of(33, 32, 31, 30, 29, 28)),
            new ArrayList<>(List.of(27, 26, 25, 24, 23, 22)),
            new ArrayList<>(List.of(21, 20, 19, 18, 17, 16)),
            new ArrayList<>(List.of(15, 14, 13, 12, 11, 10)),
            new ArrayList<>(List.of(9, 8, 7, 6, 5, 4)),
            new ArrayList<>(List.of(45, 44, 43, 42, 2, 3))
    );

    @Override
    public List<Integer> generate() {
        return list.get(start++);
    }
}
