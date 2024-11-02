package view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class InputViewTest extends NsTest {

    @Test
    void 구매_입력테스트() {
        InputView inputView = new InputView();
        assertSimpleTest(() -> {
            run("1234");
            assertThat(inputView.purchaseAmount()).isEqualTo(1234);
        });
    }

    @Test
    void 구매_공백제거테스트() {
        InputView inputView = new InputView();
        assertSimpleTest(() -> {
            run(" 1234");
            assertThat(inputView.purchaseAmount()).isEqualTo(1234);
        });
    }

    @Test
    void 구매_문자열_입력_에러_테스트() {
        InputView inputView = new StubInputView();
        assertSimpleTest(() -> {
            run("abc");
            inputView.purchaseAmount();
            String output = output();
            assertThat(output).contains("ERROR");
        });
    }

    @Test
    void 로또가격_에러_테스트() {
        InputView inputView = new StubInputView();
        assertSimpleTest(() -> {
            run("1234");
            inputView.purchaseAmount();
            String output = output();
            assertThat(output).contains("ERROR");
        });
    }
    @Override
    protected void runMain() {

    }
}
