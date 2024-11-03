package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.domain.Lottoes;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @DisplayName("문자열 출력 테스트")
    @Test
    void printStringLineFeed() {
        //given
        String str = "print";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        //when
        outputView.printStringLineFeed(str);

        //then
        assertThat(outputStream.toString()).isEqualTo(str.concat("\n"));

        //원래의 System.out으로 변경
        System.setOut(originalOut);
    }

    @DisplayName("로또 목록 출력 테스트")
    @Test
    void printLottoesStatus() {
        //given
        Lottoes lottoes = Lottoes.from(Money.from("2000"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        //when
        outputView.printLottoesStatus(lottoes);

        //then
        String output = outputStream.toString();
        assertThat(output.trim()).matches("""
                2개를 구매했습니다.
                \\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+]
                \\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+]""");

        //원래의 System.out으로 변경
        System.setOut(originalOut);
    }
}