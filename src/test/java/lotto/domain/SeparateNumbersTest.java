package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SeparateNumbersTest {

    private final SeparateNumbers separateNumbers = new SeparateNumbers();

    @DisplayName("입력 받은 번호를 쉼표(,)를 기준으로 자르는 기능 테스트")
    @Test
    void 입력받은_번호가_잘려서_리스트로_반환되어야_한다() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = separateNumbers.separateInputNumbers(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

}
