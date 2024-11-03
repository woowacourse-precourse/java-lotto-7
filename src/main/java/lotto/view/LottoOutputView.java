package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoPrizeType;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class LottoOutputView {
    private final NumberFormat koreaNumberFormatter = NumberFormat.getInstance(Locale.KOREA);
    public void printCashNotification(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printErrorMessage(String reason){
        System.out.println("[ERROR]"+reason);
    }
    public void printLottoBundleAmount(int amount){
        System.out.println(amount+"개를 구매했습니다.");
    }
    public void printLottoInBundle(LottoBundle lottoBundle){
        for (Lotto lotto : lottoBundle.getLottoBundle()){
            System.out.println(lotto.getNumbers().toString());
        }
    }
    public void printWinningNumberNotification(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void printBonusNumberNotification(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public void printLottoPrizesNotification(){
        System.out.println("당첨 통계\n" + "---");
    }
    public void printLottoPrizes(Map<LottoPrizeType, Integer> lottoPrizes){
        for (Map.Entry<LottoPrizeType, Integer> lottoPrize : lottoPrizes.entrySet()) {
            LottoPrizeType prizeType = lottoPrize.getKey();
            int count = lottoPrize.getValue();
            System.out.print(prizeType.getRequiredCorrectCount()+ "개 일치");
            if (prizeType == LottoPrizeType.SECOND){
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" ("+koreaNumberFormatter.format(prizeType.getPrizeAmount())+")");
            System.out.println(" - "+count+"개");
        }
    }
    public void printLottoBenefit(double benefit){
        String formattedBenefit = formatBenefit(benefit);
        System.out.print("총 수익률은 "+formattedBenefit+"입니다.");
    }
    private String formatBenefit(double number) {
        double percentage = number * 100; // Convert to percentage
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0"); // Format to one decimal place
        return decimalFormat.format(percentage) + "%";
    }
}
