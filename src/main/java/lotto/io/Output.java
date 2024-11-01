package lotto.io;

import lotto.domain.Lotto;
import lotto.error.LottoErrorMessage;
import lotto.io.msg.LottoInquiryMessage;

import java.util.List;

public interface Output {

    void printInquiry(LottoInquiryMessage msg);

    void completePurchase(int num);

    void printLotto(Lotto lotto);

    void printWinningStatistics();

    void printErrorMsg(LottoErrorMessage msg);
}
