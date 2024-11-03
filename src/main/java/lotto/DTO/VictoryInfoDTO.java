package lotto.DTO;

import java.util.List;

public class VictoryInfoDTO {
    private final List<Integer> victoryNumbers;
    private final int bonusNumber;

    public VictoryInfoDTO(List<Integer> victoryNumbers, int bonusNumber) {
        this.victoryNumbers = victoryNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getVictoryNumbers() {
        return victoryNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
