package domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import domain.consumer.Consumer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachinTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private Consumer consumer;

    @BeforeEach
    void setUpInput() {
        consumer = new Consumer();
        // 입력을 위한 스트림 설정
        String input = "5000\n";  // 사용자가 "5000"을 입력하는 것처럼 설정
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUpOutput() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreInput() {
        consumer = null;
        // 테스트 후 원래 입력 스트림 복원
        System.setIn(originalIn);
    }

    @AfterEach
    void restoreOutput() {
        System.setOut(originalOut);
    }

    @DisplayName("로또 머신이 판매한 로또의 갯수와 실제 구매자가 받은 로또의 개수 비교 테스트")
    @Test
    void sellToTest() {
        LottoMachin lottoMachin = new LottoMachin();
        lottoMachin.sellTo(consumer);
        assertEquals(5, consumer.getPurchasedLottos().size());
    }

    @DisplayName("로또 머신이 제공한 구매자의 로또 번호 검증 테스트.")
    @Test
    void printLottosTest(){
        consumer.receiveLottoTicket(
                List.of(
                        new Lotto(Arrays.asList(1,2,3,4,5,6)),
                        new Lotto(Arrays.asList(7,8,9,10,11,12))
                )
        );
        String expectedOutput2 = "[1, 2, 3, 4, 5, 6]\r\n[7, 8, 9, 10, 11, 12]\r\n";

        consumer.getPurchasedLottos().forEach(System.out::println);
        assertEquals(expectedOutput2, output.toString());
    }

    @DisplayName("로또 머신이 구매자의 로또 번호의 정보를 출력하는 메서드 테스트")
    @Test
    void printLottoInfoTest() {
        consumer.receiveLottoTicket(
                List.of(
                        new Lotto(Arrays.asList(1,2,3,4,5,6)),
                        new Lotto(Arrays.asList(7,8,9,10,11,12))
                )
        );
        String expectedOutput = "\r\n2개를 구매했습니다.\r\n[1, 2, 3, 4, 5, 6]\r\n[7, 8, 9, 10, 11, 12]\r\n";

        LottoMachin lottoMachin = new LottoMachin();
        lottoMachin.printLottoInfo(consumer);

        assertEquals(expectedOutput, output.toString());
    }
}