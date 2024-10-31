package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWallet;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    public void 로또지갑_출력() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoWallet lottoWallet = new LottoWallet(Arrays.asList(lotto1, lotto2));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        printBoughtTicketNumbers(lottoWallet);

        System.setOut(originalOut);

        String expectedOutput = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    private void printBoughtTicketNumbers(LottoWallet lottoWallet) {
        List<Lotto> lottos = lottoWallet.getLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
