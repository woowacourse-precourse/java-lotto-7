package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @DisplayName("숫자들을 출력한다")
    @Test
    void 숫자들을_출력한다() {
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        String expect = "[1, 2, 4]\r\n";

        OutputView.printNumbers(numbers);
        assertEquals(outputStream.toString(), expect);
    }

    @DisplayName("로또들을 출력한다")
    @Test
    void 로또들을_출력한다() {
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        String expect = "2개를 구매했습니다.\r\n[1, 2, 3, 4, 5, 6]\r\n[7, 8, 9, 10, 11, 12]\r\n";
        OutputView.printLottos(lottos);
        assertEquals(outputStream.toString(), expect);

    }
}