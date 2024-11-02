package lotto.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.model.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("입력 문자열 정수로 변환 - 성공 테스트")
    void parseInputToInt_success() {
        // given
        String input = "1";

        // when
        Integer parsedInput = Parser.parseInputToInt(input);

        // then
        assertThat(parsedInput).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 왼쪽 공백 제거 - 성공 테스트")
    void parseInputToInt_trimLeftWhiteSpace() {
        // given
        String input = " 1";

        // when
        Integer parsedInput = Parser.parseInputToInt(input);

        // then
        assertThat(parsedInput).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 오른쪽 공백 제거 - 성공 테스트")
    void parseInputToInt_trimRightWhiteSpace() {
        // given
        String input = "1 ";

        // when
        Integer parsedInput = Parser.parseInputToInt(input);

        // then
        assertThat(parsedInput).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 양쪽 공백 제거 - 성공 테스트")
    void parseInputToInt_trimBothWhiteSpace() {
        // given
        String input = " 1 ";

        // when
        Integer parsedInput = Parser.parseInputToInt(input);

        // then
        assertThat(parsedInput).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 문자 - 예외 테스트")
    void parseInputToInt_string() {
        // given
        String input = "a";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 특수 문자 - 예외 테스트")
    void parseInputToInt_specialCharacter() {
        // given
        String input = "$";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 빈 값 - 예외 테스트")
    void parseInputToInt_emptyValue() {
        // given
        String input = "";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 공백 - 예외 테스트")
    void parseInputToInt_whiteSpace() {
        // given
        String input = " ";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 중간에 공백 - 예외 테스트")
    void parseInputToInt_internalWhiteSpace() {
        // given
        String input = "1 000";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수로 변환: 개행 문자 - 예외 테스트")
    void parseInputToInt_newLine() {
        // given
        String input = "\n";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환 - 성공 테스트")
    void parseInputsToIntList_success() {
        // given
        String inputs = "1,2,3";

        // when
        List<Integer> parsedInputs = Parser.parseInputsToIntList(inputs);

        // then
        assertThat(parsedInputs.get(0)).isEqualTo(1);
        assertThat(parsedInputs.get(1)).isEqualTo(2);
        assertThat(parsedInputs.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 왼쪽 공백 제거 - 성공 테스트")
    void parseInputsToIntList_trimLeftWhiteSpace() {
        // given
        String inputs = " 1, 2, 3";

        // when
        List<Integer> parsedInputs = Parser.parseInputsToIntList(inputs);

        // then
        assertThat(parsedInputs.get(0)).isEqualTo(1);
        assertThat(parsedInputs.get(1)).isEqualTo(2);
        assertThat(parsedInputs.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 오른쪽 공백 제거 - 성공 테스트")
    void parseInputsToIntList_trimRightWhiteSpace() {
        // given
        String inputs = "1 ,2 ,3 ";

        // when
        List<Integer> parsedInputs = Parser.parseInputsToIntList(inputs);

        // then
        assertThat(parsedInputs.get(0)).isEqualTo(1);
        assertThat(parsedInputs.get(1)).isEqualTo(2);
        assertThat(parsedInputs.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 양쪽 공백 제거 - 성공 테스트")
    void parseInputsToIntList_trimBothWhiteSpace() {
        // given
        String inputs = " 1 , 2 , 3 ";

        // when
        List<Integer> parsedInputs = Parser.parseInputsToIntList(inputs);

        // then
        assertThat(parsedInputs.get(0)).isEqualTo(1);
        assertThat(parsedInputs.get(1)).isEqualTo(2);
        assertThat(parsedInputs.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 문자 포함 - 예외 테스트")
    void parseInputsToIntList_includeString() {
        // given
        String inputs = "1,a,3";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputsToIntList(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 특수 문자 포함 - 예외 테스트")
    void parseInputsToIntList_includeSpecialCharacter() {
        // given
        String inputs = "1,$,3";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputsToIntList(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 빈 값 포함 - 예외 테스트")
    void parseInputsToIntList_includeEmptyValue() {
        // given
        String inputs = "1,,3";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputsToIntList(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 공백 포함 - 예외 테스트")
    void parseInputsToIntList_includeWhiteSpace() {
        // given
        String inputs = "1, ,3";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputsToIntList(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 중간에 공백 포함 - 예외 테스트")
    void parseInputsToIntList_includeInternalWhiteSpace() {
        // given
        String inputs = "1,2 3,4";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputsToIntList(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("입력 문자열 정수 리스트로 변환: 개행 문자 포함 - 예외 테스트")
    void parseInputsToIntList_includeNewLine() {
        // given
        String inputs = "1,\n,3";

        // when & then
        assertThatThrownBy(() -> Parser.parseInputsToIntList(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구매한 로또를 출력 형식에 맞게 포맷팅 - 성공 테스트")
    void formatLottoTickets() {
        // given
        Lotto firstLottoTicket = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondLottoTicket = Lotto.of(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto thirdLottoTicket = Lotto.of(Arrays.asList(13, 14, 15, 16, 17, 18));
        List<Lotto> lottoTickets = Arrays.asList(firstLottoTicket, secondLottoTicket, thirdLottoTicket);
        String joiner = ", ";

        // when
        List<String> formattedLottoTickets = Parser.formatLottoTickets(lottoTickets, joiner);

        // then
        assertThat(formattedLottoTickets.get(0)).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(formattedLottoTickets.get(1)).isEqualTo("[7, 8, 9, 10, 11, 12]");
        assertThat(formattedLottoTickets.get(2)).isEqualTo("[13, 14, 15, 16, 17, 18]");
    }
}
