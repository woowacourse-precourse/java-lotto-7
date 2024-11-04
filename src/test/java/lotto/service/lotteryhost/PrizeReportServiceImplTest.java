package lotto.service.lotteryhost;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PrizeCheckMachine;
import lotto.repository.LottoTicketRepository;
import lotto.repository.WinningReceiptRepository;
import lotto.service.constant.prize.PrizeConditionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrizeReportServiceImplTest {

    private PrizeCheckService prizeCheckService;
    private PrizeReportService prizeReportService;
    private List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
    private List<Integer> wrongNumbers = List.of(7,8,9,10,11,12);

    private Lotto testLotto(List<Integer> test) {
        return new Lotto(test);
    }

    @BeforeEach
    public void setup() {
        LottoTicketRepository.getTicket().clear();
        WinningReceiptRepository.getInstance().clear();

        prizeCheckService = new PrizeCheckServiceImpl(new PrizeCheckMachine(winningNumbers, 7));
        prizeReportService = new PrizeReportServiceImpl(prizeCheckService);
    }

    @Test
    @DisplayName("낙첨 게임 결과 미 업데이트 테스트")
    void NonUpdateTest(){
        LottoTicketRepository.getTicket().fillReceipt(testLotto(wrongNumbers));
        prizeReportService.updateReport();

        Boolean expected = false;
        Boolean actual = WinningReceiptRepository.getInstance().prizeConditionExist();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("당첨 게임 결과 업데이트 테스트1")
    void updateTest1(){
        LottoTicketRepository.getTicket().fillReceipt(testLotto(winningNumbers));
        prizeReportService.updateReport();

        Boolean expected = true;
        Boolean actual = WinningReceiptRepository.getInstance().prizeConditionExist();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("당첨 게임 결과 업데이트 테스트2 당첨 번호 여러 개")
    void updateTest2(){
        LottoTicketRepository.getTicket().fillReceipt(testLotto(winningNumbers));
        LottoTicketRepository.getTicket().fillReceipt(testLotto(winningNumbers));

        prizeReportService.updateReport();

        Long expected = 2L;
        Long actual = WinningReceiptRepository.getInstance().getCount(PrizeConditionImpl.FIRST_PRIZE);

        assertEquals(expected, actual);
    }
}