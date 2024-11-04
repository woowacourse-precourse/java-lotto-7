package lotto.service;

import lotto.domain.Prize;

import java.util.List;
import java.util.Map;

public class OutputService {
    public void requestPay() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showPurchasedLottoAmount(int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public void showLottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void requestWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void moveToShowPrize() {
        System.out.println("당첨 통계\n---");
    }

    public void showResultLotto(Map<Prize, Integer> result) {
        for(Prize prize : Prize.values()) {
            if(prize.getIndex() == 0) {
                continue;
            }
            System.out.print(checkPrizeAndShow(prize, prize.getBonusNumber()));
            System.out.println(result.get(prize) + "개");
        }
    }

    public String checkPrizeAndShow(Prize prize, boolean bonus) {
        StringBuilder sb = new StringBuilder();
        sb.append(prize.getAmount());
        sb.append("개 일치");
        if(bonus) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append("(");
        sb.append(prize.getReward());
        sb.append("원) - ");
        return sb.toString();
    }

    public void showRateOfReturn(double rate) {
        System.out.println("총 수익률은 " + Math.round(rate * 100) / 100.0 + "%입니다.");
    }
}
