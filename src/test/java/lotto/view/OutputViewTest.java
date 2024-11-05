package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.View;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView=new OutputView();
    @Test
    void 구매한_로또들_출력(){
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Lotto> lottos=new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));

        outputView.printLottos(lottos);

        assertThat(outputStream.toString()).isEqualTo("2개를 구매했습니다.\n"+
                "[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 6]\n");

        System.setOut(originalOut);
    }


}
