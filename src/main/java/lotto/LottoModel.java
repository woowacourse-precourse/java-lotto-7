package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.response.LottoBuyResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoModel {
    private final int LOTTO_PRICE = 1000;

    private int seedMoney = 0;
    private final ArrayList<List<Integer>> buyLotto = new ArrayList<>();

    public LottoBuyResponse buyLotto(String money) {
        int validateNumber = numberValidate(money);
        moneyValidate(validateNumber);
        seedMoney = validateNumber;

        int buyLottoNumber = seedMoney / LOTTO_PRICE;
        getLottoNumbers(buyLottoNumber);

        return new LottoBuyResponse(buyLottoResult(), buyLottoNumber);
    }

    private void getLottoNumbers(int buyLottoNumber) {
        Stream.generate(() -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .toList())
                .limit(buyLottoNumber)
                .forEach(buyLotto::add);
    }

    private String buyLottoResult() {

        return buyLotto.stream()
                .map(lottoNumbers -> lottoNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.joining("\n", "", "\n"));
    }

    private int numberValidate(String number) {
        int parseNumber;

        try {
            parseNumber = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if (parseNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력가능합니다.");
        }

        return parseNumber;
    }

    private void moneyValidate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 입력 가능합니다.");
        }

        if (money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 입력 단위는 1000원 단위로 가능합니다.");
        }
    }
}
