package lotto;

import java.util.List;

public class WinningNumbers {
    //당첨번호와 보너스 번호 관리, 사용자 번호와 일치하는 개수 계산
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    private void validate(List<Integer> winningNumbers, int bonusNumber){
        if(winningNumbers.size() !=6 || winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
    public int countMatchingNumbers(List<Integer> numbers){
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }
}
