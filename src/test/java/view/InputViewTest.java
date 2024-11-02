package view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class InputViewTest extends NsTest {

    @Test
    void 입력테스트() {
        InputView inputView = new InputView();
        assertSimpleTest(() -> {
            run("1234");
            assertThat(inputView.purchaseAmount()).isEqualTo("1234");
        });
    }

    @Test
    void 공백제거테스트() {
        InputView inputView = new InputView();
        assertSimpleTest(() -> {
            run(" 1234");
            assertThat(inputView.purchaseAmount()).isEqualTo("1234");
        });
    }

    @Test
    void 문자열_입력_테스트() {
        InputView inputView = new StubInputView();
        assertSimpleTest(() -> {
            run("abc");
            inputView.purchaseAmount();
            String output = output();
            assertThat(output).contains("ERROR");
        });
    }

    @Override
    protected void runMain() {

    }
}
