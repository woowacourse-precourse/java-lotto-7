package lotto.application.view.output;

import lotto.application.dto.Result;
import lotto.application.model.MyLotto;

public interface OutputView {

  void printEmptyLine();

  void printErrorMessage(IllegalArgumentException exception);

  void printPurchasedMessage(MyLotto myLotto);

  void printPurchasedMyLottoList();

  void printWinningStatistics();

  void printSeparator();

  void printWinningStatisticsSummary(Result result);
}
