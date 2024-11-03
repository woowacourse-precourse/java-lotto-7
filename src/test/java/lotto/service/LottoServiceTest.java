package lotto.service;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private static final String VALID_PURCHASE_AMOUNT = "5000";
    private static final int EXPECTED_LOTTO_COUNT = 5;
    private static final List<Integer> EXPECTED_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl();
    }

    @Test
    void 로또_티켓_생성_테스트() {
        LottoTicket lottoTicket = lottoService.generateLottoTicket(VALID_PURCHASE_AMOUNT);
        assertThat(lottoTicket.getLottos()).hasSize(EXPECTED_LOTTO_COUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6", " 1 , 2 , 3 , 4 , 5 , 6 "})
    void 당첨_번호_입력값_파싱_테스트(String winningNumbersInput) {
        List<Integer> parsedWinningNumbers = lottoService.parseWinningNumbers(winningNumbersInput);
        assertThat(parsedWinningNumbers).isEqualTo(EXPECTED_WINNING_NUMBERS);
    }
}
