package valid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationUserInputTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    @DisplayName("사용자 입력 정상")
    void validateMoneySuccessCase() {
        //given
        String testInput = "1000";

        //when
        ValidationUserInput validationUserInput = new ValidationUserInput();
        Integer money = validationUserInput.validateMoney(testInput);

        //then
        assertEquals(1000, money);
    }

    @Test
    @DisplayName("사용자가 돈에 음수값 입력시 예외 발생")
    void validateMoneyFailedCase() {
        //given
        String testInput = "-1000";

        //when, then
        ValidationUserInput validationUserInput = new ValidationUserInput();
        validationUserInput.validateMoney(testInput);

        // then
        assertEquals("[ERROR] 0 보다 큰 숫자를 입력 해주세요.", outputMessage.toString().trim());

    }

    @Test
    @DisplayName("사용자가 돈에 문자 입력시 예외 발생")
    void validateMoneyFailedCase2() {
        // given
        String testInput = "1000a";

        // when
        ValidationUserInput validationUserInput = new ValidationUserInput();
        validationUserInput.validateMoney(testInput); // 예외 발생 시도

        // then
        assertEquals("[ERROR] 숫자만 입력 가능합니다.", outputMessage.toString().trim());
    }

    @Test
    @DisplayName("사용자 입력 돈이 1000원 단위가 아닌 경우 예외 발생")
    void validateMoneyFailedCase3() {
        //given
        String testInput = "1234";

        //when, then
        ValidationUserInput validationUserInput = new ValidationUserInput();
        validationUserInput.validateMoney(testInput);

        // then
        assertEquals("[ERROR] 로또 금액은 1000원 단위로만 구매 가능합니다.", outputMessage.toString().trim());
    }
}