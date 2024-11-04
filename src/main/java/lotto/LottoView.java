package lotto;

import java.util.List;

public interface LottoView {
    void displayMessage(String message);
    String getInput(String prompt);
    void displayResults(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, List<Integer> bonusNumbers, double profit);
}
