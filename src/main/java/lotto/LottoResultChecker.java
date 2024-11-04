package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoResultChecker {

    private ArrayList<Integer> winningNumbers = new ArrayList<>();
    private Integer bonusNumber;
    Integer matchingWithWinning;
    Integer matchingWithBonus;


    Integer validateNumber(String input){
        Integer num;
        try{
            String unit = input.trim();
            num = Integer.parseInt(unit);
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 입력값이 정수가 아니거나 없습니다. 1~45 사이의 정수를 입력해주세요.");
        }
        if(num >45 || num < 1){
            throw new IllegalArgumentException("[ERROR] 입력값의 범위는 1~45입니다.");
        }
        return num;
    }

    void setWinningNumbers(String input){
        String[] inputArr = input.split(",");
        ArrayList<Integer> list = new ArrayList<>();

        for(String unit: inputArr){
            Integer num =validateNumber(unit);
            list.add(num);
        }
        Set<Integer> set = Set.copyOf(list);
        if(set.size() != 6){
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 정수가 중복 없이 6개가 존재해야 합니다.");
        }
        this.winningNumbers = list;
    }

    List<Integer> getWinningNumbers(){
        return this.winningNumbers;
    }

    void setBonusNumber(String input){
        Integer num = validateNumber(input);

        winningNumbers.add(num);
        Set<Integer> set = Set.copyOf(winningNumbers);
        if(set.size() != 7){
            throw new IllegalArgumentException("[ERROR] 보너스번호와 당첨 번호가 중복됩니다.");
        }
        winningNumbers.remove(num);
        this.bonusNumber = num;
    }

    Integer getBonusNumber(){
        return this.bonusNumber;
    }

    void compareWinningNumber(List<Integer> lottoNumbers){
        Integer count=0;
        for(int i = 0; i<6;i++){
            if (lottoNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        this.matchingWithWinning = count;
    }

    void compareBonusNumber(List<Integer> lottoNumbers){
        Integer count = 0;
        if (lottoNumbers.contains(bonusNumber)){
            count++;
        }
        this.matchingWithBonus = count;
    }

    Integer getLottoPrize(Lotto lotto){
        compareWinningNumber(lotto.getNumbers());
        compareBonusNumber(lotto.getNumbers());
        if(this.matchingWithWinning ==6) return 1;
        if(this.matchingWithWinning == 5 && this.matchingWithBonus == 1) return 2;
        if(this.matchingWithWinning == 5 && this.matchingWithBonus == 0) return 3;
        if(this.matchingWithWinning == 4) return 4;
        if(this.matchingWithWinning == 3) return 5;
        return 0;
    }

    Integer[] getLottoResult(List<Lotto> lottoList){
        Integer[] result = new Integer[lottoList.size()];
        int i = 0;
        for (Lotto lotto:lottoList){
            Integer prize =getLottoPrize(lotto);
            result[i] = prize;
            i++;
        }
        return result;
    }
}
