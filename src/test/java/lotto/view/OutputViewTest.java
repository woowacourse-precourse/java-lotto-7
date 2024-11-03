package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private OutputView view;

    @BeforeEach
    void init(){
        view = new OutputView();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void reset(){
        System.setOut(System.out);
    }

    @Test
    void 발행_로또_내역_출력_테스트(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(2,3,4,5,6,7)));

        view.displayLotto(lottos);

        Assertions.assertThat(outputStream.toString().trim()).contains(
                "[1, 2, 3, 4, 5, 6]",
                "[2, 3, 4, 5, 6, 7]"
        );

    }

    @Test
    void 당첨_내역_출력_테스트(){
        WinningResult winningResult = new WinningResult();

        winningResult.put(1);
        winningResult.put(4);
        winningResult.put(2);
        view.displayRank(winningResult);

        Assertions.assertThat(outputStream.toString().trim()).contains(
                "6개 일치 (2,000,000,000원) = 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) = 1개",
                "4개 일치 (50,000원) = 1개"
        );
    }

}