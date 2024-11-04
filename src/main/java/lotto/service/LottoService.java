package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoService {
    static final int LOTTO_PRICE = 1000;
    private Lotto lotto;
    int amount;

    String input = readLine();


    public int buyLotto(int money) {
        int remainder = money % LOTTO_PRICE;

        amount = money / LOTTO_PRICE;
        if (remainder != 0) {
            int neededMoney = LOTTO_PRICE - remainder;
            throw new IllegalArgumentException("[ERROR]" + remainder + "원으로는 구매가 불가능합니다." + neededMoney + "원 더 채워주세요");
        }
        return amount;
    }

    public Lotto WinningNumberSplit() {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lotto = new Lotto(numbers);
        return lotto;
    }

    public Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(lottoNumbers);
    }

}
