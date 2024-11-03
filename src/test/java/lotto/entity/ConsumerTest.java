package lotto.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerTest {

    private Consumer consumer;

    @BeforeEach
    public void setUp() {
        String input = "5000\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        consumer = new Consumer();
    }

    @Test
    public void 테스트_로또_구매금액_입력_및_티켓_생성() {
        assertEquals(5000, consumer.getTotalLottoCost());
        assertEquals(5, consumer.getLottoCount());

        List<List<Integer>> lottoTickets = consumer.getLottoTickets();
        assertEquals(5, lottoTickets.size());

        for (List<Integer> ticket : lottoTickets) {
            assertEquals(6, ticket.size());
            for (Integer number : ticket) {
                assertEquals(true, number >= 1 && number <= 45);
            }
        }
    }
}
