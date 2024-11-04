package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoService {
    static final int LOTTO_PRICE = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public List<Lotto> buyLotto(int money) {
        validatePurchaseAmount(money);
        int lottoCount = money / LOTTO_PRICE;

        for (int i = 0; i < lottoCount; i++) {
            purchasedLottos.add(generateLotto());
        }
        return purchasedLottos;
    }

    private void validatePurchaseAmount(int money) {
        if (money % LOTTO_PRICE != 0){
            int remainder = money % LOTTO_PRICE;
            int neededMoney = LOTTO_PRICE - remainder;
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d원으로는 구매가 불가능합니다. %d원 더 채워주세요",remainder,neededMoney)
            );
        }
    }

    //당첨번호
    public Lotto winningNumberSplit() {
        List<Integer> numbers = Arrays.stream(winningNumberInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        lotto = new Lotto(numbers);
        return lotto;
    }
    public int bonusNumber() {
        return Integer.valueOf(bonusNumberInput);
    }
    //무작위의 로또 배열
    public Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(lottoNumbers);
    }



}
