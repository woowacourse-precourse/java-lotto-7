package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ValidateValues;
import lotto.model.Lotto;

import java.util.*;

public class LottoGenerator {

    public List<Lotto> generateLotto(String inputPurchaseAmount) {
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        int count = purchaseAmount / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> mutableLottoNumbers = new ArrayList<>(lottoNumbers);
            Collections.sort(mutableLottoNumbers);
            lottos.add(new Lotto(mutableLottoNumbers));
        }
        return lottos;
    }

    public void printLottoCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}