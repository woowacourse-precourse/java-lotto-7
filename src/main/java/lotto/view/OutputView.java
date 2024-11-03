package lotto.view;

import java.util.List;

import lotto.domain.DrawingLotto;
import lotto.util.WinningInfo;
import lotto.util.messages.OutputMessage;

public class OutputView {
    public void printCount(int count) {
        System.out.printf(OutputMessage.OUTPUT_NUMBER_OF_LOTTO.getMessage(), count);
    }

    // 구입을 통해 발급된 로또 번호들을 출력
    public void printDrawedNumbers(List<DrawingLotto> drawingLottos) {
        for (DrawingLotto drawingLotto : drawingLottos) {
            System.out.println(drawingLotto.getDrawingNumbers());
        }
    }

    public void printLottoResult(List<Double> matchCounts) {
        System.out.println(OutputMessage.OUTPUT_RESULT.getMessage());
        // 로또 당첨 종류별로 당첨 정보를 출력
        for (WinningInfo winningInfo : WinningInfo.values()) {
            int matchCount = (int) matchCounts.stream()
                    .filter(count -> count == winningInfo.getCountOfSameNumber())
                    .count();
            System.out.printf(winningInfo.getInfoMessage(), matchCount);
        }

    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(OutputMessage.OUTPUT_RATE_OF_RETURN.getMessage(), rateOfReturn);
    }
}
