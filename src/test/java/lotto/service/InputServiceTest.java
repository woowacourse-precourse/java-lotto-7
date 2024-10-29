package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

class InputServiceTest {

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

    private void setInput(final String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
