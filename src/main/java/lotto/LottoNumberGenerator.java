package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    public List<List<Integer>> generateLottoNumbers(int lottoCount){
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i=0; i<lottoCount; i++){
            lottos.add(generateUniqueNumbers());
        }
        return  lottos;
    }

    public List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public void printLottos(List<List<Integer>> lottos){
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (List<Integer> lotto : lottos){
            System.out.println(lotto);
        }
        System.out.println();
    }
}
