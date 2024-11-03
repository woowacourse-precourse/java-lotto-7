package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumGenerator {
    private int lottoNumbers = 0;
    private List<List<Integer>> generateAutoLotto;
    public void convertToThousandUnit(int inputAmount){
        if(inputAmount % 1000 != 0){
            throw new IllegalArgumentException("1000단위 x");
        }
        lottoNumbers = inputAmount / 1000;
        System.out.println(lottoNumbers+"개를 구매했습니다.");
        generateAutoLotto = new ArrayList<>(lottoNumbers);
    }
    public void allocateAutoLotto(){
        for(int i=0; i<lottoNumbers; i++){
            generateAutoLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        for (List<Integer> getValue: generateAutoLotto){
            System.out.print("[");
            for(int i=0; i<getValue.size(); i++){
                System.out.print(getValue.get(i));
                if(i <getValue.size()-1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> getGenerateAutoLotto(){
        return generateAutoLotto;
    }

}
