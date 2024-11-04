package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 로또_생성_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        int lottoAmount = 10;
        List<Lotto> lotteries = lottoMachine.generateLotto(lottoAmount);
        Assertions.assertThat(lotteries).hasSize(10);
    }

    @Test
    void 로또_구매_장수_계산_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        int number = lottoMachine.calculateNumberLotto(10000);
        Assertions.assertThat(number).isEqualTo(10);
    }
}