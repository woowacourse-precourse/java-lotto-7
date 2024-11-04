package lotto.view;

import lotto.constant.LottoPrintMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoRound;
import lotto.dto.IssuedLottoDTO;
import lotto.dto.LottoWinStatisticDTO;

import java.util.List;

public class LottoOutput {
    public static void printIssuedLotto(IssuedLottoDTO issuedLottoDTO) {
        LottoRound lottoRound = issuedLottoDTO.lottoRound();

        System.out.println(String.format(LottoPrintMessage.RESPONSE_MESSAGE_ISSUE_COUNT_FORMAT, lottoRound.getLottosCount()));
        for (Lotto lotto : lottoRound.getLottos()) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public static String prettyPrint(int value) {
        String formattedPart = "";
        if ( value > 1000 ) {
            formattedPart = prettyPrint(value / 1000);
            value %= 1000;
            formattedPart += ",";
        }

        String formattingPart = Integer.toString(value);
        if (!formattedPart.isEmpty()) {
            if (formattingPart.length() < 2) formattingPart = "0" + formattingPart;
            if (formattingPart.length() < 3) formattingPart = "0" + formattingPart;
        }
        return formattedPart + formattingPart;
    }
}
