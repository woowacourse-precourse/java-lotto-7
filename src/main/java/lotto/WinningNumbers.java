package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbers() {
        List<Integer> winningNumbers = inputWinningNumbers();
        Integer bonusNumber = inputBonusNumbers();

        validateNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        for(Integer winningNumber : winningNumbers){
            if(winningNumber.equals(bonusNumber)){
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않는 숫자로 이루어져야합니다.");
            }
        }
    }

    private List<Integer> inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        System.out.println();

        List<Integer> winningNumbers = validateWinningNumbersInputFormat(inputWinningNumbers);

        validateWinningNumbersLength(winningNumbers);
        validateWinningNumbersDuplicate(winningNumbers);

        return winningNumbers;
    }

    private List<Integer> validateWinningNumbersInputFormat(String inputWinningNumbers) {
        String[] inputWinningNumbersArray = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(String inputWinningNumber : inputWinningNumbersArray) {
            try {
                Integer.parseInt(inputWinningNumber.trim());
                winningNumbers.add(Integer.parseInt(inputWinningNumber));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 ,로 구분된 숫자로 이루어져야 합니다.");
            }
        }
        return winningNumbers;
    }

    private void validateWinningNumbersDuplicate(List<Integer> winningNumbers) {
        if(winningNumbers.size() != winningNumbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 숫자로 이루어져야합니다.");
        }
    }

    private void validateWinningNumbersLength(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 이루어져야합니다.");
        }
    }

    private Integer inputBonusNumbers(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        System.out.println();

        Integer bonusNumber;
        bonusNumber = validateBonusNumber(inputBonusNumber);
        return bonusNumber;
    }

    private Integer validateBonusNumber(String inputBonusNumber){
        if(inputBonusNumber.length() != 1 && !Character.isDigit(inputBonusNumber.charAt(0))){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1자리 숫자로 이루어져야합니다.");
        }
        return Integer.parseInt(inputBonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public String toString() {
        return winningNumbers.toString() + " " + bonusNumber;
    }
}
