package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import exception.Handler;
import exception.Message;
import io.Input;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto.Rank;

public class Collection {
    public final int NUMBER;

    private Collection(int number) {
        this.NUMBER = number;
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

    public static List<Integer> getSorted(List<Integer> target) {
        return target.stream().sorted().toList();
    }

    public static List<Integer> parsed(String input) {
        List<String> splitedInput = Stream.of(input.split(",")).toList();
        return splitedInput.stream().map(Integer::parseInt).toList();
    }

    public static Lotto getWinningLotto() {
        boolean validator = false;
        List<Integer> sortedNumbers = null;
        List<Integer> parsedInput;

        while (!validator) {
            Input input = new Input();
            String lottoInputNumbers = input.getInput();
            try {
                parsedInput = Collection.parsed(lottoInputNumbers);
            } catch (IllegalArgumentException ex) {
                Handler.handleException(lottoInputNumbers, Message.INVALID_INPUT_STRING);
                continue;
            }
            sortedNumbers = Collection.getSorted(parsedInput);
            validator = Handler.isValid(sortedNumbers);
        }
        return new Lotto(sortedNumbers);
    }

    public static int getBonusNumber(Lotto winningLotto) {
        int validator = 0;
        int bonusNumber = 0;
        List<Integer> bonusNumberContainer;

        while (validator != -1) {
            Input input = new Input();
            String inputBonusNumber = input.getInput();
            try {
                bonusNumberContainer = Collection.parsed(inputBonusNumber);
                bonusNumber = bonusNumberContainer.getFirst();
                if (bonusNumberContainer.size() != 1) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ex) {
                Handler.handleException(inputBonusNumber, Message.INVALID_RANGE);
                continue;
            }
            try {
                Lotto.checkBonusNumber(winningLotto, bonusNumber);
            } catch (IllegalArgumentException ex) {
                Handler.handleException(Integer.toString(bonusNumber), Message.INVALID_BONUS_NUMBER);
                continue;
            }
            validator = Handler.findInvalidNumber(bonusNumberContainer);
        }
        return bonusNumber;
    }



    public static List<Integer> countRank(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = Lotto.getRank(lotto, winningLotto, bonusNumber);
            ranks.add(rank);
        }
        List<Integer> counter = new ArrayList<>();
        counter.add(ranks.stream().filter(x -> x.equals(Rank.FIRST)).toList().size());
        counter.add(ranks.stream().filter(x -> x.equals(Rank.SECOND)).toList().size());
        counter.add(ranks.stream().filter(x -> x.equals(Rank.THIRD)).toList().size());
        counter.add(ranks.stream().filter(x -> x.equals(Rank.FOURTH)).toList().size());
        counter.add(ranks.stream().filter(x -> x.equals(Rank.FIFTH)).toList().size());
        return counter;
    }
}
