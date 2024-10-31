package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorPrinterTest {
    @Test
    @DisplayName("에러 메시지 출력 확인")
    void errorPrintTest(){
        ErrorPrinter.errorPrint(InputErrorMessage.PURCHASE_PRICE_CANT_BE_DIVIDED_CLEARLY);
    }
}