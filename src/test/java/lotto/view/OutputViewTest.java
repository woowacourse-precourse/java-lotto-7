package lotto.view;

import lotto.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private OutputView outputView; // OutputView 인스턴스
    private ByteArrayOutputStream outputStream; // 출력 스트림 캡처용
    private PrintStream originalOut; // 원래의 System.out

    @BeforeEach
    void setUp() {
        // OutputView 인스턴스 초기화
        outputView = new OutputView();

        // 출력 스트림을 ByteArrayOutputStream으로 설정
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out; // 원래의 System.out 저장
        System.setOut(new PrintStream(outputStream)); // System.out을 outputStream으로 리다이렉트
    }

    @Test
    void 구매수량_입력시_구매완료메세지_출력() {
        // Act
        outputView.printPurchasedLottoCount(8); // 테스트할 메서드 호출

        // Assert
        String expectedOutput = "8개를 구매했습니다.\r\n"; // 예상 출력
        assertEquals(expectedOutput, outputStream.toString()); // 캡처된 출력과 비교
    }



    @AfterEach
    void tearDown() {
        // 테스트 후 System.out을 원래대로 복원
        System.setOut(originalOut);
    }
}
