package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    private static ArrayList<Integer> convertStringToIntegerList(String input) {
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @ParameterizedTest
    @CsvSource({
            "'6,7,1,2,40,30', '1,2,6,7,30,40'",
            "'6,5,4,3,2,1', '1,2,3,4,5,6'",
            "'10,9,8,30,44,21','8,9,10,21,30,44'"
    })
    @DisplayName("생성자에 randomNumbersGenerator를 주입하면 오름차순 랜덤 로또가 생성된다")
    void lottoTest(String numbersInput, String expected) {
        //given
        List<Integer> numbers = convertStringToIntegerList(numbersInput);
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator() {
            @Override
            public List<Integer> generate() {
                return numbers;
            }
        };
        List<Integer> expectResult = convertStringToIntegerList(expected);
        //when
        //then
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lotto lotto = new Lotto(randomNumbersGenerator);
                    assertThat(lotto.displayNumbers()).contains(expectResult.toString());
                },
                numbers
        );
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
}
