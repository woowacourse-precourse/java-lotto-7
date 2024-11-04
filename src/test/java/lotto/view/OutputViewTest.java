package lotto.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewTest {

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

    static Stream<Arguments> printNumberOfPurchaseTestCases() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        return Stream.of(
                Arguments.of(1, lottos)
        );
    }
    @ParameterizedTest
    @MethodSource("printNumberOfPurchaseTestCases")
    void printNumberOfPurchaseTest(int purchase, List<Lotto> lottos) {
        OutputView outputView = new OutputView();
        outputView.printNumberOfPurchase(purchase, lottos);
        assertThat(outputStreamCaptor.toString().trim()).contains(
                "1개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]");
    }

    static Stream<Arguments> printStatisticsTestCases() {
        return Stream.of(
                Arguments.of(3,"3개를 구매했습니다."),
                Arguments.of(2,"2개를 구매했습니다.")
        );
    }
    @ParameterizedTest
    @MethodSource("printStatisticsTestCases")
    void printStatisticsTest(int purchase, String expected) {
    }
}
