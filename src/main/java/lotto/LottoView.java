package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.response.LottoBuyResponse;
import lotto.dto.response.LottoResultResponse;

public class LottoView {
    public String moneyInput() {
        System.out.println("구입 금액을 입력해 주세요.");

        return Console.readLine();
    }

    public String lottoNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");

        return Console.readLine();
    }

    public String bonusNumberInput() {
        System.out.println("\n보너스 번호를 입력해 주세요.");

        return Console.readLine();
    }

    public void randomLottoNumberOutput(LottoBuyResponse lottoNumbers) {
        System.out.println("\n" + lottoNumbers.buyLottoNumber() + "개를 구매했습니다.");
        System.out.println(lottoNumbers.buyResult());
    }

    public void lottoResultOutput(LottoResultResponse lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 " + "(" + String.format("%,d", Rank.FIFTH.getPrize()) + "원)" + " - " + String.format("%,d", lottoResult.countResult().get(Rank.FIFTH)) + "개");
        System.out.println("4개 일치 " + "(" + String.format("%,d", Rank.FOURTH.getPrize()) + "원)" + " - " + String.format("%,d", lottoResult.countResult().get(Rank.FOURTH)) + "개");
        System.out.println("5개 일치 " + "(" + String.format("%,d", Rank.THIRD.getPrize()) + "원)" + " - " + String.format("%,d", lottoResult.countResult().get(Rank.THIRD)) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 " + "(" + String.format("%,d", Rank.SECOND.getPrize()) + "원)" + " - " + String.format("%,d", lottoResult.countResult().get(Rank.SECOND)) + "개");
        System.out.println("6개 일치 " + "(" + String.format("%,d", Rank.FIRST.getPrize()) + "원)" + " - " + String.format("%,d", lottoResult.countResult().get(Rank.FIRST)) + "개");
        System.out.println("총 수익률은 " + lottoResult.rate() + "%입니다.");
    }
}
