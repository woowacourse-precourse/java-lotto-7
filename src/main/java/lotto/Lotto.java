package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import exception.Message;
import java.util.ArrayList;
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
        this.numbers = numbers;
        this.price = new Price();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            exception.Message message = new exception.Message(Stream.of(numbers).toString());
            String exceptionMessage = message.getMessage(Message.INVALID_CHOICE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static List<Lotto> getLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0;i<number;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = numbers.stream().sorted().toList();
            lottos.add(new Lotto(sortedNumbers));
        }

        return lottos;
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
        io.Print printMessage = new io.Print(lotto.numbers.toString());
        printMessage.print();
    }
    }



    public class Price {
        public final static int PRICE = 1000;
    }// TODO: 추가 기능 구현
}
