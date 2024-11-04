package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("로또 발행 기능 테스트")
    @Test
    void generateLottoTest() {
        Lottos generatedLottos = lottoService.generateLottos(8);
        assertEquals(generatedLottos.getLottos().size(), 8);
    }

    @DisplayName("당첨번호와 발행한 한장의 로또와 맞은 개수 확인하는 기능 테스트")
    @Test
    void countMatchingNumbersTest() {
        Lotto userLotto = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
        Lotto winningNumbers = new Lotto(new ArrayList<>(List.of(1,2,3,30,31,32)));
        int matchedNumbersCount = lottoService.countMatchingNumbers(userLotto, winningNumbers);

        assertEquals(matchedNumbersCount, 3);
    }
}
