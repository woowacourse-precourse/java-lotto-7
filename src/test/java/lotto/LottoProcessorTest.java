package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import lotto.domain.LottoDrawer;
import lotto.domain.calculator.PurchaseCalculator;
import lotto.domain.lottoGeneratir.RandomLottoGenerator;
import lotto.utils.LottoMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoProcessorTest {
    private LottoProcessor lottoProcessor;

    @BeforeEach
    void beforeEach() {
        lottoProcessor = new LottoProcessor(new PurchaseCalculator(), new LottoDrawer(), new RandomLottoGenerator(), new RandomLottoResult());
    }

    @Test
    void 로또_개수_출력() {
        //given
        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes()); // 문자열을 InputStream으로 변환
        System.setIn(in); // System.in 설정

        PrintStream originalOut = System.out; // 원래의 System.out 저장
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // 현재 데이터 캡처
        PrintStream newOut = new PrintStream(outputStream); // 문자열을 받아 바이트 형태로 변환
        System.setOut(newOut); // System.out을 newOut으로 설정

        //when
        lottoProcessor.purchaseProcess(8000); // 구매 과정 호출

        //then
        System.setOut(originalOut); // 원래의 System.out으로 복원
        String output = outputStream.toString(); // 출력 내용 문자열로 변환

        assertEquals("8"+ LottoMessages.PURCHASED_LOTTO_COUNT.getMessage(), output.trim()); // 예상 출력과 비교
    }
}