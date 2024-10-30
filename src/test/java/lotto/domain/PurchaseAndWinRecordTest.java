package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseAndWinRecordTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }


    @ParameterizedTest
    @DisplayName("구입 금액 빈문자열 및 정수값 변환 불가 예외 확인")
    @ValueSource(strings = {"", "0.1000", "$1000"})
    void checkNotIntegerAndEmptyPurchaseError(String test) {
        String errorMessage = "[ERROR] 구입 금액은 정수값만 입력할 수 있습니다."

        assertThatThrownBy(() -> new PurchaseAndWinRecord(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("구입 불가능 금액 예외 확인")
    @ValueSource(strings = {"999", "0", "10", "101000", "1000000"})
    void checkPurchaseBoundaryOverError(String test) {
        String errorMessage = "[ERROR] 구입 금액은 1000이상 100000 이하의 값만 가능합니다."

        assertThatThrownBy(() -> new PurchaseAndWinRecord(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("구입 가능 금액 확인")
    @ValueSource(strings = {"1000", "10000", "100000", "5000", "70000"})
    void checkSuccessPurchaseAmount(String test) {
        PurchaseAndWinRecord purchaseAndWinRecord = new PurchaseAndWinRecord(test);

        assertEquals(purchaseAndWinRecord.getPurchaseAmount(), test);
    }

    @ParameterizedTest
    @DisplayName("구입 가능 횟수 확인")
    @ValueSource(strings = {"1000", "10000", "100000", "5000", "70000"})
    void checkSuccessPurchaseCount(String test) {
        int successPurchaseCount = Integer.parseInt(test) / 1000;
        PurchaseAndWinRecord purchaseAndWinRecord = new PurchaseAndWinRecord(test);

        assertEquals(purchaseAndWinRecord.getPurchaseCount(), successPurchaseCount);
    }

    @DisplayName("당첨 현황 저장 및 반환 확인")
    @Test
    void checkWinRecord() {
        List<Integer> winningRank = Arrays.asList(1, 2, 5, 0, 0);
        List<Integer> successWinRecord = Arrays.asList(1, 1, 0, 0, 1);
        PurchaseAndWinRecord purchaseAndWinRecord = new PurchaseAndWinRecord(5000);

        assertDoesNotThrow(() -> purchaseAndWinRecord.setWinRecord(winningRank));

        assertEquals(purchaseAndWinRecord.getWinRecord(), successWinRecord);
    }

    @DisplayName("당첨 금액 총합 반환 확인")
    @Test
    void checkWinRecord() {
        List<Integer> winningRank = Arrays.asList(1, 2, 5, 0, 0);
        long successtotalPrize = 2_030_005_000;
        PurchaseAndWinRecord purchaseAndWinRecord = new PurchaseAndWinRecord(5000);
        purchaseAndWinRecord.setWinRecord(winningRank);

        assertDoesNotThrow(() -> purchaseAndWinRecord.setWinRecord(winningRank));

        assertEquals(purchaseAndWinRecord.getTotalPrize(), successtotalPrize);
    }
}
