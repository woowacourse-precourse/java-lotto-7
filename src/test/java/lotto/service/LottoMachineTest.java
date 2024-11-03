package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또_생성_테스트() {
        String moneyAmount = "10000";
        System.setIn(new ByteArrayInputStream(moneyAmount.getBytes()));

        List<Lotto> lotteries = lottoMachine.getLotteries();
        Assertions.assertThat(lotteries).hasSize(10);
    }

    @Test
    void 로또_구매_장수_계산_테스트() {
        int number = lottoMachine.calculateNumberLotto(10000);
        Assertions.assertThat(number).isEqualTo(10);
    }

    @Test
    void 구입_금액_검증_테스트() {
        String moneyAmount = "10000";
        boolean result = lottoMachine.validateMoneyAmount(moneyAmount);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    void 구입_금액_검증_예외_테스트() {
        String moneyAmount = "999";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boolean result = lottoMachine.validateMoneyAmount(moneyAmount);

        Assertions.assertThat(result).isEqualTo(false);
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("[ERROR] 최소 구매 금액은 1000원부터 입니다.");
    }
}