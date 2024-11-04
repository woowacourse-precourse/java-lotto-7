package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    }
}
