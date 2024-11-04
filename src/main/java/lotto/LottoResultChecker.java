package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Application.getNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoResultChecker {

    private List<Integer> winningNumbers = new ArrayList<>();
    private Integer bonusNumber;
    Integer matchingWithWinning;
    Integer matchingWithBonus;
    Boolean keepSetWinningNumbers = true;
    Boolean keepSetBonusNumbers = true;


    List<Integer> validateNumberList(String[] arr) throws Exception{
        ArrayList<Integer> list = new ArrayList<>();
        Integer num;
        for (String str : arr) {
            num = validateNumber(str);
            list.add(num);
        }
        Set<Integer> set = Set.copyOf(list);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 정수가 중복 없이 6개가 존재해야 합니다.");
        }
        return list;
    }

    Integer validateNumber(String str) throws Exception{
        Integer num;
        try {
            String unit = str.trim();
            num = Integer.parseInt(unit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 정수가 아니거나 없습니다. 1~45 사이의 정수를 입력해주세요.");
        }
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("[ERROR] 입력값의 범위는 1~45입니다.");
        }
        return num;
    }

    static String[] getNumbers(){

        System.out.println("당첨 번호를 입력해주세요.");
        String input = readLine();
        String[] inputArr = input.split(",");
        System.out.println();

        return inputArr;
    }

    static String getNumber(){

        System.out.println("보너스 번호를 입력해주세요.");
        String input2 = readLine();
        System.out.println();

        return input2;
    }

    void setWinningNumbers() {
        List<Integer> list = null;

        while (keepSetWinningNumbers) {
            list = new ArrayList<>();
            try {
                String[] input = getNumbers();
                list = validateNumberList(input);
                keepSetWinningNumbers = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        this.winningNumbers = list;
    }

    List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    void setBonusNumber(){
        while (keepSetBonusNumbers) {
            try {
                String input = getNumber();
                Integer num = validateNumber(input);
                testBonusNumber(num);
                this.bonusNumber = num;
                keepSetBonusNumbers = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void testBonusNumber(Integer num) throws Exception{
        winningNumbers.add(num);
        Set<Integer> set = Set.copyOf(winningNumbers);
        if(set.size() != 7){
            throw new IllegalArgumentException("[ERROR] 보너스번호와 당첨 번호가 중복됩니다.");
        }
        winningNumbers.remove(num);
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
