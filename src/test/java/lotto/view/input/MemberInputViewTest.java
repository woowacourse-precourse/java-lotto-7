package lotto.view.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class MemberInputViewTest {

    private MemberInputView memberInputView;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void setUp() {
        memberInputView = new MemberInputView();
    }

    @Test
    void getPrice_TooLowPrice_RetriesUntilValid() {
        String userInput = "500\n1000\n";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        int price = memberInputView.getPrice();

        assertThat(price).isEqualTo(1000);
    }

}
