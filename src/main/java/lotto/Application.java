package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int attempts= validateBetAmount();
        List<List<Integer>> entryLists = printEntries(attempts);
        List<Integer> lottoNumbers = enterLottoNumbers();
        int bonusNumber = enterBonusNumber(lottoNumbers);
        printResults(entryLists, lottoNumbers, bonusNumber, attempts);
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
    private static List<List<Integer>> printEntries(int attempts) {
        List<List<Integer>> entryLists = new ArrayList<>();
        for(int i=0; i<attempts; i++){
            List<Integer> entries;
            entries = Randoms.pickUniqueNumbersInRange(1,45,6);
            entries.sort(Comparator.naturalOrder());
            entryLists.add(entries);
        }
        for(int j=0; j<attempts; j++){
            System.out.println(entryLists.get(j));
        }

        return entryLists;
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

    private static void printResults(List<List<Integer>> entryLists, List<Integer> lottoNumbers, int bonusNumber, int attempts){
        EnumMap<LottoResults, Integer> calculateResults = new EnumMap<>(LottoResults.class);
        System.out.println("당첨 통계");
        System.out.println("---");
        for(LottoResults result : LottoResults.values()){
            calculateResults.put(result,0); // 각 값 초기화, 0으로 초기화
        }
        for(int i=0; i<attempts; i++){
            List<Integer> matchedNumbers = new ArrayList<>(entryLists.get(i));
            matchedNumbers.retainAll(lottoNumbers);
            if(matchedNumbers.size()==3){
                calculateResults.put(LottoResults.THREE_MATCH, calculateResults.get(LottoResults.THREE_MATCH) + 1);
            }
            if(matchedNumbers.size()==4) {
                calculateResults.put(LottoResults.FOUR_MATCH, calculateResults.get(LottoResults.FOUR_MATCH) + 1);
            }
            if(matchedNumbers.size()==5){
                calculateResults.put(LottoResults.FIVE_MATCH, calculateResults.get(LottoResults.FIVE_MATCH) + 1);
            }
            if(matchedNumbers.size()==5 && entryLists.get(i).contains(bonusNumber)){
                calculateResults.put(LottoResults.FIVE_BONUS_MATCH, calculateResults.get(LottoResults.FIVE_BONUS_MATCH) + 1);
            }
            if(matchedNumbers.size()==6){
                calculateResults.put(LottoResults.SIX_MATCH, calculateResults.get(LottoResults.SIX_MATCH) + 1);
            }
        }
        for(LottoResults result : LottoResults.values()){
            System.out.println(result.getHowMany() +" (" + result.getPrize()+ "원) : " + calculateResults.get(result) + "개");
        }
    }


}