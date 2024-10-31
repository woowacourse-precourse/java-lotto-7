package lotto.domain;

import lotto.util.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.SequencedSet;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("당첨번호는 정해진 갯수만큼 입력받아야 한다.")
    @Test
    void 당첨번호_생성_테스트() {
        Parser parser = new Parser();
        String input = "1,2,3,4,5";
        SequencedSet<Integer> numbers = parser.ParseWinningNumber(input);

        Assertions.assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는");
    }
}