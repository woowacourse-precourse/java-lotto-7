package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.MoneyInputErrorMessage;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    private InputHandler inputHandler;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000", "5000", "10000", "  10000  ", "100000000000"})
    @DisplayName("올바른 로또 구입 금액(1000의 배수) 입력 시 입력값이 정상적으로 저장된다")
    void validLottoPurchaseAmount_isStoredCorrectly(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        long purchaseAmount = inputHandler.inputLottoPurchaseMoney();

        // then
        assertThat(purchaseAmount)
                .isEqualTo(Long.parseLong(input.trim()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1000.5", "1000원"})
    @DisplayName("문자열 또는 소수 입력 시 오류 메시지가 출력된다")
    void invalidStringOrDecimalInput_printsErrorMessage(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        // when
        // then
        assertThatThrownBy(() -> inputHandler.inputLottoPurchaseMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MoneyInputErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000000000000000", "1000000000000000000000000000000000000000000000000000000000000"})
    @DisplayName("최대 금액 범위를 초과하는 경우 오류 메시지가 출력된다")
    void exceedingMaximumLongValue_printsErrorMessage(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        // then
        assertThatThrownBy(() -> inputHandler.inputLottoPurchaseMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MoneyInputErrorMessage.INVALID_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "1 2 3 4 5"})
    @DisplayName("공백 입력 시 오류 메시지가 출력된다")
    void blankInput_printsErrorMessage(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        // then
        assertThatThrownBy(() -> inputHandler.inputLottoPurchaseMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MoneyInputErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }


    @ParameterizedTest
    @ValueSource(strings = {"1000!", "$1000", "1000#"})
    @DisplayName("특수 문자가 포함된 입력 시 오류 메시지가 출력된다")
    void inputWithSpecialCharacters_printsErrorMessage(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        // then
        assertThatThrownBy(() -> inputHandler.inputLottoPurchaseMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MoneyInputErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "  7,8, 9,10,11,12  "})
    @DisplayName("올바른 형식의 당첨 번호 입력 시 로또 번호가 정상적으로 저장된다")
    void validWinningNumbers_isStoredCorrectly(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        LottoDto lottoDto = inputHandler.inputWinningNumbers();

        // then
        assertThat(lottoDto.numbers())
                .containsExactly(Stream.of(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, a, 4, 5, 6", "7, 8, 9, 10, 11, 1000000000000000000"})
    @DisplayName("잘못된 형식의 당첨 번호 입력 시 오류 메시지가 출력된다")
    void invalidWinningNumbers_printsErrorMessage(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        // then
        assertThatThrownBy(() -> inputHandler.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0, 2, 3, 4, 5, 6", "1, -1, 3, 4, 5, 6", "46, 2, 3, 4, 5, 6", "10, 20, 30, 40, 50, 60"})
    @DisplayName("로또 번호 입력 시 숫자 타입이지만 범위를 벗어나는 경우에도 예외가 발생하지 않는다")
    void outOfRangeLottoNumbers_doesNotThrowException(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        LottoDto lottoNumbers = inputHandler.inputWinningNumbers();

        // then
        List<Integer> expectedNumbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        assertThat(lottoNumbers.numbers()).isEqualTo(expectedNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7", "8", "45"})
    @DisplayName("올바른 형식의 보너스 번호 입력 시 값이 정상적으로 저장된다")
    void validBonusNumber_isStoredCorrectly(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int bonusNumber = inputHandler.inputBonusNumber();

        // then
        assertThat(bonusNumber)
                .isEqualTo(Integer.parseInt(input.trim()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1000.5"})
    @DisplayName("잘못된 형식의 보너스 번호 입력 시 오류 메시지가 출력된다")
    void invalidBonusNumber_printsErrorMessage(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        // then
        assertThatThrownBy(() -> inputHandler.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "46", "100"})
    @DisplayName("보너스 번호 입력 시 숫자 타입이지만 범위를 벗어나는 경우에도 예외가 발생하지 않는다")
    void outOfRangeBonusNumber_doesNotThrowException(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int bonusNumber = inputHandler.inputBonusNumber();

        // then
        assertThat(bonusNumber)
                .isEqualTo(Integer.parseInt(input.trim()));
    }

}