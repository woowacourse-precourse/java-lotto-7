package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.LottoBuyer;
import lotto.dto.Lotto;
import lotto.dto.Receipt;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoBuyerTest {
    private LottoBuyer lottoBuyer;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    @BeforeEach
    void beforeEach(){
        lottoBuyer = new LottoBuyer();
    }
    //로또_구입_금액_입력_테스트는 개별 실행 -> 전체 실행 시 에러남
    @Test
    void 로또_구입_금액_입력_테스트() {
        String simulatedInput = "1000\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        LottoBuyer lottoBuyer = new LottoBuyer();
        int purchaseAmount = lottoBuyer.purchaseLotto();

        assertEquals(1000, purchaseAmount);
    }
    @Test
    void 로또_당첨_번호_입력_테스트() {
        // given
        String input = "1,2,3,4,5,6\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        List<Integer> winningNumbers = lottoBuyer.drawWinningNumbers();

        // then
        assertEquals(7, winningNumbers.size());
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), winningNumbers);
    }

    @Test
    void 영수증_수신_테스트() {
        // given
        Receipt receipt = new Receipt(8000);

        // when
        lottoBuyer.receiveReceipt(receipt);

        // then
        assertEquals(receipt, lottoBuyer.getReceipt());
    }

    @Test
    void 로또_리스트_수신_테스트() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        // when
        lottoBuyer.receiveLottos(lottos);

        // then
        assertEquals(lottos, lottoBuyer.getPurchasedLottos());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
