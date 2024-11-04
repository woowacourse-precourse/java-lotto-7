package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.sql.Array;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class Application {
    public static void main(String[] args) {
        int attempts= validateBetAmount();
        printEntries(attempts);
        List<Integer> lottoNumbers = enterLottoNumbers();
        enterBonusNumber(lottoNumbers);
    }

    private static int validateBetAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        int betAmount = Integer.parseInt(input);
        if(betAmount<1000){
            throw new IllegalArgumentException("베팅 금액이 1000원 미만입니다");
        }
        if(betAmount%1000!=0) {
            throw new IllegalArgumentException("베팅 금액이 1000원 단위가 아닙니다");
        }
        int attempts = betAmount/1000;
        System.out.println(attempts + "개를 구매했습니다.");
        return attempts;
    }
    private static void printEntries(int attempts) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0; i<attempts; i++){
            List<Integer> entries;
            entries = Randoms.pickUniqueNumbersInRange(1,45,6);
            entries.sort(Comparator.naturalOrder());
            lists.add(entries);
        }
        for(int j=0; j<attempts; j++){
            System.out.println(lists.get(j));
        }
    }

    private static List<Integer> enterLottoNumbers(){
        List<Integer> lottoNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        for(String number : splitInput){
            lottoNumbers.add(Integer.parseInt(number));
        }
        lottoNumbers.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(lottoNumbers);
        return lottoNumbers;
    }

    private static int enterBonusNumber(List<Integer> enterLottoNumbers){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        boolean containNumber = enterLottoNumbers.contains(bonusNumber);
        if(containNumber){
            throw new IllegalArgumentException("당첨 번호와 중복된 숫자입니다");
        }
        if(bonusNumber>45 || bonusNumber<1){
            throw new IllegalArgumentException("보너스 숫자는 1 이상, 45 이하입니다.");
        }
        return bonusNumber;
    }
}