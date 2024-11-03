package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private List<Lotto> purchasedLottos;
    private Lotto lotto;
    public int validatePurchaseAmount(String input) {
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public void purchaseLottos(int amount) {
        int count = amount / 1000;
        purchasedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottos.add(new Lotto(numbers));
        }
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos() {
        for (Lotto lotto : purchasedLottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
    public Lotto validateUserNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(value -> {
                    if (!value.matches("[+-]?\\d*(\\.\\d+)?")) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
                    }
                })
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lotto = new Lotto(numbers);
        return lotto;
    }
    public int validateBonusNumber(String input) {
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        int bonus = Integer.parseInt(input);
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        for(int number : lotto.getNumbers()){
            if(number == bonus) throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        return bonus;
    }
}
