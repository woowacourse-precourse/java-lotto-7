package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class LottoMachine {
    private static final Integer MINIMUM_MONEY = 1000;
    private static final String NUMBER_REGEX = "^[1-9][0-9]*$";

    private final Integer lottoQuntity;
    private final List<Lotto> generatedLottos;
    private final List<Integer> userPickedNumbers;

    public LottoMachine(String purchaseInput) {
        int quantity = validatePurchase(purchaseInput);
        this.lottoQuntity = quantity;
        this.generatedLottos = new ArrayList<>();
        this.userPickedNumbers = new ArrayList<>();
    }

    public List<Lotto> getGeneratedLottos() {
        return Collections.unmodifiableList(this.generatedLottos);
    }

    public void generateLottos() {
        for (int i = 0; i < this.lottoQuntity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            validateUnique(numbers);
            Collections.sort(numbers);
            this.generatedLottos.add(new Lotto(numbers));
        }

        printGeneratedLottos();
    }

    public void printGeneratedLottos() {
        StringBuilder result = new StringBuilder();

        result.append("\n").append(this.lottoQuntity).append("개 구매했습니다.\n");
        for(int i = 0; i < this.lottoQuntity; i++) {
            List<Integer> numbers = generatedLottos.get(i).getNumbers();
            result.append("[");
            numbers.forEach(e -> result.append(e).append(", "));
            result.replace(result.length()-2, result.length(), "]\n");
        }

        System.out.println(result);
    }

    private int validatePurchase(String purchaseInput) {
        if (!purchaseInput.matches(NUMBER_REGEX))
            throw new IllegalArgumentException("[ERROR] 금액이 잘못 되었습니다.");

        Integer purchaseAmount = Integer.parseInt(purchaseInput);
        if (purchaseAmount % MINIMUM_MONEY != 0)
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위 입니다.");

        return purchaseAmount / MINIMUM_MONEY;
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 되지 않아야 합니다.");
    }
}
