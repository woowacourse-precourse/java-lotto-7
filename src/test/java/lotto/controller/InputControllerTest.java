package lotto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.Lotto;
import lotto.exception.BonusNumberDuplicateException;
import lotto.exception.BonusNumberOutOfBoundException;
import lotto.exception.LottoInvalidException;
import lotto.exception.PurchaseNumberInvalidException;
import lotto.exception.PurchaseNumberOverFlowException;
import lotto.exception.PurchaseNumberUnderFlowException;
import lotto.exception.PurchaseNumberUnitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputControllerTest {
    InputController inputController;

    @BeforeEach
    void setUp() {
        inputController = new InputController();
    }

    @DisplayName("구매 금액 정상적으로 입력한다")
    @Test
    void success_getPurchaseNumber() {
        assertEquals(10000, inputController.validatePurchaseNumberInput("10000"));
    }

    @DisplayName("구매 금액에 문자를 입력하면 예외가 발생한다")
    @Test
    void exception_getPurchaseNumber_notNumber() {
        assertThrows(PurchaseNumberInvalidException.class, () -> {
            inputController.validatePurchaseNumberInput("abcd");
        });
    }

    @DisplayName("구매 금액에 2,147,483,000을 초과하면 예외가 발생한다")
    @Test
    void exception_getPurchaseNumber_overflow() {
        assertThrows(PurchaseNumberOverFlowException.class, () -> {
            inputController.validatePurchaseNumberInput("2147483001");
        });
    }

    @DisplayName("구매 금액에 1000 미만이면 예외가 발생한다")
    @Test
    void exception_getPurchaseNumber_underflow() {
        assertThrows(PurchaseNumberUnderFlowException.class, () -> {
            inputController.validatePurchaseNumberInput("-10");
        });
    }

    @DisplayName("구매 금액에 1000 단위가 아니면 예외가 발생한다")
    @Test
    void exception_getPurchaseNumber_not1000unit() {
        assertThrows(PurchaseNumberUnitException.class, () -> {
            inputController.validatePurchaseNumberInput("10020");
        });
    }

    @DisplayName("로또 번호를 정상적으로 입력한다")
    @Test
    void success_getLottoNumber() {
        Lotto expectedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = inputController.validateLottoInput("1,2,3,4,5,6");

        assertEquals(expectedLotto.getNumbers(), lotto.getNumbers());
    }

    @DisplayName("로또 번호에 문자를 입력하면 예외가 발생한다")
    @Test
    void exception_getLottoNumber_notNumber() {
        String input = "1,2,3,asd,4,5";
        assertThrows(LottoInvalidException.class, () -> {
            inputController.validateLottoInput(input);
        });
    }

    @DisplayName("보너스 번호를 정상적으로 입력한다")
    @Test
    void success_getBonusNumber() {
        Integer bonusNumber = inputController.validateBonusNumberInput("10", new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertEquals(bonusNumber, 10);
    }

    @DisplayName("보너스 번호에 문자를 입력하면 예외가 발생한다")
    @Test
    void exception_getBonusNumber_notNumber() {
        assertThrows(BonusNumberOutOfBoundException.class, () -> {
            inputController.validateBonusNumberInput("ㅁㄴㅇㄹ", new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        });
    }

    @DisplayName("보너스 번호에 로또 번호와 중복된 숫자를 입력하면 예외가 발생한다")
    @Test
    void exception_getBonusNumber_duplicate() {
        assertThrows(BonusNumberDuplicateException.class, () -> {
            inputController.validateBonusNumberInput("1", new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        });
    }

    @DisplayName("보너스 번호에 1~45가 아닌 숫자를 입력하면 예외가 발생한다")
    @Test
    void exception_getBonusNumber_outOfBound() {
        assertThrows(BonusNumberOutOfBoundException.class, () -> {
            inputController.validateBonusNumberInput("-17", new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        });

        assertThrows(BonusNumberOutOfBoundException.class, () -> {
            inputController.validateBonusNumberInput("100000", new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        });
    }
}