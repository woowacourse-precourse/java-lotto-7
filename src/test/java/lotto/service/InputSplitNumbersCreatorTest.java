package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputSplitNumbersCreatorTest {

    private NumbersCreator inputSplitNumbersCreator;

    @DisplayName("입력 숫자들 생성기는 입력을 쉼표로 구분해 숫자들로 변환해준다.")
    @MethodSource("provideInputAndExpectedNumbers")
    @ParameterizedTest
    void 입력_분리_숫자_생성기가_숫자들_생성_성공(String input, List<Integer> expectedNumbers) {
        inputSplitNumbersCreator = new InputSplitNumbersCreator(input);

        assertThat(inputSplitNumbersCreator.create()).isEqualTo(expectedNumbers);
    }

    @DisplayName("입력 숫자들 생성기는 입력 중 int 범위를 초과한 값이 있으면 예외가 발생한다")
    @Test
    void 입력_분리_숫자_생성기가_숫자들_생성_실패() {
        inputSplitNumbersCreator = new InputSplitNumbersCreator("1, 2, 3, 4, 5, 2147483648");

        assertThatThrownBy(() -> inputSplitNumbersCreator.create())
                .isInstanceOf(IllegalArgumentException.class)
                ;
    }

    static Stream<Arguments> provideInputAndExpectedNumbers() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("1 ,2 ,3 ,4 ,5 ,6 ", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(" 1, 2, 3, 4, 5, 6", List.of(1, 2, 3, 4, 5, 6))
        );
    }

}
