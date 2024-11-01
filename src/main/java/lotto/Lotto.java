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
        if (count == 6) {
            return Rank.FIRST;
        }
        if (count == 5) {
            return Rank.SECOND;
        }
        if (count == 4 && winningLotto.numbers.contains(bonusNumber)) {
            return Rank.THIRD;
        }
        if (count == 4 && !winningLotto.numbers.contains(bonusNumber)) {
            return Rank.FOURTH;
        }
        if (count == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    public static final List<Integer> value = List.of(2000000000, 30000000, 1500000, 50000, 5000);

    public static final List<String> valueWithComma = lotto.Lotto.value.stream().map(x -> String.format("%,d", x))
            .toList();
}
