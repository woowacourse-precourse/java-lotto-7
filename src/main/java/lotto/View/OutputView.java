package lotto.View;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import lotto.Constants.Message;
import lotto.Constants.Prize;
import lotto.Domain.LottoResult;
import lotto.Lotto;

public class OutputView {

    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public OutputView() {
    }

    public void printLotto(Lotto lotto) {
        try {
            bufferedWriter.write(lotto.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printNoFlush(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printResult(LottoResult result, double profitRate) {
        printNoFlush(Message.WINNING_STATISTICS.getText());
        printNoFlush("---");
        printPrize(Prize.FIFTH, result.getFifthPrizeCnt());
        printPrize(Prize.FOURTH, result.getFourthPrizeCnt());
        printPrize(Prize.THIRD, result.getThirdPrizeCnt());
        printNoFlush(
                Prize.SECOND.getMatchCount()
                + "개 일치, 보너스 볼 일치 (" + Prize.SECOND.getPrizeStr()
                        + "원) - "
                        + result.getSecondPrizeCnt() + "개");
        printPrize(Prize.FIRST, result.getFirstPrizeCnt());
        print("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

    public void printPrize(Prize prize, int count) {
        printNoFlush(prize.getMatchCount() + "개 일치 (" + prize.getPrizeStr() + "원) - " + count + "개");
    }
}
