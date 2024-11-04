package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class PrintManager {
    public void printPriceNotice() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public void printLottoNumbers(int numberOfLotto, List<Lotto> purchasedLotto) {
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        for (Lotto lotto : purchasedLotto) {
            StringBuilder oneLottoNumbers = new StringBuilder();
            oneLottoNumbers.append("[");
            for (Integer number : lotto.getNumbers()) {
                oneLottoNumbers.append(number + ", ");
            }
            oneLottoNumbers.delete(oneLottoNumbers.length() - 2 , oneLottoNumbers.length());
            oneLottoNumbers.append("]");
            System.out.println(oneLottoNumbers);
        }
        System.out.println("");
    }

    public void printWinningLottoNotice() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNotice() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningResult(EnumMap<MatchCount, Integer> winningResult) {
        System.out.println("\n" + "당첨 통계" + "\n" + "---");
        List<Integer> winningStastics = new ArrayList<>(winningResult.values());
        System.out.println("3개 일치 (5,000원) - " + winningStastics.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningStastics.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningStastics.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningStastics.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningStastics.get(4) + "개");
    }

    public void printTotalYield(double totalYield) {
        String formattedYield = setNumberFormat(totalYield);
        System.out.println("총 수익률은 " + formattedYield + "%입니다.");
    }

    private String setNumberFormat(double number) {
        BigDecimal bigNumber = new BigDecimal(number);
        String numberToString = bigNumber.toPlainString();
        String[] splittedNumber = numberToString.split("\\.");
        String integerPart = splittedNumber[0];
        String decimalPart = setDecimalPart(splittedNumber);

        StringBuilder commaAddedIntegerPart = new StringBuilder(integerPart);
        for (int i = commaAddedIntegerPart.length() - 3; i > 0; i -= 3) {
            commaAddedIntegerPart.insert(i, ',');
        }
        String formattedNumber = commaAddedIntegerPart.toString() + "." + decimalPart;
        return formattedNumber;
    }

    private String setDecimalPart(String[] splittedNumber) {
        String decimalPart = new String();
        if (splittedNumber.length > 1) {
            decimalPart = splittedNumber[1];
            return decimalPart;
        }
        decimalPart = "0";
        return decimalPart;
    }
}
