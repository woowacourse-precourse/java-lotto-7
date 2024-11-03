package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.dto.LottoTicketsDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStreamCaptor = new ByteArrayOutputStream();
        standardOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Nested
    class 로또_티켓_출력_테스트 {
        @Test
        void 구매한_로또_수량과_번호를_출력한다() {
            // given
            LottoTicketsDto tickets = new LottoTicketsDto(
                    3,
                    List.of(
                            List.of(1, 2, 3, 4, 5, 6),
                            List.of(7, 8, 9, 10, 11, 12),
                            List.of(13, 14, 15, 16, 17, 18)
                    )
            );

            // when
            outputView.printLottoTickets(tickets);
            String output = outputStreamCaptor.toString();

            // then
            assertThat(output)
                    .contains("""
                            3개를 구매했습니다.
                            [1, 2, 3, 4, 5, 6]
                            [7, 8, 9, 10, 11, 12]
                            [13, 14, 15, 16, 17, 18]
                            """);
        }
    }
}
