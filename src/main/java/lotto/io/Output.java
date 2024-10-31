package lotto.io;

import lotto.error.LottoErrorMessage;

public interface Output {

    void printInquiry(LottoOutputMessage msg);

    void printErrorMsg(LottoErrorMessage msg);
}
