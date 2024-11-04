package lotto;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    InputReader inputReader = new InputReader();
    InputStream originalIn = System.in;

    @AfterEach
    void rollBack() {
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("정상적인 가격을 입력했을 때 통과")
    void ShouldNotThrowException() {
        String testString = "14000";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        //14000원 입력
        Assertions.assertDoesNotThrow(() -> {
            int p = inputReader.readLottoPrice();
        });
    }

    @Test
    @DisplayName("숫자로 바꿀 수 없는 1s 같은 문자가 입력 됐을 때 예외 출력")
    void ShouldReturnNumberFormatException() {
        String testString = "1s";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            int p = inputReader.readLottoPrice();
        });
        assertEquals(error.getMessage(), "구입 금액을 숫자로 입력해 주세요.");
    }

    @Test
    @DisplayName("음수가 입력 됐을 때 예외 출력")
    void WhenNegativeNumber_ShouldReturnIllegalArgumentException() {
        String testString = "-1";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            int p = inputReader.readLottoPrice();
        });
        assertEquals(error.getMessage(), "구입 금액을 양수로 입력해 주세요.");
    }

    @Test
    @DisplayName("음수가 입력 됐을 때 예외 출력")
    void WhenNotDividedNumber_ShouldReturnIllegalArgumentException() {
        String testString = "14001";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            int p = inputReader.readLottoPrice();
        });
        assertEquals(error.getMessage(), "구입 금액은 1000로 나누어 떨어져야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호를 정상적으로 입력했을 때")
    void WinningNumber_ShouldNotReturnException() {
        String testString = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        assertDoesNotThrow(() -> {
            Lotto winningNumbers = inputReader.readWinningNumbers();
        });
    }

    @Test
    @DisplayName("당첨 번호 형식이 올바르지 않을 때")
    void WinningNumber_ShouldReturnNumberFormatException() {
        String testString = "1,2,3,a,5,6";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Lotto winningNumbers = inputReader.readWinningNumbers();
        });
        assertEquals(e.getMessage(), "당첨 입력 형식이 올바르지 않습니다. 콤마(,)로 구분되는 1이상 45 이하 숫자 6개를 입력해 주세요");
    }
    @Test
    @DisplayName("당첨 번호가 6개 이상일 때")
    void WinningNumberMoreThanSix_ShouldReturnException() {
        String testString = "1,2,3,4,5,6,7";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Lotto winningNumbers = inputReader.readWinningNumbers();
        });
        assertEquals(e.getMessage(), "당첨 입력 형식이 올바르지 않습니다. 콤마(,)로 구분되는 1이상 45 이하 숫자 6개를 입력해 주세요");
    }
    @Test
    @DisplayName("당첨 번호가 로또 숫자 범위를 넘어설 때")
    void WinningNumberOutOfRange_ShouldReturnException() {
        String testString = "1,2,3,4,5,96";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Lotto winningNumbers = inputReader.readWinningNumbers();
        });
        assertEquals(e.getMessage(), "당첨 번호는 1이상 45이하 숫자로 입력해 주세요.");
    }
    @Test
    @DisplayName("당첨 번호 로또 숫자 중복될 때")
    void WinningNumberHasDuplicates_ShouldReturnException() {
        String testString = "1,2,3,4,5,5";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Lotto winningNumbers = inputReader.readWinningNumbers();
        });
        assertEquals(e.getMessage(), "서로 다른 당첨 번호 6개를 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 번호를 정상적으로 입력했을 때")
    void BonusNumber_ShouldNotReturnException() {
        String testString = "1,2,3,4,5,6\n7";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        assertDoesNotThrow(() -> {
            Lotto winningLotto = inputReader.readWinningNumbers();
            int bonus = inputReader.readBonusNumber(winningLotto);
        });
    }
    @Test
    @DisplayName("보너스 번호가 1이상 45이하가 아닐 때")
    void BonusNumberOutOfRange_ShouldReturnException() {
        String testString = "1,2,3,4,5,6\n78";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Lotto winningLotto = inputReader.readWinningNumbers();
            int bonus = inputReader.readBonusNumber(winningLotto);
        });
        assertEquals(e.getMessage(), "당첨 번호는 1이상 45이하 숫자로 입력해 주세요.");
    }
    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복될 때")
    void BonusNumberHasDuplicateWithWinningNumbers_ShouldReturnException() {
        String testString = "1,2,3,4,5,6\n5";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Lotto winningLotto = inputReader.readWinningNumbers();
            int bonus = inputReader.readBonusNumber(winningLotto);
        });
        assertEquals(e.getMessage(), "보너스 번호는 당첨번호와 달라야 합니다.");
    }
}