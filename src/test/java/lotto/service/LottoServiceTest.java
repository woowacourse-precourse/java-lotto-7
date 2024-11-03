package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private static final String VALID_PURCHASE_AMOUNT = "5000";
    private static final String VALID_WINNING_NUMBERS_INPUT = "1,2,3,4,5,6";
    private static final String VALID_BONUS_NUMBER = "7";
    private static final int EXPECTED_LOTTO_COUNT = 5;
    private static final int EXPECTED_BONUS_NUMBER = 7;
    private static final List<Integer> EXPECTED_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl();
    }

    @DisplayName("로또 구입 금액만큼 로또를 생성하여 관리하는 LottoTicket 객체 생성 테스트")
    @Test
    void 로또_티켓_생성_테스트() {
        LottoTicket lottoTicket = lottoService.generateLottoTicket(VALID_PURCHASE_AMOUNT);
        assertThat(lottoTicket.getLottos()).hasSize(EXPECTED_LOTTO_COUNT);
    }

    @DisplayName("파싱한 당첨 번호와 보너스 번호로 WinningLotto 객체 생성 테스트")
    @Test
    void 당첨_보너스_번호_관리_객체_생성_테스트() {
        WinningLotto winningLotto = lottoService.createWinningLotto(VALID_WINNING_NUMBERS_INPUT, VALID_BONUS_NUMBER);
        assertThat(winningLotto.getWinningNumbers().getNumbers()).isEqualTo(EXPECTED_WINNING_NUMBERS);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(EXPECTED_BONUS_NUMBER);
    }
}
