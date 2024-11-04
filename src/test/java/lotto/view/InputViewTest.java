package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private final InputStream originalIn = System.in;   // 원래의 System.in 저장

    @AfterEach
    void restoreSystemIn() {
        // 각 테스트 이후 원래 System.in 복원 및 Scanner 종료
        System.setIn(originalIn);
        Console.close();    // Scanner를 종료하여 초기화
    }

    @Test
    void 입력_값_없을시_에러_발생() {
        // given
        String invalidInput = "\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));

        // when, then
        assertThatThrownBy(InputView::getPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 없습니다.");
    }
}
