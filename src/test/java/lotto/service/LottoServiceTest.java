package lotto.service;

import lotto.TestConstants;
import lotto.domain.*;
import lotto.generator.MockRandomLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private static final String VALID_PURCHASE_AMOUNT = "5000";
    private static final String VALID_WINNING_NUMBERS_INPUT = "1,2,3,4,5,6";
    private static final String VALID_BONUS_NUMBER_INPUT = "7";
    private static final int EXPECTED_LOTTO_COUNT = 5;
    private static final int EXPECTED_RETURN_ON_INVESTMENT = 40_000_000;

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

    @DisplayName("올바른 당첨 번호 입력 시 Lotto 객체 반환 테스트")
    @Test
    void 당첨_번호_파싱_검증_테스트() {
        Lotto winningNumbers = lottoService.parseAndValidateWinningNumbers(VALID_WINNING_NUMBERS_INPUT);

        assertThat(winningNumbers.getNumbers()).isEqualTo(TestConstants.EXPECTED_WINNING_NUMBERS);
    }

    @DisplayName("올바른 보너스 번호 입력 시 정수 반환 테스트")
    @Test
    void 보너스_번호_파싱_검증_테스트() {
        Lotto winningNumbers = lottoService.parseAndValidateWinningNumbers(VALID_WINNING_NUMBERS_INPUT);
        int bonusNumber = lottoService.parseAndValidateBonusNumber(VALID_BONUS_NUMBER_INPUT, winningNumbers);

        assertThat(bonusNumber).isEqualTo(TestConstants.EXPECTED_BONUS_NUMBER);
    }

    @DisplayName("파싱한 당첨 번호와 보너스 번호로 WinningLotto 객체 생성 테스트")
    @Test
    void 당첨_보너스_번호_관리_객체_생성_테스트() {
        WinningLotto winningLotto = lottoService.createWinningLotto(new Lotto(TestConstants.VALID_WINNING_NUMBERS), TestConstants.VALID_BONUS_NUMBER);

        assertThat(winningLotto.getWinningNumbers().getNumbers()).isEqualTo(TestConstants.EXPECTED_WINNING_NUMBERS);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(TestConstants.EXPECTED_BONUS_NUMBER);
    }

    @DisplayName("구매한 로또 티켓과 당첨 번호를 비교하여 LottoResult 생성 테스트")
    @Test
    void 로또_결과_객체_생성_테스트() {
        LottoTicket lottoTicket = lottoService.generateLottoTicket(VALID_PURCHASE_AMOUNT);
        WinningLotto winningLotto = lottoService.createWinningLotto(new Lotto(TestConstants.VALID_WINNING_NUMBERS), TestConstants.VALID_BONUS_NUMBER);
        LottoResult lottoResult = lottoService.createLottoResult(lottoTicket, winningLotto, VALID_PURCHASE_AMOUNT);

        assertThat(lottoResult).isNotNull();
    }

    @DisplayName("생성된 LottoResult 객체가 정상적으로 생성되었는지 테스트")
    @Test
    void 고정된_로또_번호로_로또_결과_객체_정상_생성_여부_테스트() {
        MockRandomLottoNumberGenerator mockGenerator = new MockRandomLottoNumberGenerator(TestConstants.VALID_WINNING_NUMBERS);
        LottoTicket lottoTicket = new LottoTicket(mockGenerator, 1);
        WinningLotto winningLotto = lottoService.createWinningLotto(new Lotto(TestConstants.VALID_WINNING_NUMBERS), TestConstants.VALID_BONUS_NUMBER);

        LottoResult lottoResult = lottoService.createLottoResult(lottoTicket, winningLotto, VALID_PURCHASE_AMOUNT);
        Map<Rank, Integer> winningResults = lottoResult.getWinningResults();

        assertThat(winningResults).containsEntry(Rank.FIRST, TestConstants.EXPECTED_FIRST_COUNT)
                .containsEntry(Rank.SECOND, TestConstants.EXPECTED_SECOND_COUNT)
                .containsEntry(Rank.THIRD, TestConstants.EXPECTED_THIRD_COUNT)
                .containsEntry(Rank.FOURTH, TestConstants.EXPECTED_FOURTH_COUNT)
                .containsEntry(Rank.FIFTH, TestConstants.EXPECTED_FIFTH_COUNT)
                .containsEntry(Rank.NONE, TestConstants.EXPECTED_NONE_COUNT);
        assertThat(lottoResult.getReturnOnInvestment()).isEqualTo(EXPECTED_RETURN_ON_INVESTMENT);
    }
}
