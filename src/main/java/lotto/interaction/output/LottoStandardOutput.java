package lotto.interaction.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.LottoStatistics;
import lotto.interaction.output.view.LottoStringView;

public class LottoStandardOutput implements LottoOutput{
    private final BufferedWriter bw;
    public LottoStandardOutput(BufferedWriter bw) {
        this.bw = bw;
    }

    @Override
    public void printToInputPurchaseMoney() {
        try {
            bw.write("구매금액을 입력해 주세요.\n");
            bw.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void printToInputWinningNumber() {
        try {
            bw.write("\n당첨 번호를  입력해 주세요.\n");
            bw.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void printToInputBonusNumber() {
        try {
            bw.write("\n보너스 번호를 입력해 주세요.\n");
            bw.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void printPurchasedLotto(List<Lotto> lottoList) {
        try {
            String numberOfLotto = LottoStringView.numberOfLotto(lottoList);
            bw.write(numberOfLotto);
            for (Lotto lotto : lottoList) {
                String lottoNumberView = LottoStringView.lottoNumberList(lotto.getNumbers());
                bw.write(lottoNumberView);
            }
            bw.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void printWinningStatistics(Map<LottoResult, Integer> resultMap, double rate) {
        try {
            List<Entry<LottoResult, Integer>> entries = LottoStatistics.sortResultMap(resultMap);
            bw.write("\n당첨 통계\n");
            bw.write("---\n");
            for (Entry<LottoResult, Integer> entry : entries) {
                String lottoNumberView = LottoStringView.lottoResultEntry(entry);
                bw.write(lottoNumberView);
            }
            String rateOfReturn = LottoStringView.rateOfReturn(rate);
            bw.write(rateOfReturn);
            bw.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void printErrorMessage(String message) {
        try {
            bw.write(String.format("\n%s\n", message));
            bw.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
