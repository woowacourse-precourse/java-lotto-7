package lotto.controller;

import lotto.model.InputParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoControllerTest {
    private final InputStream inputStream = System.in;
    private LottoController lottoController;
    private InputParser inputParser;

    @BeforeEach
    public void setUpStreams() {
        lottoController = new LottoController();
        inputParser = new InputParser();
    }

    private void provideInput(String input) {
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInputStream);
    }

    @Test
    public void 한번에_정상적인_구입_금액이_들어온_경우() {
        provideInput("10000\n");

        int purchaseAmount = lottoController.getPurchaseAmount(inputParser);
        assertEquals(10000, purchaseAmount);
    }

    @Test
    public void 비정상적인_값들_이후_정상적인_값이_들어온_경우() {
        provideInput("abc\n-1000\n1000\n");

        int purchaseAmount = lottoController.getPurchaseAmount(inputParser);
        assertEquals(1000, purchaseAmount);
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(inputStream);
    }
}
