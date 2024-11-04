package lotto.view;


import lotto.domain.LottoTicket;
import lotto.domain.LottoResult;

public interface OutputView {
    void printLottoTicket(LottoTicket lottoTicket);

    void printWinningStatistics(LottoResult lottoResult);

    void printReturnOnInvestment(double returnOnInvestment);
    void printErrorMessage(String errorMessage);
}
