package lotto;

import lotto.type.WinType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("로또 금액으로 구매 횟수 구하기")
    @Test
    void getBuyCount() {
        // given
        int price = 12000;

        // when
        int buyCount = lottoMachine.getBuyCount(12000);

        // then
        assertThat(buyCount).isEqualTo(12);
    }

    @DisplayName("구매 횟수만큼 로또 발행")
    @Test
    void createLottoNumbersByCount() {
        // given
        int butCount = 3;

        // when
        List<Lotto> result = lottoMachine.createLottoNumbersByCount(butCount);

        // then
        assertThat(result).hasSize(3);
    }

    @DisplayName("일치하는 번호만큼 횟수 구하기")
    @Test
    void getMatchCount() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        int matchCount = lottoMachine.getMatchCount(lotto, winningNumbers);

        // then
        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 일치하면 2등 당첨인지 확인")
    @Test
    void matchBonusNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 2;
        User user = new User();

        // when
        lottoMachine.matchBonusNumber(lotto, bonusNumber, user);

        // then
        assertThat(user.getRecordWin())
                .containsEntry(WinType.SECOND, 1);
    }

    @DisplayName("로또 당첨 테스트")
    @Test
    void checkLottos() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                new Lotto(List.of(2, 3, 4, 5, 6, 40)),
                new Lotto(List.of(2, 3, 4, 5, 40, 45)),
                new Lotto(List.of(1, 2, 3, 4, 6, 45)),
                new Lotto(List.of(2, 3, 4, 32, 33, 34))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 40);
        int bonusNumber = 6;

        // when
        User user = lottoMachine.checkLottos(lottos, winningNumbers, bonusNumber, new User());

        // then
        assertThat(user.getRecordWin())
                .containsEntry(WinType.FIRST, 0)
                .containsEntry(WinType.SECOND, 2)
                .containsEntry(WinType.THIRD, 1)
                .containsEntry(WinType.FOURTH, 1)
                .containsEntry(WinType.FIFTH, 1);
    }
}