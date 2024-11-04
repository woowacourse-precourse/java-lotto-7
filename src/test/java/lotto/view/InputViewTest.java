package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputView inputView = new InputView();
    private ByteArrayOutputStream output;

    @BeforeEach
    void restoreInputStream() {
        System.setIn(System.in);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @BeforeEach
    void setup() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restore() {
        System.setOut(System.out);
        output.reset();
        Console.close();
    }

    @Test
    void 당첨_번호와_보너스_번호가_중복되는_경우() {
        // given
        LottoDto winningLotto = new LottoDto(List.of(1, 2, 3, 4, 5, 6));
        String[] args = {"1", "7"};
        final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        // when
        inputView.scanBonusNumber(winningLotto);

        // then
        Assertions.assertThat(output.toString())
                .contains("당첨 번호에 이미 포함된 번호입니다. 중복되지 않게 입력해주세요.");
    }
}