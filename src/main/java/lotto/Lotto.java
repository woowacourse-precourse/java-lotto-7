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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        
        if (numbers.size() != numbers.stream().distinct().count()) { // 기존 size와 중복 제거 코드 실행 후 size의 차이를 확인
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
    
    // TODO: 추가 기능 구현
    
    public List<Integer> getNumbers() {
        return numbers;
    }
    
    public void printLottoNumbers() {
        System.out.println(numbers.toString());
    }
    
    public void checkWinningLotto(List<Lotto> generatedLottos, Integer bonusLottoNumber) {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> rankCount.put(rank, 0));
        
        for (Lotto lotto : generatedLottos) {
            List<Integer> userLotto = lotto.getNumbers();
            int matchCount = (int) userLotto.stream()
                    .filter(userNumber -> numbers.contains(userNumber))
                    .count();
            
            boolean matchBonus = userLotto.contains(bonusLottoNumber);
            
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            
            if (rank != Rank.NONE) {
                rankCount.put(rank, rankCount.get(rank) + 1);
            }
        }
    }
}
