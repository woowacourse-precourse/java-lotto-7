package lotto.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoExceptionMessage;
import lotto.exception.PurchaseExceptionMessage;
import lotto.exception.WinningNumbersExceptionMessage;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    void 성공__객체생성() {
        // given
        int paymentAmount = 14000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoMachine lottoMachine = new LottoMachine(paymentAmount, winningNumbers, bonusNumber);

        // then
        assertNotNull(lottoMachine);
    }

    // WinnerNumbers 관련 테스트

    @Test
    void 실패__객체생성_중복된_숫자_메인넘버() {
        // given
        int paymentAmount = 14000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 7;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        assertEquals(LottoExceptionMessage.DUPLICATE_NUMBERS.getMessage(), exception.getMessage());
    }

    @Test
    void 실패__객체생성_중복된_숫자_보너스() {
        // given
        int paymentAmount = 14000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        assertEquals(WinningNumbersExceptionMessage.BONUS_NUMBER_DUPLICATE.getMessage(), exception.getMessage());
    }

    @Test
    void 실패__객체생성_보너스숫자_범위_위() {
        // given
        int paymentAmount = 14000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        assertEquals(WinningNumbersExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    void 실패__객체생성_보너스숫자_범위_아래() {
        // given
        int paymentAmount = 14000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 0;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        assertEquals(WinningNumbersExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    void 실패__객체생성_숫자_부족() {
        // given
        int paymentAmount = 14000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        int bonusNumber = 10;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        assertEquals(LottoExceptionMessage.INVALID_NUMBER_COUNT.getMessage(), exception.getMessage());
    }

    // Purchase 관련 테스트

    @Test
    void 실패__객체생성_돈_부족() {
        // given
        int paymentAmount = 999;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        assertEquals(PurchaseExceptionMessage.AMOUNT_LESS_THAN_PRICE.getMessage(), exception.getMessage());
    }

    @Test
    void 실패__객체생성_1000원_단위가_아닐때_입력_1001() {
        // given
        int paymentAmount = 1001;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        assertEquals(PurchaseExceptionMessage.AMOUNT_NOT_MULTIPLE_OF_PRICE.getMessage(), exception.getMessage());
    }

    @Test
    void 실패__객체생성_1000원_단위가_아닐때_입력_1999() {
        // given
        int paymentAmount = 1999;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        assertEquals(PurchaseExceptionMessage.AMOUNT_NOT_MULTIPLE_OF_PRICE.getMessage(), exception.getMessage());
    }

    @Test
    void 실패__객체생성_winningNumbers가_NULL() {
        // given
        int paymentAmount = 2000;
        List<Integer> winningNumbers = null;
        int bonusNumber = 10;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        System.out.println(exception.getMessage());
        assertEquals(WinningNumbersExceptionMessage.NULL_OR_EMPTY_NUMBERS.getMessage(), exception.getMessage());
    }


    @Test
    void 실패__객체생성_winningNumbers_중간에_NULL() {
        // given
        int paymentAmount = 2000;
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, null, 5, 6));
        int bonusNumber = 10;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoMachine(paymentAmount, winningNumbers, bonusNumber));

        // then
        System.out.println(exception.getMessage());
        assertEquals(WinningNumbersExceptionMessage.NULL_OR_EMPTY_NUMBERS.getMessage(), exception.getMessage());
    }


}
