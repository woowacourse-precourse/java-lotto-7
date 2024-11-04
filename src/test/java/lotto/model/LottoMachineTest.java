package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 리스트를 입력 개수만큼 생성한다.")
    void generateLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        int lottoCount = 3;

        Lottos lottos = lottoMachine.generateLottos(lottoCount);

        assertThat(lottos.getLottos()).hasSize(lottoCount);
    }

    @Test
    @DisplayName("로또 결과를 반환한다.")
    public void getLottoResult() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = Lottos.of(List.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6))));
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(4, 5, 6, 9, 10, 11));
        int bonusNumber = 12;

        // when
        LottoResult result = lottoMachine.getLottoResult(lottos, winningNumbers, bonusNumber);
        HashMap<Rank, Integer> map = settingMap();
        LottoResult lottoResult = LottoResult.of(map);

        // then
        assertThat(result).isEqualTo(lottoResult);
    }

    private static HashMap<Rank, Integer> settingMap() {
        HashMap<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIRST_PLACE, 0);
        map.put(Rank.SECOND_PLACE, 0);
        map.put(Rank.THIRD_PLACE, 0);
        map.put(Rank.FOURTH_PLACE, 0);
        map.put(Rank.FIFTH_PLACE, 1);
        return map;
    }

}