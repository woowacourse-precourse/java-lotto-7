package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class Application {
    private static int purchaseCost;
    private static int purchaseCount;
    private static List<Lotto> lottos;
    
    private static List<Integer> winningNums;
    private static int bonusNum;
    private static LottoWinCalculator calculator;
    
    public static void main(String[] args) {
        purchaseCost = getPurchaseCost();
        purchaseCount = purchaseCost / 1000;
        lottos = LottoGenerator.getLottos(purchaseCount);
        printGeneratedLotto(lottos);
        
        winningNums = getWinningNumbers();
        bonusNum = getBonusNumber();
        calculator = new LottoWinCalculator(winningNums, bonusNum);
        
        Map<WinningType, Integer> winningStat = calculator.getWinningStat(lottos); 
        printWinningStat(winningStat);
        printReturnRate(winningStat);
    } 
    
    private static int getPurchaseCost() {
        return (int)getParsedUserInput(UserInputType.PURCHASE_COST);
    }
    
    private static List<Integer> getWinningNumbers() {
        return (List<Integer>)getParsedUserInput(UserInputType.WINNING_NUMBERS);
    }
    
    private static int getBonusNumber() {
        return (int)getParsedUserInput(UserInputType.BONUS_NUMBER);
    }
    
    private static void checkAvailValue(UserInputType inputType, Object value) {
        if (inputType == UserInputType.BONUS_NUMBER
                && winningNums.contains(value)) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.LOTTO_NUMBER_DUPLICATED);
        }
    }
    
    private static Object getParsedUserInput(UserInputType inputType) {
        Object value;
        while (true) { 
            System.out.println(InputMessageFactory.getInputMessage(inputType));
            try {
                value = UserInputParser.getParsedInput(Console.readLine(), inputType);
                checkAvailValue(inputType, value);
                System.out.println();
                return value;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void printGeneratedLotto(List<Lotto> lottos) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
        for (Lotto l : lottos) {
            System.out.println(l.toString());
        }
        System.out.println();
    }
    
    private static void printWinningStat(Map<WinningType, Integer> winningStat) {
        System.out.println("당첨 통계\n---");
        for (WinningType type : WinningType.reversedValues()) {
            if (type == WinningType.NONE) {
                continue;
            }
            Integer count = winningStat.get(type);
            if (count == null) {
                count = 0;
            }
            System.out.println(LottoWinningInfo.getInfoMessage(type) + " - " + count + "개"); 
        }
    }
    
    private static void printReturnRate(Map<WinningType, Integer> winningStat) {
        System.out.println(
                String.format("총 수익률은 %,.1f%%입니다.", LottoWinCalculator.getReturnRate(winningStat, purchaseCost)));
    }
}
