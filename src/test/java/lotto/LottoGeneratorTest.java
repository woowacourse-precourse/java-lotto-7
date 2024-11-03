package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.controller.LottoController;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    /*
    랜덤으로 생성된 로또에 대한 테스트
     */
    public static final int LOTTO_MONEY = 5000;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBERS = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    @Test
    void 로또_번호가_6개_생성되는지_확인() {
        LottoController lottoController = new LottoController(LOTTO_MONEY);
        List<Integer> lottoNumbers = lottoController.generateRandomLottoNumbers();

        // 로또 번호가 6개인지 확인
        assertThat(lottoNumbers).hasSize(LOTTO_NUMBER_COUNT);
    }

    @Test
    void 로또_번호가_1부터_45사이인지_확인() {
        LottoController lottoController = new LottoController(LOTTO_MONEY);
        List<Integer> lottoNumbers = lottoController.generateRandomLottoNumbers();

        // 모든 숫자가 1~45 범위 내에 있는지 확인
        assertThat(lottoNumbers).allMatch(num -> num >= LOTTO_START_NUMBER && num <= LOTTO_END_NUMBERS);
    }

    @Test
    void 로또_번호에_중복된_숫자가_없는지_확인() {
        LottoController lottoController = new LottoController(LOTTO_MONEY);
        List<Integer> lottoNumbers = lottoController.generateRandomLottoNumbers();

        // 중복된 숫자가 없는지 확인
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

}
