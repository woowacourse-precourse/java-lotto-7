package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import com.sun.tools.javac.Main;
import lotto.model.BonusNumber;
import lotto.model.MainNumber;
import lotto.model.TicketManager;
import lotto.vo.Payment;
import lotto.vo.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoServiceTest extends NsTest {
    private LottoService lottoService;

    @BeforeEach
    void 인스턴스_생성() {
        lottoService = new LottoService();
    }

    @Test
    void 비용_예외_입력_후_정상_입력() {
        runException("abc", "1000");

        Payment payment = lottoService.takePayment();

        assertEquals(1000, payment.getMoney());
    }

    @Test
    void 메인_넘버_예외_입력_후_정상_입력() {
        runException("1,1,1,1,1,1", "1,2,3,4,5,6");

        MainNumber mainNumber = lottoService.takeMainNum();

        assertEquals(List.of(1, 2, 3, 4, 5, 6), mainNumber.getNumbers());
    }

    @Test
    void 보너스_넘버_예외_입력_후_정상_입력() {
        MainNumber mainNumber = new MainNumber("1,2,3,4,5,6");
        runException("999", "7");

        BonusNumber bonusNumber = lottoService.takeBonusNum(mainNumber);

        assertEquals(7, bonusNumber.getNumber());
    }

    @Test
    void 등수별_당첨_개수_수집() {
        MainNumber mainNumber = new MainNumber("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", mainNumber);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    TicketManager ticketManager = new TicketManager(new Payment("2000"));
                    List<Ticket> tickets = ticketManager.getTickets();
                    List<Integer> rankCount = lottoService.takeRankCount(tickets, mainNumber, bonusNumber);
                    assertEquals(Arrays.asList(1, 1, 0, 0, 0), rankCount);
                },
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,7)
        );
    }

    @Test
    void 수익률_계산() {
        List<Integer> rankCount = Arrays.asList(0, 0, 0, 0, 1);
        Payment payment = new Payment("8000");

        double profitRate = lottoService.drawProfitRate(rankCount, payment);
        assertEquals(62.5, profitRate);
    }

    @Override
    protected void runMain() {
    }
}
