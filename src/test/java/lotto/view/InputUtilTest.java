package lotto.view;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputUtilTest {
    private InputUtil input;

    @BeforeEach
    public void setUp(){
        input = new InputUtil();
    }

    @Test
    @DisplayName("정수가 아닌 수를 입력했을 때")
    public void getPurchaseAmount_nonNumericThenValid() throws Exception {
        String inValidInput = "1000.123";
        Method method = InputUtil.class.getDeclaredMethod("checkValidPurchaseAmount", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 입력값은 공백없는 자연수여야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("1,000원 미만 입력했을 때")
    public void getPurchaseAmount_lessThan1000() throws Exception {
        String inValidInput = "500";
        Method method = InputUtil.class.getDeclaredMethod("checkValidPurchaseAmount", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("1,000원 단위가 아닌 숫자 입력했을 때")
    void getPurchaseAmount_notMultipleOf1000() throws Exception {
        String inValidInput = "1500";
        Method method = InputUtil.class.getDeclaredMethod("checkValidPurchaseAmount", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 구입 금액은 1,000원 단위여야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("0이 입력됐을 때")
    void getPurchaseAmount_Zero() throws Exception {
        String inValidInput = "0";
        Method method = InputUtil.class.getDeclaredMethod("checkValidPurchaseAmount", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("유효한 당첨 번호를 입력했을 때")
    void parseWinningNumbers_validInput() throws Exception {
        String validInput = "1,2,3,4,5,6";
        Method method = InputUtil.class.getDeclaredMethod("parseWinningNumbers", String.class);
        method.setAccessible(true);
        List<Integer> result = (List<Integer>) method.invoke(input, validInput);
        assertEquals(List.of(1,2,3,4,5,6), result, "유효한 입력일 때 올바른 번호 리스트가 반환되어야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호 개수가 6개 미만일 때")
    void parseWinningNumbers_lessThanSixNumbers() throws Exception {
        String inValidInput = "1,2,3,4,5"; // 5개
        Method method = InputUtil.class.getDeclaredMethod("parseWinningNumbers", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 입력 형식이 올바르지 않습니다. 번호는 쉼표(,)로 구분하여 6개를 입력해야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 개수가 6개 초과일 때")
    void parseWinningNumbers_moreThanSixNumbers() throws Exception {
        String inValidInput = "1,2,3,4,5,6,7"; // 7개
        Method method = InputUtil.class.getDeclaredMethod("parseWinningNumbers", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 입력 형식이 올바르지 않습니다. 번호는 쉼표(,)로 구분하여 6개를 입력해야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 쉼표가 아닌 구분자가 있을 때")
    void parseWinningNumbers_notComma() throws Exception {
        String inValidInput = "1,2,3,4,5/46"; // 46은 범위 초과
        Method method = InputUtil.class.getDeclaredMethod("parseWinningNumbers", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 입력 형식이 올바르지 않습니다. 번호는 쉼표(,)로 구분하여 6개를 입력해야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있을 때")
    void parseWinningNumbers_numberOutOfRange() throws Exception {
        String inValidInput = "1,2,3,4,5,46"; // 46은 범위 초과
        Method method = InputUtil.class.getDeclaredMethod("parseWinningNumbers", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 모든 번호는 1부터 45 사이의 숫자여야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있을 때")
    void parseWinningNumbers_duplicateNumbers() throws Exception {
        String inValidInput = "1,2,3,4,5,5"; // 5가 중복됨
        Method method = InputUtil.class.getDeclaredMethod("parseWinningNumbers", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 중복된 번호가 있습니다.", cause.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 비숫자가 포함되었을 때")
    void parseWinningNumbers_nonNumericInput() throws Exception {
        String inValidInput = "1,2,3,4,5,a"; // 'a'는 숫자가 아님
        Method method = InputUtil.class.getDeclaredMethod("parseWinningNumbers", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 입력값은 공백없는 자연수여야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 공백이 포함된 유효한 입력 시")
    void parseWinningNumbers_inputWithSpaces() throws Exception {
        String invalidInputWithSpaces = " 1, 2, 3, 4, 5, 6 ";
        Method method = InputUtil.class.getDeclaredMethod("parseWinningNumbers", String.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, invalidInputWithSpaces);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 입력값은 공백없는 자연수여야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
    void getBonusNumber_duplicateBonusNumber() throws Exception {
        String invalidInput = "5"; // 보너스 번호가 이미 당첨 번호에 포함됨
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Method method = InputUtil.class.getDeclaredMethod("checkValidBonusNumber", String.class, List.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, invalidInput, winningNumbers);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 중복된 번호가 있습니다.", cause.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않을 때 정상 반환")
    void getBonusNumber_validBonusNumber() throws Exception {
        String validInput = "7"; // 보너스 번호가 당첨 번호에 포함되지 않음
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Method method = InputUtil.class.getDeclaredMethod("checkValidBonusNumber", String.class, List.class);
        method.setAccessible(true);
        method.invoke(input, validInput, winningNumbers);
    }

    @Test
    @DisplayName("보너스 번호에 비숫자가 포함되었을 때 예외 발생")
    void getBonusNumber_nonNumericInput() throws Exception {
        String invalidInput = "a"; // 비숫자 입력
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Method method = InputUtil.class.getDeclaredMethod("checkValidBonusNumber", String.class, List.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, invalidInput, winningNumbers);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 입력값은 공백없는 자연수여야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어난 숫자일 때 예외 발생")
    void getBonusNumber_numberOutOfRange() throws Exception {
        String invalidInput = "46"; // 범위를 벗어난 숫자
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Method method = InputUtil.class.getDeclaredMethod("checkValidBonusNumber", String.class, List.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, invalidInput, winningNumbers);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 모든 번호는 1부터 45 사이의 숫자여야 합니다.", cause.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 입력에 공백이 포함된 유효한 입력 시")
    void getBonusNumber_inputWithSpaces() throws Exception {
        String invalidInput = " 7 ";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Method method = InputUtil.class.getDeclaredMethod("checkValidBonusNumber", String.class, List.class);
        method.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, invalidInput, winningNumbers);
        });
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException, "Exception should be IllegalArgumentException");
        assertEquals("[ERROR] 입력값은 공백없는 자연수여야 합니다.", cause.getMessage());
    }
}
