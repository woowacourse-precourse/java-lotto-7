package lotto.view;

import lotto.constant.LottoPrintMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoRound;
import lotto.dto.IssuedLottoDTO;

public class LottoOutput {
    public static void printIssuedLotto(IssuedLottoDTO issuedLottoDTO) {
        LottoRound lottoRound = issuedLottoDTO.lottoRound();

        System.out.println(String.format(LottoPrintMessage.RESPONSE_MESSAGE_A_FORMAT, lottoRound.getLottosCount()));
        for (Lotto lotto : lottoRound.getLottos()) {
            System.out.println(lotto);
        }

        System.out.println();
    }
}
