package lotto.view;

import lotto.model.Prize;

import java.text.NumberFormat;
import java.util.*;

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

    public void displayPrizes(EnumMap<Prize, Integer> prizeCount) {
        System.out.println("\n" + "당첨 통계" + "\n" + "---");
        for (Prize prize : Prize.values()) {
            long moneyWithoutComma = prize.getPrizeMoney();
            String moneyWithComma = formatCurrency(moneyWithoutComma);


            if(prize.equals(Prize.SECOND)){
                System.out.println(prize.getRanking() + "개 일치, 보너스 볼 일치 " + "(" + moneyWithComma + "원) - " + prizeCount.get(prize) + "개");
                continue;
            }
            System.out.println(prize.getRanking() + "개 일치 " + "(" + moneyWithComma + "원) - " + prizeCount.get(prize) + "개");
        }
    }

    public void displayWinningRate(double winningRate) {
        String formattedValue = String.format("%.1f", winningRate);
        System.out.println("총 수익률은 " + formattedValue + "%입니다.");
    }

    public void showLottos(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }


    public static String formatCurrency(long amount) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        return numberFormat.format(amount);
    }
}
