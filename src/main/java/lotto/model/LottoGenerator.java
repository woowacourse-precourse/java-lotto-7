package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final Money LOTTO_AMOUNT = new Money(1_000L);

    public Lotto generate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public Lottos generate(Money receivedMoney) {
        return generate((long) receivedMoney.divide(LOTTO_AMOUNT));
    }

    public Lottos generate(long count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = generate();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public static Lotto generate(String numbers) {
        return new Lotto(parseNumbers(numbers));
    }

    private static List<Integer> parseNumbers(String input) {
        String[] splitNumbers = input.split(",");
        return convertToIntegerList(splitNumbers);
    }

    private static List<Integer> convertToIntegerList(String[] numbers) {
        List<Integer> integerList = new ArrayList<>();
        for (String number : numbers) {
            integerList.add(parseInteger(number));
        }
        return integerList;
    }

    private static int parseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로만 입력해 주세요.");
        }
    }
}
