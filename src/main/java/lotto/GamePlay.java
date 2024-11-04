package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class GamePlay {

    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";
    private static final String LIST_START = "[";
    private static final String LIST_END = "]";
    private static final String COMMA = ", ";
    private static final String LINE_BREAK = "\n";

    private final List<Lotto> lottos = new ArrayList<>();
    private int useMoneys;
    private Lotto winningLotto;
    private int bonusNumber;

    public GamePlay() {
        inputMoney();
        buyLotto();
        pickWinningLotto();
        pickBonusNumber();
        displayResult();
    }

    private void pickBonusNumber() {
        while (true){
            try {
                System.out.println("보너스 번호를 입력해주세요.");
                String input = Console.readLine();

                validateBonusNumber(input);
                bonusNumber = Integer.parseInt(input);
                return;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(String input) {
        try{
            int number = Integer.parseInt(input);
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 번호 사이의 숫자만 입력 가능합니다.");
            }

            validateDuplicateBonusNumber(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateDuplicateBonusNumber(int number) {
        if(winningLotto.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않는 숫자만 입력 가능합니다.");
        }
    }

    private void pickWinningLotto() {
        while(true) {
            try {
                System.out.println("당첨 번호 6자리를 입력해주세요. (,) 쉼표를 기준으로 구분됩니다.");
                String input = Console.readLine();

                winningLotto = new Lotto(validatePickWinnigLotto(input));
                return;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> validatePickWinnigLotto(String input) {
        try {
            List<Integer> winningNumbers = stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            return winningNumbers;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void inputMoney() {
        while(true) {
            try {
                System.out.println("로또 구입 금액을 입력해주세요. 단, 1000원 단위로 입력해주세요.");
                String input = Console.readLine();

                validateMoney(input);
                useMoneys = Integer.parseInt(input);
                return;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMoney(String money) {
        try{
            int ret = Integer.parseInt(money);
            if(ret <= 0 || ret % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 입력할 수 있습니다.");
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void buyLotto() {
        for(int i=0; i<useMoneys / LOTTO_PRICE; i++){
            lottos.add(pickLotto());
        }

        printLottos();
    }

    private Lotto pickLotto(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void printLottos() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size()).append("개를 구매했습니다.\n");

        for(Lotto lotto : lottos){
            sb.append(LIST_START);
            List<Integer> numbers = lotto.getNumbers();
            sb.append(numbers.getFirst());
            for(int i=1; i<numbers.size(); i++){
                sb.append(COMMA).append(numbers.get(i));
            }
            sb.append(LIST_END).append(LINE_BREAK);
        }

        System.out.println(sb);
    }

    private Map<Rank, Integer> calculateLotto() {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for(Rank rank : Rank.values()){
            results.put(rank, 0);
        }

        for(Lotto lotto : lottos){
            Rank rank = calculateRank(lotto);
            if(rank != null){
                results.put(rank, results.get(rank) + 1);
            }
        }

        return results;
    }

    private Rank calculateRank(Lotto lotto) {
        int matchCount = 0;
        boolean matchBonus = false;
        for(int number : winningLotto.getNumbers()){
            if(lotto.contains(number)){
                matchCount++;
            }
        }

        if(lotto.contains(bonusNumber)) matchBonus = true;

        return Rank.valueOf(matchCount, matchBonus);
    }

    private void displayResult() {
        Map<Rank, Integer> lottoResult = calculateLotto();

        displayWinningStatics(lottoResult);
        displayProfitRate(lottoResult);
    }

    private void displayWinningStatics(Map<Rank, Integer> lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(LINE_BREAK).append("당첨 통계").append(LINE_BREAK)
                .append("---").append(LINE_BREAK);

        Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::getPrize).reversed())
                .forEach(rank -> sb.append(rank.getDescription())
                        .append(" - ").append(lottoResult.get(rank))
                        .append("개").append(LINE_BREAK));

        System.out.println(sb);
    }

    private void displayProfitRate(Map<Rank, Integer> lottoResult) {
        long totalPrize = calculatePrize(lottoResult);
        double profitRate = calculateProfitRate(totalPrize);

        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private long calculatePrize(Map<Rank, Integer> lottoResult) {
        long totalPrize = 0;
        for(Rank rank : lottoResult.keySet()){
            totalPrize += rank.getPrize() * lottoResult.get(rank);
        }

        return totalPrize;
    }

    private double calculateProfitRate(long totalPrize) {
        return  (totalPrize * 100.0) / useMoneys;
    }
}
