package lotto.view.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class MemberInputViewTest {

    private MemberInputView memberInputView;

    @BeforeEach
    void setUp() {
        memberInputView = new MemberInputView();
    }

    @Test
    @DisplayName("가격 단위가 맞지 않을때 다시 입력받아서 통과하는지의 여부")
    void getPrice_TooLowPrice_RetriesUntilValid() {
        String userInput = "2561\n1000\n";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        int price = memberInputView.getPrice();

        assertThat(price).isEqualTo(1000);
    }

}
