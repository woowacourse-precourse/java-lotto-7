package lotto.view;

import lotto.domain.Member;
import lotto.enums.lotto.LottoMessage;
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

    // TODO: 당첨내역을 출력한다.

    // TODO: 수익률을 출력한다.
}
