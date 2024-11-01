package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.List;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    private LottoMachine lottoMachine = LottoMachine.getInstance();

    @Test
    void 갯수만큼_로또생성_출력() {
        int lottoCount = 3;
        lottoMachine.createLottos(3);
        lottoMachine.printAllLottoNumbers();
        assertEquals(lottoCount, lottoMachine.getLottos().size());
    }
}
