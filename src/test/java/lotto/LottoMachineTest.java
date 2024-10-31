package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.model.LottoMachine;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    public void 로또번호생성테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lottoNumbers = lottoMachine.genearteLottos();
        // 로또 갯수 확인
        assertEquals(6, lottoNumbers.size(), "로또 번호는 6개여야 합니다.");
        // 1~45 사이의 범위값인지
        assertTrue(lottoNumbers.stream().allMatch(num -> num >= 1 && num <= 45), "로또번호는 1~45사이의 값만 가능합니다");
        // 중복 확인
        assertEquals(6, lottoNumbers.stream().distinct().count(),
                "로또 번호는 중복되지 않아야 합니다.");
    }
}
