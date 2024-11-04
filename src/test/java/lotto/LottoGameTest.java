package lotto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("구입 금액이 정상일 경우 로또가 생성된다.")
    @Test
    void 정상적인_구입_금액이면_로또가_생성된다() {
        LottoGame lottoGame = new LottoGame(4000);
        assertThat(lottoGame.getPurchasedLottos()).hasSize(4);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어야 한다.")
    @Test
    void 로또_번호는_오름차순으로_정렬되어야_한다() {
        Lotto lotto = new Lotto(List.of(5, 3, 1, 2, 4, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨번호가_6개가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new WinNumbers(new String[]{"1", "2", "3", "4", "5"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호에 범위를 넘어선 숫자가 있는 경우 예외가 발생한다.")
    @Test
    void 당첨번호에_범위_벗어난_숫자가_포함된_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new WinNumbers(new String[]{"0", "2", "3", "4", "5", "46"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("수익률 계산이 정확한지 확인한다.")
    @Test void 수익률_계산_테스트() {
        LottoGame lottoGame = new LottoGame(8000);
        WinNumbers winningNumbers = new WinNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        int bonusNumber = 7;
        List<Lotto> mockLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                new Lotto(List.of(1, 7, 8, 9, 10, 11)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)) );
        lottoGame.getPurchasedLottos().clear(); lottoGame.getPurchasedLottos().addAll(mockLottos);

        lottoGame.calculateResults(winningNumbers, bonusNumber);

        double expectedYield = (2000000000 + 30000000 + 1500000 + 50000 + 5000) / 8000.0 * 100; expectedYield = Math.round(expectedYield * 10) / 10.0;
        assertThat(lottoGame.calculateYield()).isEqualTo(expectedYield);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
