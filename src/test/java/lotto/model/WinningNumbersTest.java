package lotto.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("보너스 번호 없이 WinningNumbers 인스턴스 생성")
    void testWinningNumbersCreationWithoutBonus() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> new WinningNumbers(winningLotto));
    }

    @Test
    @DisplayName("보너스 번호 설정 후 새로운 WinningNumbers 인스턴스 생성")
    void testWinningNumbersCreationWithBonus() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto);
        assertDoesNotThrow(() -> winningNumbers.createWithBonusNumber(winningNumbers, 7));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void testBonusNumberDuplicate() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> winningNumbers.createWithBonusNumber(winningNumbers, 6)); // 보너스 번호 6은 당첨 번호와 중복
        assertTrue(exception.getMessage().contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."));
    }

    @Test
    @DisplayName("보너스 번호가 유효 범위를 벗어날 경우 예외 발생")
    void testBonusNumberOutOfRange() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> winningNumbers.createWithBonusNumber(winningNumbers, 46)); // 46은 범위를 벗어남
        assertTrue(exception.getMessage().contains("[ERROR] 로또 번호의 범위는 1~45입니다."));
    }

    @Test
    @DisplayName("보너스 번호 설정 전 isBonusNumberMatched 호출 시 예외 발생")
    void testIsBonusNumberMatchedBeforeSetting() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto);
        Exception exception = assertThrows(IllegalStateException.class,
                () -> winningNumbers.isBonusNumberMatched(winningLotto)); // 보너스 번호가 설정되지 않음
        assertTrue(exception.getMessage().contains("[ERROR] 보너스 번호가 설정되지 않았습니다."));
    }

    @Test
    @DisplayName("isBonusNumberMatched 호출로 보너스 번호 일치 여부 확인")
    void testIsBonusNumberMatched() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto)
                .createWithBonusNumber(new WinningNumbers(winningLotto), 7);
        assertTrue(winningNumbers.isBonusNumberMatched(new Lotto(List.of(7, 8, 9, 10, 11, 12))));
    }
}
