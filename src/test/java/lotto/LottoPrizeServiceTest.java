package lotto;

import lotto.domain.model.Lotto;
import lotto.domain.model.PrizeCategory;
import lotto.domain.model.WinningNumbers;
import lotto.domain.service.LottoPrizeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPrizeServiceTest {

    @Test
    @DisplayName("딩첨_등급_계산_성공")
    void 당첨_등급_계산_성공() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersList, 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoPrizeService prizeService = new LottoPrizeService();
        PrizeCategory prizeCategory = prizeService.calculatePrize(lotto, winningNumbers);

        assertEquals(PrizeCategory.FIRST, prizeCategory);
    }

    @Test
    @DisplayName("보너스_번호가_일치할_경우_2등으로_계산")
    void 보너스_번호가_일치할_경우_2등으로_계산() {
        List<Integer> winningNumbersList = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersList, 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        LottoPrizeService prizeService = new LottoPrizeService();
        PrizeCategory prizeCategory = prizeService.calculatePrize(lotto, winningNumbers);

        assertEquals(PrizeCategory.SECOND, prizeCategory);
    }
}
