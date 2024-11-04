package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRound;
import lotto.dto.IssuedLottoDTO;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

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

        LottoInput.getWinNumbers();
    }
}
