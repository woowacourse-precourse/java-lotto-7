package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoProcess;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoViewTest {


    @Test
    void 로또_번호_출력() {
        LottoProcess lottoProcess = new LottoProcess();
        List<Integer> randomLottoNumbers = lottoProcess.getRandomLottoNumbers();
        Lotto lotto = new Lotto(randomLottoNumbers);
        LottoView lottoView = new LottoView();
        lottoView.outputLottoNumbers(lotto);

    }

}