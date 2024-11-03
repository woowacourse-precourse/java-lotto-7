package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> purchasedLottos = generateLottos(lottoCount);
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

        List<Integer> winningNumbers = getWinningNumbers();
        System.out.println("당첨 번호: " + winningNumbers);
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine().trim());
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return purchaseAmount;
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, LOTTO_NUMBERS_COUNT
        );
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

