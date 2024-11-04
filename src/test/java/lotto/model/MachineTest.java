package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.view.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MachineTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("예외 테스트: 잘못된 형식의 구매 금액 문자열 입력")
    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "7000won", "1000.4", "0", "-1", "2024"})
    void request_amount_exception(String userInput) {
        Input input = new Input();
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        assertThatThrownBy(() -> input.requestAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 잘못된 형식의 로또 번호 문자열 입력")
    @ParameterizedTest
    @ValueSource(strings = {"\n", "1.2.3.4.5.6", " 1,2,3,4,5,!", "1.1,2,3,4,5,6"})
    void request_winning_numbers_exception(String userInput) {
        Input input = new Input();
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        assertThatThrownBy(() -> input.requestWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 잘못된 형식의 보너스 번호 문자열 입력")
    @ParameterizedTest
    @ValueSource(strings = {"\n", "3.1"})
    void request_bonus_number_exception(String userInput) {
        Input input = new Input();
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        assertThatThrownBy(() -> input.requestBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}