package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final List<Lotto> Lottos;

    public LottoGenerator() {
        int amount = inputAmount();

        int count = calculateLottoCount(amount);
        List<Lotto> tmpLottoList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            List<Integer> tmpList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(tmpList);

            tmpLottoList.add(new Lotto(tmpList));
        }
        this.Lottos = tmpLottoList;
    }

    private int inputAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        String inputAmount = Console.readLine();
        System.out.println();

        int amount;
        amount = validateInputAmount(inputAmount);
        validateAmount(amount);

        return amount;
    }

    private int validateInputAmount(String inputAmount) {
        int amount;
        try {
            amount = Integer.parseInt(inputAmount.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 숫자로 이루어져야 합니다.");
        }
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private int calculateLottoCount(int amount) {
        return amount/1000;
    }

    public List<Lotto> getLottos() {
        return Lottos;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(Lottos.size()).append("개를 구매했습니다.\n");

        for (Lotto lotto : Lottos) {
            result.append(lotto).append("\n");
        }

        return result.toString();
    }

}
