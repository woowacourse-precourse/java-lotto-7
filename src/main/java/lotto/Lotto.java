package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Integer::compareTo); // 오름차순 정렬
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void start(OutputView outputView,int bonusNumber){
        lottoNumberCheck(outputView.getBoughtLottoNumbers(),bonusNumber);
    }

    public List<Integer> pushNumberTable(List<Integer> equalNumberTable,int equalNumberCount, boolean bonusNumber){
        while(true){
            if(equalNumberCount == 3){
                equalNumberTable.set(0, equalNumberTable.get(0)+1);
                break;
            }
            if(equalNumberCount == 4){
                equalNumberTable.set(1, equalNumberTable.get(1)+1);
                break;
            }
            if(equalNumberCount == 5 && bonusNumber){
                equalNumberTable.set(3, equalNumberTable.get(3)+1);
                break;
            }
            if(equalNumberCount == 5){
                equalNumberTable.set(2, equalNumberTable.get(2)+1);
                break;
            }
            if(equalNumberCount == 6){
                equalNumberTable.set(4, equalNumberTable.get(4)+1);
                break;
            }
        }
        return equalNumberTable;
    }

    public List<Integer> lottoNumberCheck(List<List<Integer>> boughtLottoNumbers,int bonusNumber){
        List<Integer> equalNumberTable = new ArrayList<>(Arrays.asList(0,0,0,0,0));

        for(List<Integer> boughtLottoNumber : boughtLottoNumbers){
            int equalNumberCount = 0;
            boolean equalBonusNumber = false;
            for(int i = 0 ; i < numbers.size() ; i++){
                if(numbers.get(i).equals(boughtLottoNumber.get(i))){
                    equalNumberCount++;
                }
                if(boughtLottoNumber.get(i).equals(bonusNumber)){
                    equalBonusNumber = true;
                }
            }
            equalNumberTable = pushNumberTable(equalNumberTable,equalNumberCount,equalBonusNumber);
        }
        return equalNumberTable;
    }
}


