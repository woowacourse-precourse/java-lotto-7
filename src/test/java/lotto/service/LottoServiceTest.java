package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.PrizeNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setup() {
        lottoService = new LottoService();
    }

    @DisplayName("생성된 로또가 오름차순으로 정렬 되어있는지 테스트")
    @Test
    void 생성된_로또가_오름차순으로_정렬_되어있는지_테스트() {
        Lotto lotto = lottoService.createLotto();
        assertThat(lotto.getNumbers()).isSorted();
    }

    @DisplayName("로또 번호에 있는 보너스 번호 탐색 잘 하는지 테스트")
    @Test
    void 로또_번호에_있는_보너스_번호_탐색_잘_하는지_테스트() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        // prizeNumber bonusNumber는 0으로 초기화
        assertThat(lottoService.matchBonusNumber(lottoNumbers))
                .isEqualTo(false);
    }

    @DisplayName("로또 번호와 당첨 번호 일치하는 번호 개수 테스트")
    @Test
    void 로또_번호와_당첨_번호_일치하는_번호_개수_테스트() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        lottoService.updateWinningNumber(numbers, bonusNumber);

        //1위로 설정
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoService.matchPrizeNumbers(lotto);

        LottoResult lottoResult = lottoService.getLottoResult();
        assertThat(lottoResult.getLottoSameSize().get(0))
                .isEqualTo(1);
    }
}
