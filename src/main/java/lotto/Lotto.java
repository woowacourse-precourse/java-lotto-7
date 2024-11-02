package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        exception.Handler.isValid(numbers);
        this.numbers = numbers;
    }

    static void checkBonusNumber(Lotto lotto, int bonusNumber) {
        for (int number : lotto.numbers) {
            if (bonusNumber == number) {
                exception.Handler.raiseException(number);
            }
        }
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            io.Print.print(lotto.numbers.toString());
        }
    }


    public class Price {
        public final static int PRICE = 1000;
    }

    public enum Rank {
        FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE
    }

    public static Rank getRank(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int count = lotto.numbers.stream().filter(x -> winningLotto.numbers.contains(x)).toList().size();
        List<Rank> ranks = List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.FIFTH, Rank.FOURTH, Rank.NONE, Rank.FIRST);
        if (count == 5 && lotto.numbers.contains(bonusNumber)) {
            return Rank.SECOND;
        }
        if (count == 5 && !lotto.numbers.contains(bonusNumber)) {
            return Rank.THIRD;
        }
        return ranks.get(count);
    }

    public static final List<Integer> value = List.of(2000000000, 30000000, 1500000, 50000, 5000);


    public static String getNumberWithComma(int number) {
        return String.format("%,d", number);
    }

    public static final List<String> valueWithComma = lotto.Lotto.value.stream().map(lotto.Lotto::getNumberWithComma)
            .toList();
}
