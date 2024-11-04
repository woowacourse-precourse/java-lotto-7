package lotto.view;

import lotto.constant.Rank;

import java.util.List;

public class Output {
    public static void requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestHowManyLottos(int money) {
        System.out.println(" ");
        System.out.println(money / 1000 + "개를 구매했습니다.");
    }

    public static void requestLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }

    public static void requestWinningNumbers() {
        System.out.println(" ");
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusNumber() {
        System.out.println(" ");
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    public static void requestWinningResult(List<Integer> winningResult, int five_bonus) {
        System.out.println(" ");
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 ("+Rank.FIFTH.winningPrizeString()+"원) - "+winningResult.get(3)+"개");
        System.out.println("4개 일치 ("+Rank.FIRTH.winningPrizeString()+"원) - "+winningResult.get(4)+"개");
        System.out.println("5개 일치 ("+Rank.THIRD.winningPrizeString()+"원) - "+winningResult.get(5)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 ("+Rank.SECOND.winningPrizeString()+"원) - "+five_bonus+"개");
        System.out.println("6개 일치 ("+Rank.FIRST.winningPrizeString()+"원) - "+winningResult.get(6)+"개");
    }

    public static void requestProfitAbility(double profitAbility){
        System.out.println("총 수익률은 "+String.format("%.2f",profitAbility)+"%입니다.");

    }



}
