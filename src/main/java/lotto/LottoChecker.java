package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoChecker {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoChecker() {
        this.winningNumbers = new ArrayList<>();
        this.bonusNumber = 0;
    }

    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();

        convertToWinningNums(inputWinningNumbers);
        convertToBonusNum(inputBonusNumber);
        hasDuplicateNum();
    }

    public void convertToWinningNums(String input) {
        String[] inputNums = input.split(",");

        validateWinningNums(inputNums);

        try {
            for (int i = 0; i < inputNums.length; i++) {
                inputNums[i] = inputNums[i].trim();
                int winningNum = Integer.parseInt(inputNums[i]);
                winningNumbers.add(winningNum);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 입력이 감지되었습니다.");
        }
    }

    public void convertToBonusNum(String input) {
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 입력이 감지되었습니다.");
        }
    }

    public void validateWinningNums(String[] winningNums) {
        if (winningNums.length != 6) {
            throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호가 6개가 아닙니다.");
        }
    }

    public void hasDuplicateNum() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 겹칩니다.");
        }

        Set<Integer> uniqueWinningNums = new HashSet<>(winningNumbers);

        if (winningNumbers.size() != uniqueWinningNums.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 있습니다.");
        }
    }

    public List<Integer> lottoCheck(Customer customer) {
        List<Integer> totalRanks = new ArrayList<>();

        for (Lotto lotto : customer.getLottos()) {
            int count = determineRank(lotto);
            int rank = calculateRankFromCount(count);
            totalRanks.add(rank);
        }
        return totalRanks;
    }

    public int calculateRankFromCount(int rank) {
        if (rank == 15) {
            return 2;
        }

        if (rank == 6) {
            return 1;
        }

        if (rank == 5) {
            return 3;
        }

        if (rank % 10 == 4) {
            return 4;
        }

        if (rank % 10 == 3) {
            return 5;
        }

        return 0;
    }

    public int determineRank(Lotto lotto) {
        int count = 0;

        for (int i = 0; i < 6; i++) {
            int num = lotto.getNumbers().get(i);
            count = isWinningLotto(count, num);
        }

        return count;
    }

    public int isWinningLotto(int count, int num) {
        if (winningNumbers.contains(num)) {
            count++;
        }
        if (bonusNumber == num) {
            count += 10;
        }

        return count;
    }
}
