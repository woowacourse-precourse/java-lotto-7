package domain.consumer;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import domain.error.InputErrorMessage;
import domain.lotto.Lotto;
import domain.lotto.LottoMachin;
import io.Input;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsumerTest {
    private final InputStream originalIn = System.in;
    private Consumer consumer;

    @BeforeEach
    void setUpInput() {
        consumer = new Consumer();
    }

    @AfterEach
    void restoreInput() {
        Consumer consumer = null;
        System.setIn(originalIn);
        Console.close();
    }

    @DisplayName("금액에 맞는 로또 수량 테스트")
    @Test
    void purchaseLottoByMoneyTest() {
        String input = "5000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int quantity = consumer.getQuantityPurchaseLottoBy(Input.getMoneyForPurchaseLotto());
        assertEquals(quantity, 5);
    }

    @DisplayName("구매한 로또 저장 후 갯수 테스트")
    @Test
    void receiveLottoTicketTest() {
        List<Lotto> generatedLottoTickets = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );

        consumer.receiveLottoTicket(generatedLottoTickets);

        assertThat(generatedLottoTickets.size()).isEqualTo(consumer.getPurchasedLottoCount());
    }

    @DisplayName("선택한 당첨 번호 동일 테스트")
    @Test
    void selectedWinnerNumberIsEqualsTest() {
        Lotto selectedWinnerNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        consumer.selectWinnerNumbers(selectedWinnerNumber);

        assertTrue(consumer.selectedWinnerNumberIsEqualsTo(selectedWinnerNumber));
    }

    @DisplayName("선택한 보너스 번호 동일 테스트")
    @Test
    void selectedBonusNumberIsEqualsTest() {
        Lotto selectedWinnerNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        consumer.selectWinnerNumbers(selectedWinnerNumber);
        consumer.selectBonusNumber(bonusNumber);

        assertTrue(consumer.selectedBonusNumberIsEqualsTo(bonusNumber));
    }

    @DisplayName("선택한 보너스 번호가 당첨 번호에 있을 경우 실패 테스트")
    @Test
    void selectBonusNumberWithinWinnerNumberFailTest() {
        Lotto selectedWinnerNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        consumer.selectWinnerNumbers(selectedWinnerNumber);

        assertThatThrownBy(() -> consumer.selectBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.BONUS_NUMBER_NOT_IN_WINNING_NUMBERS.getErrorMessage());

    }
}