package lotto.view;

import java.util.List;
import lotto.LottoNumber;
import lotto.WinningRecipe;

public interface OutputView {

    void printAskMoney();

    void printLottoNumber(final List<LottoNumber> lottoNumbers);

    void printAskWinningNumber();

    void printAskBonusNumber();

    void printWinningResultTitle();

    void printWinningResult(final List<WinningRecipe> winningRecipes);

    void printProfitResult(final double ratio);

}
