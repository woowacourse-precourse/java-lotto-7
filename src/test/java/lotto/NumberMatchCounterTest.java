package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.enums.Prize;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoArchive;
import lotto.model.NumberMatchCounter;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberMatchCounterTest {

    @DisplayName("일치하는 로또가 없어 개수가 0인 경우 테스트")
    @Test
    void 일치하는_로또가_없어_개수가_0인_경우_테스트() {
        //given
        LottoArchive lottoArchive = new LottoArchive(List.of(new Lotto(List.of(11, 12, 13, 14, 15, 16))));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber.getNumbers());
        //when
        NumberMatchCounter numberMatchCounter = new NumberMatchCounter(lottoArchive, winningNumber, bonusNumber);
        Map<Prize, Long> map = numberMatchCounter.getPrizeCounts();

        //then
        for (Prize prize : Prize.values()) {
            assertThat(map.get(prize)).isEqualTo(0);
        }

    }

    @DisplayName("일치하는 로또가 있을 경우 테스트")
    @Test
    void 일치하는_로또가_있을_경우_테스트() {
        //given
        LottoArchive lottoArchive = new LottoArchive(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber.getNumbers());
        //when
        NumberMatchCounter numberMatchCounter = new NumberMatchCounter(lottoArchive, winningNumber, bonusNumber);
        Map<Prize, Long> map = numberMatchCounter.getPrizeCounts();

        //then
        assertThat(map.get(Prize.FIRST)).isEqualTo(1);
    }
}
