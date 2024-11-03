package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTransformTest {

    List<List<Integer>> lottoNumbers = new ArrayList<>();
    List<Integer> winningNumbers = new ArrayList<>();
    LottoTransform lottoTransform = new LottoTransform(lottoNumbers, winningNumbers);

    @Test
    void 문자열_입력을_정렬된_당첨번호로_변환한다() {
        String input = "3,2,1,6,5,4";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        lottoTransform.inputToWinningNumbers(input);
        assertThat(winningNumbers).isEqualTo(expected);
    }

    @Test
    void 로또_구매_금액을_입력받아_로또_개수를_반환한다() {
        String input = "5000";
        int expected = 5;

        int result = lottoTransform.getLottoCount(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 입력_개수만큼_로또_생성() {
        int lottoCount = 5;

        lottoTransform.createLottoNumbers(lottoCount);
        assertThat(lottoNumbers.size()).isEqualTo(lottoCount);
    }

    @Test
    void 로또_번호_생성() {
        List<Integer> lottoNumber = lottoTransform.createRandomNumbers();
        assertThat(lottoNumber.size()).isEqualTo(6);
    }
}