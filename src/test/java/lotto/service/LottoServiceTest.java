package lotto.service;

import lotto.enums.LottoRank;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("구매 금액 입력 후 로또 티켓 생성 테스트")
    void createLottoTicketTest() {
        String purchaseMoney = "5000";

        LottoTicket lottoTicket = lottoService.createLottoTicket(purchaseMoney);

        assertThat(lottoTicket.getLottosCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("당첨 번호 생성 및 보너스 번호 추가 테스트")
    void createWinningLottoAndAddBonusTest() {
        String winningNumber = "1,2,3,4,5,6";
        String bonusNumber = "7";

        WinningLotto winningLotto = lottoService.createWinningLotto(winningNumber);
        lottoService.addBonusNumber(winningLotto, bonusNumber);

        assertThat(winningLotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNum()).isEqualTo(7);
    }

    @Test
    @DisplayName("로또 결과 생성 테스트")
    void compareLottoTest() {
        String purchaseMoney = "100000";
        LottoTicket lottoTicket = lottoService.createLottoTicket(purchaseMoney);
        WinningLotto winningLotto = lottoService.createWinningLotto("1,2,3,4,5,6");
        lottoService.addBonusNumber(winningLotto, "7");

        LottoResult lottoResult = lottoService.compareLotto(lottoTicket, winningLotto);

        Map<LottoRank, Integer> rankResults = lottoResult.getRankResults();
        assertThat(rankResults).isNotNull();
    }
}
