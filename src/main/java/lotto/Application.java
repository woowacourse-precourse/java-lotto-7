package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import javax.management.openmbean.OpenDataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.constant.*;

public class Application {
    public static void main(String[] args) {
        int lottoTickets = inputPayment();
        List<Lotto> lottos = drawLottos(lottoTickets);
        printLottos(lottoTickets, lottos);
        List<Integer> winningNumbers =  setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);
        Map<LottoRank, Integer> rankCounts = matchLottos(lottos, winningNumbers, bonusNumber);

        for (LottoRank rank : LottoRank.values()) {
            System.out.println(rank + " (" + rank.getPrize() + "원) - " + rankCounts.get(rank) + "개");
        }


    }

    public static int inputPayment(){
        System.out.println(PAYMENT_MASSAGE);
        int payment = Integer.parseInt(Console.readLine());
        validatePayment(payment);
        return payment/LOTTOPRICE;
    }

    public static void validatePayment(int payment){
        if(payment % LOTTOPRICE != 0) {
            throw new IllegalArgumentException(PAYMENT_ERROR);
        }
    }

    public static List<Lotto> drawLottos(int lottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, NUMBER_SIZE).stream()
                    .sorted()
                    .collect(Collectors.toList())));
        }
        return lottos;
    }

    public static void printLottos(int tickets, List<Lotto> lottos) {
        System.out.println();
        System.out.println(tickets + TICKETS_PRINT);
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Integer> setWinningNumbers(){
        System.out.println();
        System.out.println(SET_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateWinningNumberInput(input);
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            splitInput(input, winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_ERROR);
        }

        return winningNumbers;
    }

    public static void validateWinningNumberInput(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(EMPTY_ERROR);
        }
        if (input.startsWith(",") || input.endsWith(",") || input.contains(",,")){
            throw new IllegalArgumentException(REST_ERROR);
        }
    }

    public static void splitInput(String input, List<Integer> winningNumbers) {
        for (String num : input.split(",")) {
            int number = Integer.parseInt(num);
            validateNumberRange(number);
            validateNumberDuplicate(winningNumbers, number);
            winningNumbers.add(number);
        }
        validateNumberSize(winningNumbers);
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(OUTOFRANGE_ERROR);
        }
    }

    public static void validateNumberDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)){
            throw new IllegalArgumentException(DUPLICATING_ERROR);
        }
    }

    public static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBERSIZE_ERROR);
        }
    }

    public static Integer setBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        System.out.println(SET_BONUS_NUMBER_MESSAGE);
        int number;
        try{
            number = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_ERROR);
        }
        validateNumberRange(number);
        validateNumberDuplicate(winningNumbers,number);

        return number;
    }

    public static Map<LottoRank, Integer> matchLottos(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }

        for (Lotto lotto : lottos){
            LottoRank rank = matchRank(lotto, winningNumbers, bonusNumber);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        return rankCounts;
    }

    public static LottoRank matchRank(Lotto lotto,List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers);
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    public static void printResult (List<LottoRank> lottoRanks) {
        System.out.println("당첨 통계");

    }
}
