package lotto.view;

import lotto.dto.LottoResponse;
import lotto.dto.LottosResponse;

import java.util.StringJoiner;

public class OutputView {
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

    private String formatLottoNumbers(LottoResponse lottoResponse, StringJoiner joiner) {
        lottoResponse.numbers()
                .forEach(number -> joiner.add(String.valueOf(number)));

        return joiner.toString();
    }
}
