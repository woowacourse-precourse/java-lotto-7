package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private List<List<Integer>> boughtLottoNumbers;

    public void outputLottoNumbers() {
        System.out.println(boughtLottoNumbers.size() + "개를 구매했습니다.");
        for (List<Integer> boughtLottoNumber : boughtLottoNumbers) {
            System.out.println(boughtLottoNumber);
        }
    }

    private List<Integer> randomNumber(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public void generateLotto(int lottoCount){
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoCount ; i++) {
            List<Integer> lottoNumbers = randomNumber();
            lottos.add(lottoNumbers);
        }
        this.boughtLottoNumbers = lottos;
    }

}
