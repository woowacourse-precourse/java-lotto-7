package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void generateLottoTest(){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,6)); // 1등
        lottoNumbers.add(Arrays.asList(5,3,4,6,1,2)); // 1등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,7)); // 2등
        lottoNumbers.add(Arrays.asList(1,2,3,4,5,8)); // 3등
        lottoNumbers.add(Arrays.asList(1,2,3,4,8,9)); // 4등
        lottoNumbers.add(Arrays.asList(1,2,3,8,9,10)); // 5등

        for (List<Integer> lottoNumber : lottoNumbers) {
            lottoNumber.sort(Integer::compareTo);
        }
        this.boughtLottoNumbers = lottoNumbers;

    }

    public void generateLotto(int lottoCount){
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0 ; i < lottoCount ; i++) {
            List<Integer> lottoNumbers = randomNumber();
            lottoNumbers.sort(Integer::compareTo);
            lottos.add(lottoNumbers);
        }
        this.boughtLottoNumbers = lottos;
    }

    public void lottoWinOutput(List<Integer> lottoMatchTable){
        System.out.println("3개 일치 (5,000원) - " + lottoMatchTable.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoMatchTable.get(1)+ "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoMatchTable.get(2) + "개");
        System.out.println("6개 일치 (30,000,000원) - " + lottoMatchTable.get(3) + "개");
        System.out.println("7개 일치 (2,000,000,000원) - " + lottoMatchTable.get(4)+ "개");
    }

    public List<List<Integer>> getBoughtLottoNumbers() {
        return boughtLottoNumbers;
    }
}
