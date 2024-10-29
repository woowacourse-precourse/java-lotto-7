package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputTest {

    private TestInput input;

    @BeforeEach
    void 테스트_인스턴스_생성() {
        input = new TestInput();
    }

    @Test
    void 올바른_금액_입력() {
        input.입력값("1000"); 
        assertDoesNotThrow(() -> input.amountInput());
    }

    @Test
    void 예외처리_숫자가_아닌_값_입력() {
        input.입력값("abc");  
        assertThrows(IllegalArgumentException.class, () -> input.amountInput());
    }
    
    @Test
    void 예외처리_1000원_미만_입력() {
    	input.입력값("900");  
    	assertThrows(IllegalArgumentException.class, () -> input.amountInput());
    }
    
    @Test
    void 예외처리_100000원_초과_입력() {
    	input.입력값("999999");  
    	assertThrows(IllegalArgumentException.class, () -> input.amountInput());
    }

    static class TestInput extends Input {
        private String testInput;

        void 입력값(String input) {
            this.testInput = input;
        }

        @Override
        public String readLine() {
            return testInput;
        }
        
        @Override
        public void amountInput() {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String amount = readLine();
                Amount amountCheck = new Amount(amount);
            } catch (IllegalArgumentException e) {
            	System.err.println(e);
                //테스트 코드에서 무한 반복을 막기위해 재귀 호출 코드 제거
                throw e;
            }
        }
    }
}
