package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("1, 2를 ,로 split했을 때 1과 2로 분리된다.")
    void splitStringByDelimiter() {
        String number1 = "1";
        String number2 = "2";
        String delimiter = ",";
        String testString = number1 + delimiter + number2;

        String[] splittedString = testString.split(delimiter);

        assertThat(splittedString).contains(number1, number2);
        assertThat(splittedString).contains(number2, number1);
    }

    @Test
    @DisplayName("1, 2를 ,로 split했을 때 1과 2로 순서대로 분리된다.")
    void splitStringByDelimiterInOrder() {
        String number1 = "1";
        String number2 = "2";
        String delimiter = ",";
        String testString = number1 + delimiter + number2;

        String[] splittedString = testString.split(delimiter);

        assertThat(splittedString).containsExactly(number1, number2);
    }

    @Test
    @DisplayName("1,을 ,로 split했을 때 1만으로 분리된다.")
    void splitOnlyOneStringByDelimiter() {
        String number = "1";
        String delimiter = ",";
        String testString = number + delimiter;

        String[] splittedString = testString.split(delimiter);

        assertThat(splittedString).containsExactly(number);
    }

    @Test
    @DisplayName("(1,2)에서 1번째~3번째 인덱스를 substring했을 때 1,2로 분리된다.")
    void subStringFromStartIndexToEndIndex() {
        String testString = "(1,2)";
        int startIndex = 1;
        int endIndex = 3;

        String resultString = testString.substring(startIndex, endIndex + 1);

        assertThat(resultString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc에서 0~2번째 위치의 문자를 각각 가져온다.")
    void extractCharacterFromString() {
        String testString = "abc";

        assertThat(testString.charAt(0)).isEqualTo('a');
        assertThat(testString.charAt(1)).isEqualTo('b');
        assertThat(testString.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("abc에서 3번째 위치의 문자를 가져오면 예외를 반환한다..")
    void failIfExtractCharacterOutOfBoundsFromString() {
        String testString = "abc";

        assertThatThrownBy(() -> testString.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
