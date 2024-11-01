package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import exception.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final Price price;

    public int getPrice() {
        return Price.PRICE;
    }

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicity(numbers);
        checkRange(numbers);
        this.numbers = numbers;
        this.price = new Price();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            exception.Message message = new exception.Message(numbers.toString());
            String exceptionMessage = message.getMessage(Message.INVALID_CHOICE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private void checkDuplicity(List<Integer> numbers) {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) != 1) {
                exception.Message message = new exception.Message(Integer.toString(number));
                String exceptionMessage = message.getMessage(Message.DUPLICATE_NUMBER);
                throw new IllegalArgumentException(exceptionMessage);
            }
        }
    }

    static void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                exception.Message message = new exception.Message(Integer.toString(number));
                String exceptionMessage = message.getMessage(Message.INVALID_RANGE);
                throw new IllegalArgumentException(exceptionMessage);
            }
        }
    }

    static void checkBonusNumber(Lotto lotto, int bonusNumber) {
        for (int number : lotto.numbers) {
            if (bonusNumber == number) {
                exception.Message message = new exception.Message(Integer.toString(number));
                String exceptionMessage = message.getMessage(Message.INVALID_BONUS_NUMBER);
                throw new IllegalArgumentException(exceptionMessage);
            }
        }
    }

    public static List<Lotto> getLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = numbers.stream().sorted().toList();
            lottos.add(new Lotto(sortedNumbers));
        }

        return lottos;
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            io.Print.print(lotto.numbers.toString());
        }
    }


    public class Price {
        public final static int PRICE = 1000;
    }

    enum Rank {
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

    public static List<Integer> countRank(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        List<Integer> counter = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto lotto: lottos) {
            if (getRank(lotto, winningLotto, bonusNumber).equals(Rank.FIRST)) {
                counter.set(0, counter.get(0) + 1);
            }
            if (getRank(lotto, winningLotto, bonusNumber).equals(Rank.SECOND)) {
                counter.set(1, counter.get(1) + 1);
            }
            if (getRank(lotto, winningLotto, bonusNumber).equals(Rank.THIRD)) {
                counter.set(2, counter.get(2) + 1);
            }
            if (getRank(lotto, winningLotto, bonusNumber).equals(Rank.FOURTH)) {
                counter.set(3, counter.get(3) + 1);
            }
            if (getRank(lotto, winningLotto, bonusNumber).equals(Rank.FIFTH)) {
                counter.set(4, counter.get(4) + 1);
            }
        }
        return counter;
    }
}
