package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Member;
import lotto.enums.lotto.LottoMessage;
import lotto.enums.lotto.LottoRank;
import lotto.util.LottoParser;

public class OutputView {

    private final Member member = Member.getInstance();

    public void printPurchaseLottoCount() {
        int purchaseLottoCount = member.getIssuedLottos().size();
        System.out.println(
                LottoParser.parsingMessage(
                        LottoMessage.PRINT_OUTPUT_LOTTO_PURCHASE_COUNT,
                        purchaseLottoCount
                )
        );
    }

    public void printIssuedLottos() {
        List<Lotto> issuedLottos = member.getIssuedLottos();

        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printLottoResult() {
        System.out.println(LottoMessage.PRINT_OUTPUT_WINNING_RATE.getMessage());
        System.out.println(LottoMessage.PRINT_OUTPUT_LINE.getMessage());

        Map<LottoRank, Integer> lottoResults = member.getLottoResults();
        for (Entry<LottoRank, Integer> result : lottoResults.entrySet()) {
            System.out.println(LottoParser.parsingLottoResult(result.getKey(), result.getValue()));
        }
    }

    public void printReturnOfRate() {
        double returnOfRate = member.getReturnOfRate();
        System.out.println(
                LottoParser.parsingMessage(
                        LottoMessage.PRINT_OUTPUT_RETURN_OF_RATE,
                        returnOfRate
                )
        );
    }
}
