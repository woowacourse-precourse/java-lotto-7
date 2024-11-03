package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.enums.ErrorMessage;
import lotto.service.LottoService;
import lotto.utility.Parser;
import lotto.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    private LottoService lottoService;


    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("당첨번호 입력값이 비어있는 경우 예외를 발생시킨다")
    void isBlankWinningNumberInput(String winningNumber) {
        assertThatThrownBy(() -> lottoService.validateInputWinNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_BLANK_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,,", "1,2,,3,4,5,6", "1*2,3,4,5,6"})
    @DisplayName("당첨번호에 숫자와 콤마(,)의 배치가 잘못된 경우 예외를 발생시킨다")
    void isValidNumberAndDelimiter(String winningNumber) {
        assertThatThrownBy(() -> lottoService.validateInputWinNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DELIMITER_AND_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3,15,22,33,39,45", "11,12,13,15,16,17"})
    @DisplayName("입력된 당첨번호를 콤마(,)로 올바르게 분리한다")
    void splitWinningNumberByComma(String winningNumber) {
        String[] expectedResult = winningNumber.split(",");

        String[] realResult = lottoService.splitWinningNumber(winningNumber);
        assertThat(realResult).containsExactly(expectedResult);
    }

    @Test
    @DisplayName("분리된 당첨번호의 개수가 6개가 아닌 경우 예외를 발생시킨다")
    void isWinningNumberCountSix() {
        String[] splitWinningNumbers = {"1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> Validator.isNumberSixSize(splitWinningNumbers))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("분리한 당첨번호에 숫자가 비어있는 경우 예외를 발생시킨다")
    void isBlankSplitWinningNumber(String winningNumber) {
        String[] splitWinningNumbers = {winningNumber, "1", "2", "3", "4", "5"};

        assertThatThrownBy(() -> lottoService.validateSplitWinNumber(splitWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_BLANK_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "90"})
    @DisplayName("분리된 당첨 번호가 1~45 사이가 아닌 경우 예외를 발생시킨다")
    void isValidWinningNumberRange(String winningNumber) {
        int parsedWinNumber = Parser.parseStringToInt(winningNumber);

        assertThatThrownBy(() -> Validator.isBetweenOneAndFortyFive(parsedWinNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_NOT_BETWEEN_ONE_AND_FORTYFIVE.getMessage());
    }

    @Test
    @DisplayName("분리된 당첨 번호에 중복된 숫자가 있는 경우 예외를 발생시킨다")
    void isExistDuplicateNumber() {
        String[] splitWinningNumbers = {"1", "2", "3", "4", "5", "5"};
        Set<Integer> existNumber = new HashSet<>();

        assertThatThrownBy(() -> {
            for (String number : splitWinningNumbers) {
                int parsedWinNumber = Parser.parseStringToInt(number);
                if (!existNumber.add(parsedWinNumber)) {
                    throw new IllegalStateException(ErrorMessage.INPUT_NUMBER_DUPLICATE_ERROR.getMessage());
                }
            }
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.INPUT_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 당첨번호가 WinningNumber에 들어간 경우 예외를 발생시킨다")
    void isInvalidNumbersProvidedInWinningNumber() {
        String[] splitWinningNumbers = {"1", "2", "3", "4", "5", "46"};

        assertThatThrownBy(() -> {
            List<Integer> validWinNumbers = lottoService.validateSplitWinNumber(splitWinningNumbers)
                    .getWinningNumbers();
            new WinningNumber(validWinNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
