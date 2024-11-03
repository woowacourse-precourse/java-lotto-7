package lotto.service;

import static lotto.exception.ErrorMessage.MINIMUM_TICKET_PURCHASE_ERROR;
import static lotto.exception.ErrorMessage.PURCHASE_PRICE_DIVIDE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoResult;
import lotto.domain.WinningPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoServiceTest {

    private LottoResult lottoResult = LottoResult.create();
    private LottoService lottoService = new LottoService(lottoResult);

    @DisplayName("3_000의 purchaseAmount가 주어졌을 때, 3개의 티켓이 생성되어야 한다")
    @Test
    void calculate_ticket_quantity_test() {
        // given
        int purchaseAmount = 3_000;

        // when
        int ticketQuantity = lottoService.calculateTicketQuantity(purchaseAmount);

        // then
        assertThat(ticketQuantity).isEqualTo(3);
    }

    @DisplayName("1000원 단위의 purchaseAmount가 주어졌을 경우, 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {1100, 2300, 9999})
    void ticket_exception_not_divide_1000_test(int purchaseAmount) {
        // given, when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoService.calculateTicketQuantity(purchaseAmount);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(PURCHASE_PRICE_DIVIDE_ERROR.getMessage());
    }

    @DisplayName("티켓 가격보다 적은 금액이 주어졌을 경우, 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100, 999})
    void ticket_exception_lower_ticket_price_test(int purchaseAmount) {
        // given, when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoService.calculateTicketQuantity(purchaseAmount);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(MINIMUM_TICKET_PURCHASE_ERROR.getMessage());
    }

    @DisplayName("티켓 1개가 주어졌을 경우, 랜덤한 6자리의 로또 번호 리스트가 1개 생성된다")
    @Test
    void generate_lotto_number_1_ticket_test() {
        // given
        int ticketQuantity = 1;

        // when
        List<List<Integer>> lottos = lottoService.generateLottoNumber(ticketQuantity);

        // then
        assertThat(lottos.size()).isEqualTo(1);
        for (List<Integer> lotto : lottos) {
            assertThat(lotto.size()).isEqualTo(6);
        }
    }

    @DisplayName("티켓 6개가 주어졌을 경우, 랜덤한 6자리의 로또 번호 리스트가 6개 생성된다")
    @Test
    void generate_lotto_number_6_ticket_test() {
        // given
        int ticketQuantity = 6;

        // when
        List<List<Integer>> lottos = lottoService.generateLottoNumber(ticketQuantity);

        // then
        assertThat(lottos.size()).isEqualTo(6);
        for (List<Integer> lotto : lottos) {
            assertThat(lotto.size()).isEqualTo(6);
        }
    }

    @Test
    @DisplayName("3개 일치하여 FIFTH_PLACE에 당첨되는 경우")
    void testFifthPlaceWin() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 25;
        List<List<Integer>> lottos = List.of(
                List.of(4, 5, 6, 7, 8, 9), // 3개 일치
                List.of(11, 12, 13, 14, 15, 16)
        );

        // when
        Map<WinningPrice, Integer> lottoResult = calculateLottoResult(winningNumbers, lottos,
                bonusNumber);

        // then
        assertThat(lottoResult.get(WinningPrice.FIFTH_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("4개 일치하여 FOURTH_PLACE에 당첨되는 경우")
    void testFourthPlaceWin() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 25;
        List<List<Integer>> lottos = List.of(
                List.of(3, 4, 5, 6, 9, 10), // 4개 일치
                List.of(11, 12, 13, 14, 15, 16)
        );

        // when
        Map<WinningPrice, Integer> lottoResult = calculateLottoResult(winningNumbers, lottos,
                bonusNumber);

        // then
        assertThat(lottoResult.get(WinningPrice.FOURTH_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 일치하여 THIRD_PLACE에 당첨되는 경우")
    void testThirdPlaceWin() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 25;
        List<List<Integer>> lottos = List.of(
                List.of(2, 3, 4, 5, 6, 10), // 5개 일치
                List.of(11, 12, 13, 14, 15, 16)
        );

        // when
        Map<WinningPrice, Integer> lottoResult = calculateLottoResult(winningNumbers, lottos,
                bonusNumber);

        // then
        assertThat(lottoResult.get(WinningPrice.THIRD_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개와 보너스 번호까지 일치하여 SECOND_PLACE에 당첨되는 경우")
    void testSecondPlaceWin() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 25;
        List<List<Integer>> lottos = List.of(
                List.of(2, 3, 4, 5, 6, 25), // 5개 + 보너스 번호 일치
                List.of(11, 12, 13, 14, 15, 16)
        );

        // when
        Map<WinningPrice, Integer> lottoResult = calculateLottoResult(winningNumbers, lottos,
                bonusNumber);

        // then
        assertThat(lottoResult.get(WinningPrice.SECOND_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("6개 모두 일치하여 FIRST_PLACE에 당첨되는 경우")
    void testFirstPlaceWin() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 25;
        List<List<Integer>> lottos = List.of(
                List.of(1, 2, 3, 4, 5, 6), // 6개 일치
                List.of(11, 12, 13, 14, 15, 16)
        );

        // when
        Map<WinningPrice, Integer> lottoResult = calculateLottoResult(winningNumbers, lottos,
                bonusNumber);

        // then
        assertThat(lottoResult.get(WinningPrice.FIRST_PLACE)).isEqualTo(1);
    }

    private Map<WinningPrice, Integer> calculateLottoResult(List<Integer> winningNumbers,
            List<List<Integer>> lottos, int bonusNumber) {
        lottoService.calculateWinningStatistics(winningNumbers, lottos, bonusNumber);
        return lottoService.getLottoResult();
    }
}