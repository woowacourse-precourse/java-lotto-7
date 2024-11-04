package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }
    
    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) { // 기존 size와 중복 제거 코드 실행 후 size의 차이를 확인
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
    
    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    
    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    
    // TODO: 추가 기능 구현
    
    public List<Integer> getNumbers() {
        return numbers;
    }
    
    public void printLottoNumbers() {
        System.out.println(numbers.toString());
    }
    
    public void checkWinningLotto(List<Lotto> generatedLottos, Integer bonusLottoNumber, Integer purchaseMoney) {
        Map<Rank, Integer> rankCount = initializeRankCount();
        Integer totalWinningMoney = calculateTotalWinningMoney(generatedLottos, bonusLottoNumber, rankCount);
        printWinningStatistics(rankCount, purchaseMoney, totalWinningMoney);
    }
    
    private Map<Rank, Integer> initializeRankCount() {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> rankCount.put(rank, 0));
        return rankCount;
    }
    
    private Integer calculateTotalWinningMoney(List<Lotto> generatedLottos, Integer bonusLottoNumber,
            Map<Rank, Integer> rankCount) {
        Integer totalWinningMoney = 0;
        
        for (Lotto lotto : generatedLottos) {
            Rank rank = calculateRank(lotto, bonusLottoNumber);
            totalWinningMoney += addWinningResult(rank, rankCount);
        }
        
        return totalWinningMoney;
    }
    
    private Rank calculateRank(Lotto lotto, Integer bonusLottoNumber) {
        List<Integer> userLotto = lotto.getNumbers();
        int matchCount = calculateMatchCount(userLotto);
        boolean matchBonus = userLotto.contains(bonusLottoNumber);
        
        return Rank.valueOf(matchCount, matchBonus);
    }
    
    private int calculateMatchCount(List<Integer> userLotto) {
        return (int) userLotto.stream()
                .filter(userNumber -> numbers.contains(userNumber))
                .count();
    }
    
    private int addWinningResult(Rank rank, Map<Rank, Integer> rankCount) {
        if (rank == Rank.NONE) {
            return 0;
        }
        rankCount.put(rank, rankCount.get(rank) + 1);
        return rank.getPrizeMoney();
    }
    
    private void printWinningStatistics(Map<Rank, Integer> rankCount, Integer purchaseMoney, Integer totalWinningMoney) {
        printWinningResults(rankCount);
        printProfitRate(purchaseMoney, totalWinningMoney);
    }
    
    private void printWinningResults(Map<Rank, Integer> rankCount) {
        rankCount.forEach((rank, count) ->
                System.out.printf("%s (%,d원) - %d개\n", rank.getDescription(), rank.getPrizeMoney(), count));
    }
    
    private void printProfitRate(Integer purchaseMoney, Integer totalWinningMoney) {
        double profitRate = calculateProfitRate(purchaseMoney, totalWinningMoney);
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", profitRate);
    }
    
    private double calculateProfitRate(Integer purchaseMoney, Integer totalWinningMoney) {
        return (totalWinningMoney / (double) purchaseMoney) * 100;
    }
}
