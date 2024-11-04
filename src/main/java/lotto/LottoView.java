package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoView {
    public int inputPurchaseAmount(){
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return parseNumbers(Console.readLine().split(","));
    }

    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void displayPurchasedLottos(List<Lotto> lottos){
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayResult(LottoResult result, int purchaseAmount){
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+ result.getCountOfMatches(3) + "개");
        System.out.println("4개 일치 (50,000원) - "+result.getCountOfMatches(4)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ result.getCountOfMatches(5)+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getCountOfMatches(5,true)+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ result.getCountOfMatches(6)+ "개");

        double profitRate = result.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public void displayError(String errorMessage){
        System.out.println(errorMessage);
    }

    private List<Integer> parseNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이여야 합니다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자입니다: " + token);
            }
        }
        return numbers;
    }
    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }
    private int readPositiveInteger() {
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());
                if (amount <= 0) {
                    throw new IllegalArgumentException("[ERROR] 양수 금액을 입력해야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 숫자입니다. 다시 입력해 주세요.");
            }
        }
    }
}
