package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    private static final Integer MINIMUM_MONEY = 1000;
    private static final String NUMBER_REGEX = "^[1-9][0-9]*$";

    private final Integer lottoQuntity;
    private final List<Lotto> generatedLottos;
    private final List<Integer> userPickedNumbers;

    public LottoMachine(String purchaseInput) {
        int quantity = validate(purchaseInput);
        this.lottoQuntity = quantity;
        this.generatedLottos = new ArrayList<>();
        this.userPickedNumbers = new ArrayList<>();
    }

    public void generateLottos() {
        for(int i = 0; i < this.lottoQuntity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = numbers.stream().sorted().toList();
            this.generatedLottos.add(new Lotto(sortedNumbers));
        }
    }

    private int validate(String purchaseInput) {
        if (!purchaseInput.matches(NUMBER_REGEX))
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.");

        Integer purchaseAmount = Integer.parseInt(purchaseInput);
        if (purchaseAmount % MINIMUM_MONEY != 0)
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원입니다. 1000원 단위로 입력해주세요.");

        return purchaseAmount / MINIMUM_MONEY;
    }
}
