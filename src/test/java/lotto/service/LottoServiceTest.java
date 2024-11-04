package lotto.service;

import lotto.constant.LottoConstants;
import lotto.model.LottoResult;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService lottoService;
    private static final int VALID_PURCHASE_AMOUNT = LottoConstants.TICKET_PRICE * 5;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(VALID_PURCHASE_AMOUNT);
    }

    @Test
    void 로또_티켓이_구매_금액에_맞게_생성된다() {
        List<List<Integer>> tickets = lottoService.generateLottoTickets();
        int expectedTicketCount = VALID_PURCHASE_AMOUNT / LottoConstants.TICKET_PRICE;

        assertThat(tickets).hasSize(expectedTicketCount);
    }

    @DisplayName("당첨 번호가 5개 일치하는 경우 보너스 번호에 따라 당첨 내역을 출력한다.")
    @Test
    void 다섯_개_일치_당첨_통계() {
        List<List<Integer>> totalRandomNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 9), //5개 일치
                Arrays.asList(1, 2, 3, 4, 5, 7) //5개 일치, 보너스 볼 일치
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoService.setBonusNumber(7); // 보너스 번호 설정

        lottoService.updateLottoResults(totalRandomNumbers, winningNumbers);

        assertThat(LottoResult.FIVE_MATCH.getWinCount()).isEqualTo(1);
        assertThat(LottoResult.FIVE_MATCH_BONUS.getWinCount()).isEqualTo(1);
    }
}