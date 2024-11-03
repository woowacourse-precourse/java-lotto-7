package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.validation.Validation;
import lotto.view.Input;
import lotto.view.Output;

public class LottoPurchase {
    Input input = new Input();
    Validation validation = new Validation();
    Lotto lotto;
    Output output = new Output();
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUM_COUNT = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    protected int purchaseAmount() {
        int amount = input.price();
        validation.purchase(amount);

        return amount/LOTTO_PRICE;
    }


    public List<Lotto> issueLotto(int numberOfLottos) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = generateLottoNumbers(); // 로또 번호 생성
            Lotto lotto = new Lotto(numbers); // 생성된 번호로 Lotto 객체 생성
            lottoList.add(lotto); // 리스트에 Lotto 객체 추가
        }

        output.purchaseAmount(lottoList);
        return lottoList;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_NUM_COUNT);
        lotto = new Lotto(numbers);
        return numbers;
    }
}



