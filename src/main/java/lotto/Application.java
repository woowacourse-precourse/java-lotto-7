package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        int betAmount = validateBetAmount();
        int attempts = getAttempts(betAmount);
        List<List<Integer>> entryLists = printEntries(attempts);
        List<Integer> lottoNumbers = enterLottoNumbers();
        int bonusNumber = enterBonusNumber(lottoNumbers);
        EnumMap<LottoResults, Integer> calculator = resetEnumMap();
        printResults(entryLists, lottoNumbers, bonusNumber, attempts, calculator);
        printReturnRate(betAmount, calculator);
    }

    private static int validateBetAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        int betAmount = Integer.parseInt(input);
        if (betAmount < 1000) {
            throw new IllegalArgumentException("베팅 금액이 1000원 미만입니다");
        }
        if (betAmount % 1000 != 0) {
            throw new IllegalArgumentException("베팅 금액이 1000원 단위가 아닙니다");
        }
        return betAmount;
    }

    private static int getAttempts(int betAmount) {
        int attempts = betAmount / 1000;
        System.out.println(attempts + "개를 구매했습니다.");
        return attempts;
    }

    private static List<List<Integer>> printEntries(int attempts) {
        List<List<Integer>> entryLists = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            List<Integer> entries;
            entries = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            entries.sort(Comparator.naturalOrder());
            entryLists.add(entries);
        }
        for (int j = 0; j < attempts; j++) {
            System.out.println(entryLists.get(j));
        }
        return entryLists;
    }

    private static List<Integer> enterLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        for (String number : splitInput) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        lottoNumbers.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(lottoNumbers);
        return lottoNumbers;
    }

    private static int enterBonusNumber(List<Integer> enterLottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        boolean containNumber = enterLottoNumbers.contains(bonusNumber);
        if (containNumber) {
            throw new IllegalArgumentException("당첨 번호와 중복된 숫자입니다");
        }
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("보너스 숫자는 1 이상, 45 이하입니다.");
        }
        return bonusNumber;
    }

    public static EnumMap<LottoResults, Integer> resetEnumMap() {
        EnumMap<LottoResults, Integer> calculator = new EnumMap<>(LottoResults.class);
        for (LottoResults result : LottoResults.values()) {
            calculator.put(result, 0);
        }
        return calculator;
    }

    private static void printResults(List<List<Integer>> entryLists, List<Integer> lottoNumbers, int bonusNumber,
                                     int attempts, EnumMap<LottoResults, Integer> calculator) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < attempts; i++) {
            List<Integer> matchedNumbers = new ArrayList<>(entryLists.get(i));
            matchedNumbers.retainAll(lottoNumbers);
            checkNumbers(i, matchedNumbers, calculator, entryLists, bonusNumber);
        }
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        for (LottoResults result : LottoResults.values()) {
            String formattedPrize = formatter.format(result.getPrize());
            System.out.println(
                    result.getHowMany() + " (" + formattedPrize + "원) : " + calculator.get(result) + "개");
        }
    }

    private static void checkNumbers(int i, List<Integer> matchedNumbers,
                                     EnumMap<LottoResults, Integer> calculator,
                                     List<List<Integer>> entryLists, int bonusNumber) {
        if (matchedNumbers.size() == 3) {
            updateResults(calculator, LottoResults.THREE_MATCH);
        }
        if (matchedNumbers.size() == 4) {
            updateResults(calculator, LottoResults.FOUR_MATCH);
        }
        if (matchedNumbers.size() == 5) {
            checkBonus(i, entryLists, bonusNumber, calculator, matchedNumbers);
        }
        if (matchedNumbers.size() == 6) {
            updateResults(calculator, LottoResults.SIX_MATCH);
        }
    }

    private static void updateResults(EnumMap<LottoResults, Integer> calculator, LottoResults result) {
        calculator.put(result, calculator.get(result) + 1);
    }

    private static void checkBonus(int i, List<List<Integer>> entryLists, int bonusNumber,
                                   EnumMap<LottoResults, Integer> calculator, List<Integer> matchedNumbers) {
        if (matchedNumbers.size() == 5 && entryLists.get(i).contains(bonusNumber)) {
            updateResults(calculator, LottoResults.FIVE_BONUS_MATCH);
        }
        if (matchedNumbers.size() == 5 && !entryLists.get(i).contains(bonusNumber)) {
            updateResults(calculator, LottoResults.FIVE_MATCH);
        }
    }

    private static void printReturnRate(int betAmount, EnumMap<LottoResults, Integer> calculator) {
        int sum = 0;
        for (LottoResults result : LottoResults.values()) {
            sum += result.getPrize() * calculator.get(result);
        }
        double returnRate = (double) sum / betAmount;
        returnRate = Math.round(returnRate * 100.0) / 100.0;
        System.out.println("총 수익률은 : " + returnRate + "%입니다");
    }

}