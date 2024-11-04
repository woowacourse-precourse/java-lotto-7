package lotto.view;

import lotto.dto.LottoResponse;
import lotto.dto.PrizeResponse;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private OutputView() {
    }

    private static class OutputViewHolder {
        private static final OutputView instance = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.instance;
    }

    public void promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void promptLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void promptBonusNumber() {
        System.out.println("보너스 번호을 입력해 주세요.");
    }

    public void printPurchasableLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printFormattedLottoNumbers(LottosResponse lottosResponse) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        lottosResponse.lottos()
                .forEach(lottoResponse -> System.out.println(formatLottoNumbers(lottoResponse, joiner)));
    }

    public void printWinningResult(List<PrizeResponse> prizeResponses) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        prizeResponses.forEach(prizeResponse -> {
            String result = prizeResponse.matchingNumberCount() + "개 일치";
            if (prizeResponse.bonusNumberStatus().equals("INCLUDE_BONUS")) {
                result += ", 보너스 볼 일치";
            }
            result += "(" + prizeResponse.prizeMoney() + "원)- "
                    + prizeResponse.winningCount() + "개";

            System.out.println(result);
        });
    }

    private String formatLottoNumbers(LottoResponse lottoResponse) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        lottoResponse.numbers()
                .forEach(number -> joiner.add(String.valueOf(number)));

        return joiner.toString();
    }
}
