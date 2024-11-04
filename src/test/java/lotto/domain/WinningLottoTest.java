package lotto.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningLottoTest {
    @BeforeEach
    void setupTestEnvironment() {
        System.setProperty("IS_TEST_ENV", "true");
    }

    @AfterEach
    void resetTestEnvironment() {
        System.clearProperty("IS_TEST_ENV");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 중복 예외 확인")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkDuplicateWinningNumbersError(int testNum) {
        WinningLotto.resetInstance();
        List<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        test.add(testNum);
        String errorMessage = "[ERROR] 로또 번호에 중복된 번호가 있습니다.";

        assertThatThrownBy(() -> WinningLotto.getWinningLotto(test, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 중복 예외 확인")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void checkDuplicateBonusNumbersError(int testNum) {
        WinningLotto.resetInstance();
        List<Integer> test = Arrays.asList(1, 6, 2, 3, 4, 5);
        String errorMessage = "[ERROR] 로또 번호에 중복된 번호가 있습니다.";

        assertThatThrownBy(() -> WinningLotto.getWinningLotto(test, testNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 범위 예외 확인")
    @ValueSource(ints = {0, 46, 100, -1})
    void checkBoundaryWinningNumbersError(int testNum) {
        WinningLotto.resetInstance();
        List<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        test.add(testNum);
        String errorMessage = "[ERROR] 로또 번호가 범위를 벗어나는 번호가 있습니다.";

        assertThatThrownBy(() -> WinningLotto.getWinningLotto(test, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 범위 예외 확인")
    @ValueSource(ints = {0, 46, 100, -1})
    void checkBoundaryBonusNumbersError(int testNum) {
        WinningLotto.resetInstance();
        List<Integer> test = Arrays.asList(1, 6, 2, 3, 4, 5);
        String errorMessage = "[ERROR] 로또 번호가 범위를 벗어나는 번호가 있습니다.";

        assertThatThrownBy(() -> WinningLotto.getWinningLotto(test, testNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 갯수 예외 확인")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 7, 8})
    void checkWinningNumbersCountOverError(int testNum) {
        WinningLotto.resetInstance();
        List<Integer> test = new ArrayList<>();
        for (int i = 1; i <= testNum; i++) {
            test.add(i);
        }
        String errorMessage = "[ERROR] 로또 번호는 6개여야 합니다.";

        assertThatThrownBy(() -> WinningLotto.getWinningLotto(test, 45))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("정상 동작 확인")
    @ValueSource(ints = {1, 45, 10, 30})
    void checkWinningLotto(int testNum) {
        WinningLotto.resetInstance();
        List<Integer> test = new ArrayList<>(Arrays.asList(3, 20, 33, 13, 44));
        test.add(testNum);

        assertDoesNotThrow(() -> WinningLotto.getWinningLotto(test, 9));
    }
}
