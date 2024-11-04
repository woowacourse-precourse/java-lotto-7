package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRound;
import lotto.dto.IssuedLottoDTO;
import lotto.dto.LottoWinStatisticDTO;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int issueCount = LottoInput.getIssueCount().count();

        LottoRound lottoRound = new LottoRound();
        for ( int i = 0; i < issueCount; i++ ) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoRound.addLotto(lotto);
        }
        LottoOutput.printIssuedLotto(new IssuedLottoDTO(lottoRound));

//        LottoInput.getWinNumbers();
        List<Integer> a = new ArrayList<>();
        for ( int i = 0; i < 6; i++ ) {
            a.add(i);
        }
        LottoOutput.printWinStatistic(new LottoWinStatisticDTO(a, 20.0001f));
    }
}
