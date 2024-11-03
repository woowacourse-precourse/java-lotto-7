package lotto.view;

import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketPurchaseViewTest {
    private final LottoTicketPurchaseView lottoTicketPurchaseView = new LottoTicketPurchaseView();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 8})
    @DisplayName("정확한 구매 개수가 출력되어야한다.")
    void 정확한_구매_개수가_출력_돼야함(Integer price) {
        lottoTicketPurchaseView.printPurchaseCount(price);
        String expect = price + "개를 구매했습니다.";
        assertThat(expect).isEqualTo(outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @MethodSource("provideLottoPurchaseList")
    @DisplayName("발급된 로또번호가 모두 출력되어야함")
    void 발급된_로또번호가_모두_출력되어야함(List<Lotto> lottoList) {
        lottoTicketPurchaseView.printLottoPurchase(lottoList);
        String expect = "[1, 2, 3, 4, 5, 6]";

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expect);
    }

    static Stream<Arguments> provideLottoPurchaseList() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));

        return Stream.of(
                Arguments.of(lottoList)
        );
    }

}