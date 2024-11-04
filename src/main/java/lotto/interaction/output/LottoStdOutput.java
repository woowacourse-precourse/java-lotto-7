package lotto.interaction.output;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.LottoStatistics;
import lotto.interaction.output.view.LottoStringView;

public class LottoStdOutput implements LottoOutput{
    @Override
    public void printToInputPurchaseMoney() {
        System.out.print("구매금액을 입력해 주세요.\n");
    }

    @Override
    public void printToInputWinningNumber() {
        System.out.print("\n당첨 번호를  입력해 주세요.\n");
    }

    @Override
    public void printToInputBonusNumber() {
        System.out.print("\n보너스 번호를 입력해 주세요.\n");
    }

    @Override
    public void printPurchasedLotto(List<Lotto> lottoList) {
        String numberOfLotto = LottoStringView.numberOfLotto(lottoList);
        System.out.print(numberOfLotto);
        for (Lotto lotto : lottoList) {
            String lottoNumberView = LottoStringView.lottoNumberList(lotto.getNumbers());
            System.out.print(lottoNumberView);
        }
    }

    @Override
    public void printWinningStatistics(Map<LottoResult, Integer> resultMap, double rate) {
        List<Entry<LottoResult, Integer>> entries = LottoStatistics.sortResultMap(resultMap);
        System.out.print("\n당첨 통계\n");
        System.out.print("---\n");
        for (Entry<LottoResult, Integer> entry : entries) {
            String lottoNumberView = LottoStringView.lottoResultEntry(entry);
            System.out.print(lottoNumberView);
        }
        String rateOfReturn = LottoStringView.rateOfReturn(rate);
        System.out.print(rateOfReturn);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.printf("\n%s\n", message);
    }
}
