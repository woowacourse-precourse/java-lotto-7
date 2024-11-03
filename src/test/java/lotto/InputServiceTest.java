package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.io.InputService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputServiceTest {
    @DisplayName("입력 받은 당첨 번호를 쉼표 기준으로 구분한다.")
    @Test
    void 입력_받은_당첨_번호를_쉼표_기준으로_구분한다() {
        // given
        InputService inputService = new InputService();
        String inputNumbers = "1, 2, 3, 4, 5, 6";

        // when
        List<String> splitNumbers = inputService.splitByComma(inputNumbers);

        // then
        for (int i = 0; i < splitNumbers.size(); i++) {
            assertThat(splitNumbers.get(i)).isEqualTo(String.valueOf(i + 1));
        }
        assertThat(splitNumbers).isEqualTo(Arrays.asList("1", "2", "3", "4", "5", "6"));
    }

    @DisplayName("문자 리스트를 정수 리스트로 변환한다.")
    @Test
    void 문자_리스트를_정수_리스트로_변환한다() {
        // given
        InputService inputService = new InputService();
        List<String> splitNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        // when
        List<Integer> integerList = inputService.toIntegerList(splitNumbers);

        // then
        assertThat(integerList).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
