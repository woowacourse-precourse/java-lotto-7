package lotto.view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class BuyPriceViewTest {

    private final BuyPriceView buyPriceView = new BuyPriceView();
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


    @Test
    @DisplayName("구매 멘트가 제대로 나타나야함")
    void 구매_멘트가_의도대로_나와야함() {
        buyPriceView.printPriceInputView();
        String expectOutput = "구입금액을 입력해 주세요.";
        assertThat(expectOutput).isEqualTo(outputStreamCaptor.toString().trim());
    }

}