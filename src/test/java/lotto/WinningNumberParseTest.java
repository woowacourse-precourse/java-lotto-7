package lotto;

import lotto.parser.WinningNumberParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberParseTest {

    @Nested
    class 당첨_번호_파싱_테스트{
        private WinningNumberParser parser;

        @BeforeEach
        void setUp(){
            parser = new WinningNumberParser();
        }

        @DisplayName("콤마를 기준으로 입력을 파싱한다")
        @ParameterizedTest()
        @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,6,", "1 ,2 ,3,4, 5, 6            ,"})
        void 당첨번호_콤마기준_파싱(String input){
            List<Integer> parsedInput = parser.parseWinningNumber(input);
            assertThat(parsedInput).containsExactly(1,2,3,4,5,6);
        }
    }
}
