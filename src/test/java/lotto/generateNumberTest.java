package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class generateNumberTest {
    @DisplayName("랜덤숫자 6개 생성")
    @Test
    void 랜덤_숫자6개_생성(){
        List<Integer> numbers = generateNumber.genreateNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }
}