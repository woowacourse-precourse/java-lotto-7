package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest extends NsTest {
    private static final OutputView outputView = new OutputView();

    @ParameterizedTest
    @DisplayName("로또 수 출력기능")
    @ValueSource(ints = {1, 30, 4, 7, 2})
    void displayLottoCount(int count) {
        outputView.displayPurchasedLottoCount(count);
        assertTrue(output().contains(count + "개를 구매했습니다."));
    }

    @Test
    @DisplayName("구매한 로또 번호 출력")
    void displayLottoTickets() {
        List<List<Integer>> lottoTickets = List.of(List.of(1,2,3,4,5,6));
        outputView.displayPurchasedLottoTickets(lottoTickets);
        assertTrue(output().contains("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    @DisplayName("구매한 로또 번호 낮은 번호부터 출력")
    void displayLottoTicketToSorted() {
        List<List<Integer>> lottoTickets = List.of(List.of(1,3,2,6,5,4));
        outputView.displayPurchasedLottoTickets(lottoTickets);
        assertTrue(output().contains("[1, 2, 3, 4, 5, 6]"));
    }

    @Override
    protected void runMain() {

    }
}