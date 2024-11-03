package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    @ParameterizedTest
    @CsvSource({
            "'6,7,1,2,40,30', '1,2,6,7,30,40'",
            "'6,5,4,3,2,1', '1,2,3,4,5,6'",
            "'10,9,8,30,44,21','8,9,10,21,30,44'"
    })
    @DisplayName("로또가 성공적으로 생성되면 번호가 오름차순 정렬된다")
    void lottoTest(String numbersInput, String expected) throws NoSuchFieldException, IllegalAccessException {
        //given
        ArrayList<Integer> numbers = convertStringToIntegerList(numbersInput);
        ArrayList<Integer> expectResult = convertStringToIntegerList(expected);
        //when
        Lotto lotto = new Lotto(numbers);
        //then
        assertThatLottoValidated(lotto, expectResult);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6,7', '[ERROR] 로또 번호는 6개여야 합니다.'",
            "'1,2,3,4,5,5', '[ERROR] 로또 번호는 중복될 수 없습니다.'",
            "'1,2,3,4,5,60', '[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.'",
            "'-1,2,3,4,5,6','[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.'"
    })
    @DisplayName("로또 번호가 잘못된 경우 예외가 발생하며 메세지가 출력된다.")
    void validateLottoNumbers(String numbers, String expectedMessage) {
        //given, when
        List<Integer> numberList = convertStringToIntegerList(numbers);
        //then
        assertThatThrownBy(() -> new Lotto(numberList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }


    @Test
    @DisplayName("매개 변수가 없는 Lotto 생성자는 로또를 발행한다.")
    void generateLottoTest() {
        ArrayList<Integer> mockedNumbers = new ArrayList<>(List.of(25, 12, 42, 3, 34, 19));
        ArrayList<Integer> sortedNumbers = mockedNumbers.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));


        Assertions.assertRandomUniqueNumbersInRangeTest(() -> {
            Lotto lotto = new Lotto();
            try {
                assertThatLottoValidated(lotto, sortedNumbers);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }, mockedNumbers);

    }


    private static ArrayList<Integer> convertStringToIntegerList(String input) {
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void assertThatLottoValidated(Lotto lotto, ArrayList<Integer> numbers)
            throws NoSuchFieldException, IllegalAccessException {
        // Reflection: private 필드에 접근
        Field numbersField = Lotto.class.getDeclaredField("numbers");
        boolean originalAccessible = numbersField.canAccess(lotto);
        numbersField.setAccessible(true);
        ArrayList<Integer> lottoNumbers = (ArrayList<Integer>) numbersField.get(lotto);
        assertThat(lottoNumbers).isEqualTo(numbers);
        // 접근 제어자 복원
        numbersField.setAccessible(originalAccessible);
    }
}
