package view;

import java.util.Map;

public class OutputHandler {

    public void promptForAmountInput(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void promptForLottoNumber(){
        System.out.println("\n" +"당첨 번호를 입력해 주세요.");
    }
    public void promptForBonusNumber(){
        System.out.println("\n" +"보너스 번호를 입력해 주세요.");
    }
    public void displayPurchasedLottoCount(int count){
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void displayPrizes(Map<Integer, Integer> prizes){
        System.out.println("당첨 통계" + "\n" + "---");
        System.out.println("3개 일치 (5000원) - " + prizes.get(3) + "개");
        System.out.println("4개 일치 (50000) - " + prizes.get(4) + "개");
        System.out.println("5개 일치 (1500000) - " + prizes.get(5) + "개");
        System.out.println("5개 일치 (30000000원) - " + prizes.get(7) + "개");
        System.out.println("6개 일치 (2000000000원) - " + prizes.get(6) + "개");
    }

    public void displayWinningRate(double winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }

}
