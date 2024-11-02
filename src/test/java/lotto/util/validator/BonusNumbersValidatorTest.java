package lotto.util.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumbersValidatorTest {

    @Test
    @DisplayName("정상적인 입력의 경우")
    void NormalBonusNumber(){
        //given
        String inputBonusNumber = "10";
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        BonusNumbersValidator.validateBonusNumber(inputBonusNumber,winnerNumbers);
    }

    @Test
    @DisplayName("보너스 번호의 입력이 비어있는 경우")
    void EmptyBonusNumber(){
        //given
        String inputBonusNumber = "";
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> BonusNumbersValidator.validateBonusNumber(inputBonusNumber, winnerNumbers));

    }

    @Test
    @DisplayName("보너스 번호의 앞에 공백이 있는 경우")
    void BonusNumberWithWhitespaceAtHead(){
        //given
        String inputBonusNumber = " 10";
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> BonusNumbersValidator.validateBonusNumber(inputBonusNumber, winnerNumbers));

    }

    @Test
    @DisplayName("보너스 번호의 뒤에 공백이 있는 경우")
    void BonusNumberWithWhitespaceAtTail(){
        //given
        String inputBonusNumber = "10 ";
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> BonusNumbersValidator.validateBonusNumber(inputBonusNumber, winnerNumbers));

    }

    @Test
    @DisplayName("입력된 모든 값이 Digit으로 구성되어있는지 검증")
    void BonusNumberHasOnlyDigit() {
        //given
        String inputBonusNumber = "-10";
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> BonusNumbersValidator.validateBonusNumber(inputBonusNumber, winnerNumbers));
    }

    @Test
    @DisplayName("입력된 정수값의 앞이 0으로 설정되어있는지 확인")
    void BonusNumberStartWithZero(){
        //given
        String inputBonusNumber = "010";
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> BonusNumbersValidator.validateBonusNumber(inputBonusNumber, winnerNumbers));
    }

    @Test
    @DisplayName("입력된 보너스 번호가 1-45 사이의 숫자인지 확인")
    void BonusNumberIsBetweenThreshold(){
        //given
        String inputBonusNumber = "50";
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> BonusNumbersValidator.validateBonusNumber(inputBonusNumber, winnerNumbers));
    }

    @Test
    @DisplayName("입력된 정수값이 당첨 번호와 중복되는지 확인")
    void BonusNumberIsDuplicateWithWinnerNumbers(){
        //given
        String inputBonusNumber = "6";
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,

                //when
                () -> BonusNumbersValidator.validateBonusNumber(inputBonusNumber, winnerNumbers));
    }
}