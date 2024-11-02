package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("6개의 무작위 숫자를 생성한다.")
    @Test
    void 무작위_로또를_생성한다(){
        LottoRepository lottoRepository = new LottoRepository();
        int lottoCount = 6;
        int bonusNumber = 1;
        LottoGame lottoGame = new LottoGame(lottoRepository);
        lottoGame.setDetails(new Lotto(List.of(1,2,3,4,5,6)), bonusNumber);
        lottoGame.generateLotto();

        assertThat(lottoRepository.getLottos()).hasSize(5);
    }

    @DisplayName("로또는 오름차순 정렬된다")
    @Test
    void 로또는_오름차순_정렬된다(){
        LottoRepository lottoRepository = new LottoRepository();
        int bonusNumber = 1;
        LottoGame lottoGame = new LottoGame(lottoRepository);
        lottoGame.setDetails(new Lotto(List.of(11,2,3,4,5,6)), bonusNumber);
        lottoGame.generateLotto();

        List<Lotto> savedLottos = lottoRepository.getLottos();
        List<Integer> generatedNumbers = savedLottos.get(0).getNumbers();

        boolean isSorted = true;
        for (int i = 0; i < generatedNumbers.size() - 1; i++) {
            if (generatedNumbers.get(i) > generatedNumbers.get(i + 1)) {
                isSorted = false;
                break;
            }
        }
        assertTrue(isSorted, "로또 번호는 오름차순으로 정렬되어야 합니다.");
    }


}
