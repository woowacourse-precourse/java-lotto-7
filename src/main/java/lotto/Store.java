package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Store {
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;
    public List<Lotto> salesLotto(int amount){
        List<Lotto> lottos = new ArrayList<>();
        int countOfLotto = amount / 1000;

        for(int i = 0; i < countOfLotto; i++) {
            lottos.add(createLotto());
        }

        showBuyLottos(countOfLotto, lottos);

        return lottos;
    }

    private void showBuyLottos(int countOfLotto, List<Lotto> lottos){
        System.out.println(countOfLotto + "개를 구매했습니다.\n");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    private Lotto createLotto(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public void setWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        if(!validateWinningNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호를 입력했습니다. -> " + input);
        }
        String[] splits = input.split(",");
        for (String split : splits) {
            this.winningNumbers.add(Integer.parseInt(split));
        }
    }

    public void setBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        if(!validateBonusNumber(input)){
            throw new IllegalArgumentException("[ERROR]잘못된 보너스 넘버를 입력했습니다. -> " + input);
        }

        this.bonusNumber = Integer.parseInt(input);
    }

    public boolean validateBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            // 숫자 변환에 실패하거나, 중복되거나, 범위를 벗어나면 false 반환
            return !this.winningNumbers.contains(bonusNumber) && bonusNumber >= 1 && bonusNumber <= 45;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Integer> getWinningNumbers(){
        return this.winningNumbers;
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }

    public boolean validateWinningNumber(String input) {
        return isNonEmptyString(input) &&
                hasSixNumbers(input) &&
                allNumbersValid(input) &&
                isWithinRange(input) &&
                hasNoDuplicates(input);
    }

    private boolean isNonEmptyString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    private boolean hasSixNumbers(String input) {
        String[] numbers = input.split(",");
        return numbers.length == 6;
    }

    private boolean allNumbersValid(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            try {
                Integer.parseInt(number.trim());
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean isWithinRange(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                return false;
            }
        }
        return true;
    }

    private boolean hasNoDuplicates(String input) {
        String[] numbers = input.split(",");
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (!uniqueNumbers.add(num)) {
                return false;
            }
        }
        return true;
    }

    public int rankAndRevenue(List<Lotto> buyerLotto){
        System.out.println("\n당첨 통계\n" + "---");
        int[] matches = new int[20];
        for (Lotto lotto : buyerLotto) {
            int cnt = 0;

            for(Integer number : lotto.getNumbers()){
                if(this.winningNumbers.contains(number)) cnt++;
            }
            if(cnt == 6) cnt++;
            if(cnt == 5 && lotto.getNumbers().contains(this.bonusNumber)) cnt++;

            matches[cnt]++;
        }
        return matches3Print(matches[3]) + matches4Print(matches[4]) + matches5Print(matches[5]) + matches5BonusPrint(matches[6]) + matches6Print(matches[7]);
    }

    private int matches3Print(int cnt){
        System.out.println("3개 일치 (5,000원) - " + cnt + "개");
        return 5000 * cnt;
    }
    private int matches4Print(int cnt){
        System.out.println("4개 일치 (50,000원) - " + cnt + "개");
        return 5000 * cnt;
    }
    private int matches5Print(int cnt){
        System.out.println("5개 일치 (1,500,000원) - " + cnt + "개");
        return 1500000 * cnt;
    }
    private int matches5BonusPrint(int cnt){
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + cnt + "개");
        return 30000000 * cnt;
    }
    private int matches6Print(int cnt){
        System.out.println("6개 일치 (2,000,000,000원) - " + cnt + "개");
        return 2000000000 * cnt;
    }
}
