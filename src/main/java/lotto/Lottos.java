package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import exception.Handler;
import exception.Message;
import io.Input;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto.Rank;

/**
 * 구입한 로또 리스트를 관리
 */
public class Lottos {
    public final int lottoQuantity;

    private Lottos(int number) {
        this.lottoQuantity = number;
    }

    /**
     * 로또 발행
     * @param quantity 발행할 로또의 수
     * @return 로또 리스트
     */
    public static List<Lotto> getLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
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
        List<String> splitedInput = Stream.of(input.split(io.Input.SPLITTER)).toList();
        return splitedInput.stream().map(Integer::parseInt).toList();
    }

    /**
     * split, parse 과정에 문제가 없다면 정렬된 로또 당첨 번호를 반환
     * @return 로또 당첨 번호
     */
    public static Lotto getWinningLotto() {
        boolean validator = false;
        List<Integer> sortedNumbers = null;
        List<Integer> parsedInput;

        while (!validator) {
            Input input = new Input();
            String lottoInputNumbers = input.getInput();
            try {
                parsedInput = Lottos.parsed(lottoInputNumbers);
            } catch (IllegalArgumentException ex) {
                Handler.handleException(lottoInputNumbers, Message.INVALID_INPUT_STRING);
                continue;
            }
            sortedNumbers = Lottos.getSorted(parsedInput);
            validator = Handler.isValid(sortedNumbers);
        }
        return new Lotto(sortedNumbers);
    }

    /**
     * 키보드 입력과 당첨 번호를 비교해 문제가 없다면 보너스 번호 반환
     * @param winningLotto 입력된 당첨 번호
     * @return 보너스 번호
     */
    public static int getBonusNumber(Lotto winningLotto) {
        int validator = 0;
        int bonusNumber = 0;
        List<Integer> bonusNumberContainer;

        while (validator != -1) {
            Input input = new Input();
            String inputBonusNumber = input.getInput();
            try {
                bonusNumberContainer = Lottos.parsed(inputBonusNumber);
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

    /**
     * 로또 리스트로부터 각 등수를 몇번 획득했는지 반환
     * @param lottos 로또 리스트
     * @param winningLotto 당첨 번호
     * @param bonusNumber 보너스 번호
     * @return 등수별 획득 횟수를 계산한 리스트
     */
    public static List<Integer> countRank(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = Lotto.getRank(lotto, winningLotto, bonusNumber);
            ranks.add(rank);
        }
        List<Integer> counter = new ArrayList<>();
        List<Rank> entireRanks = List.of(Rank.FIRST,Rank.SECOND,Rank.THIRD,Rank.FOURTH,Rank.FIFTH);
        for (Rank rank: entireRanks) {
            counter.add(ranks.stream().filter(x -> x.equals(rank)).toList().size());
        }
        return counter;
    }

    /**
     * 등수별 당첨 횟수를 입력받아 총 당첨금("횟수*등수별 당첨금"의 합)을 반환
     * @param rank 등수별 당첨 횟수 리스트
     * @return 획득 금액
     */

    public static int getGainedMoney(List<Integer> rank) {
        int gainedMoney = 0;
        for (int i = 0; i < rank.size(); i++) {
            gainedMoney += rank.get(i) * lotto.Lotto.PRIZE_MONEY.get(i);
        }
        return gainedMoney;
    }

    public static float getRateOfReturn(int gainedMoney, int lottoQuantity) {
        return (float) gainedMoney / lottoQuantity / lotto.Lotto.Price.PRICE * 100;
    }

    /**
     * 로또 결과를 반환
     * @param rank 등수별 당첨 횟수
     * @param lottoQuantity 구입한 로또 개수
     * @return 결과로 출력할 문자열을 반환
     */
    public static String getResult(List<Integer> rank, int lottoQuantity) {
        int gainedMoney = Lottos.getGainedMoney(rank);
        float rateOfReturn = Lottos.getRateOfReturn(gainedMoney, lottoQuantity);

        List<String> valueWithComma = Lotto.PRIZE_MONEY_WITH_COMMA;
        return io.Print.RESULT.formatted(valueWithComma.get(4), rank.get(4), valueWithComma.get(3), rank.get(3),
                valueWithComma.get(2), rank.get(2), valueWithComma.get(1), rank.get(1), valueWithComma.get(0),
                rank.get(0), rateOfReturn);
    }

}
