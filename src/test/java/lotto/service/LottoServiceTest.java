package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.generator.MockRandomLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private static final String VALID_PURCHASE_AMOUNT = "5000";
    private static final String VALID_WINNING_NUMBERS_INPUT = "1,2,3,4,5,6";
    private static final String VALID_BONUS_NUMBER_INPUT = "7";
    private static final int EXPECTED_LOTTO_COUNT = 5;
    private static final int EXPECTED_BONUS_NUMBER = 7;
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int PERCENTAGE_CONVERSION_FACTOR = 100;

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
        WinningLotto winningLotto = lottoService.createWinningLotto(VALID_WINNING_NUMBERS_INPUT, VALID_BONUS_NUMBER_INPUT);
        assertThat(winningLotto.getWinningNumbers().getNumbers()).isEqualTo(WINNING_NUMBERS);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(EXPECTED_BONUS_NUMBER);
    }

    @DisplayName("구매한 로또 티켓과 당첨 번호를 비교하여 LottoResult 생성 테스트")
    @Test
    void 로또_결과_객체_생성_테스트() {
        LottoTicket lottoTicket = lottoService.generateLottoTicket(VALID_PURCHASE_AMOUNT);
        WinningLotto winningLotto = lottoService.createWinningLotto(VALID_WINNING_NUMBERS_INPUT, VALID_BONUS_NUMBER_INPUT);
        LottoResult lottoResult = lottoService.createLottoResult(lottoTicket, winningLotto, VALID_PURCHASE_AMOUNT);

        assertThat(lottoResult).isNotNull();
    }

    @DisplayName("생성된 LottoResult 객체가 정상적으로 생성되었는지 테스트")
    @Test
    void 고정된_로또_번호로_로또_결과_객체_정상_생성_여부_테스트() {
        MockRandomLottoNumberGenerator mockGenerator = new MockRandomLottoNumberGenerator(WINNING_NUMBERS);
        LottoTicket lottoTicket = new LottoTicket(mockGenerator, 1);
        WinningLotto winningLotto = lottoService.createWinningLotto(VALID_WINNING_NUMBERS_INPUT, VALID_BONUS_NUMBER_INPUT);

        LottoResult lottoResult = lottoService.createLottoResult(lottoTicket, winningLotto, VALID_PURCHASE_AMOUNT);
        Map<Rank, Integer> winningResults = lottoResult.getWinningResults();

        assertThat(winningResults).containsEntry(Rank.FIRST, 1)
                .containsEntry(Rank.SECOND, 0)
                .containsEntry(Rank.THIRD, 0)
                .containsEntry(Rank.FOURTH, 0)
                .containsEntry(Rank.FIFTH, 0)
                .containsEntry(Rank.NONE, 0);

        double expectedReturnOnInvestment = (Rank.FIRST.getPrizeMoney() / (double) Integer.parseInt(VALID_PURCHASE_AMOUNT)) * PERCENTAGE_CONVERSION_FACTOR;
        assertThat(lottoResult.getReturnOnInvestment()).isEqualTo(expectedReturnOnInvestment);
    }
}
