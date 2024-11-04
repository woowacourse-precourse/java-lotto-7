package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        int price = purchaseAmount();//가격
        int countPurchase = countPurchases(price);//구매 갯수
        System.out.println("\n" + countPurchase + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < countPurchase; i++) {
            List<Integer> numberList = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numberList);
            Lotto lotto = new Lotto(numberList);
            lottoList.add(lotto);
        }
        printNumbers(lottoList);
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinning = Console.readLine();
        String[] winningNumber = winningSplit(inputWinning);
        List<Integer> winningNumbers = setWinningNumber(winningNumber);
        int bonusNumber = setBonusNumber();

        LottoStatistics stats = new LottoStatistics(price);
        for (Lotto lotto : lottoList) {
            int matchCount = calculateMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            stats.recordResult(matchCount, bonusMatch);
        }

        stats.printStatistics();
    }

    private static int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        int matchCount = 0;
        for (Integer number : lottoNumbers) {
            if(winningNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    private static int setBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호 1개만 입력해주세요");
                System.out.println("\n보너스 번호를 입력해 주세요.");
            }
        }
    }

    private static List<Integer> setWinningNumber(String[] winningNumber){
        List<Integer> winningNumbers = new ArrayList<>();
        while (true) {
            try {
                for (String number : winningNumber) {
                    winningNumbers.add(Integer.parseInt(number));
                }
                Collections.sort(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자와 쉼표만 입력해주세요.");
                System.out.println("당첨 번호를 입력해 주세요.");
            }
        }
    }

    private static String[] winningSplit(String inputWinning){
        String[] winningNumber = null;
        while (true) {
            try {
                winningNumber = inputWinning.split(",");
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자는 쉼표를 기준으로 입력해야 합니다");
                System.out.println("당첨 번호를 입력해 주세요.");
            }
        }
    }

    private static void printNumbers(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    private static int countPurchases(int price){
        if(priceCheck(price)){
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아닙니다.");
        }
        return price/1000;
    }

    private static boolean priceCheck(int price){
        return price % 1000 != 0 || price < 1000;
    }

    private static int purchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        while (true) {
            try{
                price = Integer.parseInt(Console.readLine());
                return price;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 숫자로만 입력해주세요");
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }
}
