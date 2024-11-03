package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputServiceTest extends NsTest {

    private final InputService InputService = new InputService(new InputView());

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000"})
    void 구입_금액_입력_성공(String input) {
        setInput(input);
        PurchasePrice purchasePrice = InputService.readPurchasePrice();
        Assertions.assertThat(purchasePrice.getPurchasePrice()).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2.3,4,5,6", "a,1,2,3,4,5"})
    void 당첨번호_입력_문자_예외_실패(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains("문자가");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "0,1,2,3,4,5", "1,1,2,3,4,5"})
    void 당첨번호_입력_로또_변환_실패(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains("로또 번호는");
        });
    }

    @Test
    void 보너스번호_당첨번호와_중복_실패() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,6\n1");
            assertThat(output()).contains("당첨 번호에 없는");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6\n-1", "1,2,3,4,5,6\n0", "1,2,3,4,5,6\n70"})
    void 보너스번호_로또번호_범위_미만또는초과_실패(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains("사이여야");
        });
    }

    @Test
    void 당첨번호_보너스번호_변환성공() {
        setInput("1,2,3,4,5,6\n7");
        WinningLotto winningLotto = InputService.readWinningLotto();
        Assertions.assertThat(winningLotto.countMatches(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @Override
    protected void runMain() {
        InputService.readWinningLotto();
    }

    private void setInput(final String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}
