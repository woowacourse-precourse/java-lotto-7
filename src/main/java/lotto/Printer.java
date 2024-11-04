package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Printer {
    public Printer() {
    }

    public void printBudgetNotice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoNumbers(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public void printWinNumbersNotice() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void printBonusNumberNotice() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public void printFinalResult(LottoResultProcessor result){
        int totalMoney= 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        List<String> keys = new ArrayList<>(result.enumResult.keySet());
        Collections.sort(keys);
        for(String name: keys){
            String tag = EnumValue.valueOf(name).getTag();
            String winningMoney= EnumValue.valueOf(name).getMoneyStr();
            int matchCount =  result.enumResult.get(name);
            System.out.println(tag+" ("+ winningMoney+ "원) - "+ matchCount+"개");
        }
        System.out.println("총 수익률은 "+ result.getTotalProfit()+"%입니다.");
    }
}
