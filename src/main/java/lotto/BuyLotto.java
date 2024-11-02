package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    List<List<Integer>> lottoList; // 여러 개의 로또 번호를 저장할 리스트

    public BuyLotto(int numberOfLotto) {
        lottoList = new ArrayList<>();
        buyLotto(numberOfLotto);
    }

    private void buyLotto(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> singleLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 중복되지 않는 6개의 번호 생성
            lottoList.add(singleLotto);
        }
    }

    public void printLottoList() {
        for (List<Integer> integers : lottoList) {
            Collections.sort(integers);
            System.out.println(integers);
        }
    }

    public List<List<Integer>> getLottoList() {
        return lottoList;
    }
}