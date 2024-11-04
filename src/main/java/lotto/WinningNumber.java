package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class WinningNumber {
    private List<Integer> winningNumber;
    private int bonusNum;

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public void printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        inputWinningNumber();
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber();
    }

    public void inputWinningNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                System.out.println();
                String[] inputNum = input.split(",");
                List<Integer> winningNumber = changeType(inputNum);
                Lotto lotto = new Lotto(winningNumber);
                this.winningNumber = winningNumber;
                break; // 입력이 유효하면 루프 종료
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> changeType(String[] inputNum) {
        List<Integer> numberList = new ArrayList<>();
        for (String num : inputNum) {
            try {
                numberList.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] : 입력값이 잘못되었습니다.");
            }
        }
        return numberList;
    }

    
    public void bonusNumber() {
        while (true) {
            try {
                String inputBonus = Console.readLine();
                System.out.println();
                this.bonusNum = Integer.parseInt(inputBonus);
                break; // 입력이 유효하면 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] : 숫자만 입력해 주세요."); // 숫자가 아닐 경우
            }
        }
    }
}
