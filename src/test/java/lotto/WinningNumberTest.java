package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Controller 클래스 테스트")
public class WinningNumberTest {

    @Test
    void 입력_당첨_번호를_콤마를_기준으로_분리() {
        List<String> expectedList = Arrays.asList("1", "2", "3", "4", "5", "6");

        //given
        String input = "1,2,3,4,5,6";

        //when
        List<String> winnigNumbers = LottoController.splitByComma(input);

        //then
        assertEquals(expectedList, winnigNumbers);
    }
}
