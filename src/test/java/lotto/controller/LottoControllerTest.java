package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoControllerTest {
    private final InputStream inputStream = System.in;
    private LottoController lottoController;

    @BeforeEach
    public void setUpStreams() {
        lottoController = new LottoController();
    }

    private void provideInput(String input) {
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInputStream);
    }

    @Test
    public void 한번에_정상적인_구입_금액이_들어온_경우() {
        provideInput("10000\n");

        int purchaseAmount = lottoController.getPurchaseAmount();
        assertEquals(10, purchaseAmount);
    }

    @Test
    public void 비정상적인_값들_이후_정상적인_값이_들어온_경우() {
        provideInput("abc\n-1000\n1000\n");

        int purchaseAmount = lottoController.getPurchaseAmount();
        assertEquals(1, purchaseAmount);
    }

    // 담첨 번호 테스트 -----------

    @Test
    public void 한번에_정상적인_당첨_번호가_들어온_경우() {
        provideInput("1,2,3,4,5,6\n");

        Lotto winningNumbers = lottoController.getWinningNumbers();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winningNumbers.getNumbers());
    }

    @Test
    public void 비정상적인_당첨_번호_이후_정상적인_당첨_번호가_들어욘_경우() {
        provideInput("1,2,3,4,5,a\n1,2,3,4,5,46\n1,2,3,4,5,6");

        Lotto winningNumbers = lottoController.getWinningNumbers();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winningNumbers.getNumbers());
    }

    // 보너스 번호 테스트 -----------

    @Test
    public void 한번에_정상적인_보너스_번호가_들어온_경우() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(winningNumbersList);
        provideInput("15\n");

        int bonusNumber = lottoController.getBonusNumber(winningNumbers);
        assertEquals(15, bonusNumber);
    }

    @Test
    public void 비정상적인_보너스_번호_이후_정상적인_보너스_번호가_들어욘_경우() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(winningNumbersList);
        provideInput("a\n46\n15");

        int bonusNumber = lottoController.getBonusNumber(winningNumbers);
        assertEquals(15, bonusNumber);
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(inputStream);
    }
}
