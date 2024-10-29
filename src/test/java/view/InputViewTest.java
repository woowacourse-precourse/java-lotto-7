package view;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class InputViewTest extends NsTest{

    @Test
    void 입력테스트(){
        InputView inputView = new InputView();
        assertSimpleTest(()->{
            run("1234");
            assertThat(inputView.purchaseAmount()).isEqualTo("1234");
        });
    }

    @Test
    void 공백제거테스트(){
        InputView inputView = new InputView();
        assertSimpleTest(()->{
            run(" 1234");
            assertThat(inputView.purchaseAmount()).isEqualTo("1234");
        });
    }

    @Override
    protected void runMain() {

    }
}
