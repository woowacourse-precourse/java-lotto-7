package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPresenter {
    private final LottoView view;
    private final LottoModel model;

    public LottoPresenter(LottoView view, LottoModel model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        try {
            int totalPrice = getTotalPrice();
            model.setTotalPrice(totalPrice);
            view.displayMessage(model.getLottoAmount() + "개를 구매했습니다");

            List<List<Integer>> lottoNumbers = model.generateLottoNumbers();
            lottoNumbers.forEach(number -> view.displayMessage(number.toString()));

            List<Integer> winningNumbers = getWinningNumbers();
            List<Integer> bonusNumbers = getBonusNumbers();
            int[] prizeCounts = calculatePrizes(lottoNumbers, winningNumbers, bonusNumbers);

            double profit = model.calculateProfit(prizeCounts);
            view.displayResults(lottoNumbers, winningNumbers, bonusNumbers, profit);
        } catch (Exception e) {
            view.displayMessage(e.getMessage());
        }
    }

    private int getTotalPrice() {
        String input = view.getInput("구입금액을 입력해 주세요.");
        validateTotalPrice(input);
        return Integer.parseInt(input);
    }

    private void validateTotalPrice(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해야 합니다.");
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        int price = Integer.parseInt(input);
        if (price < 1000 || price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    private List<Integer> getWinningNumbers() {
        String input = view.getInput("\n당첨 번호를 입력해 주세요.");
        String[] parts = input.split(",");
        validateWinningNumbers(parts);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String part : parts) {
            winningNumbers.add(Integer.parseInt(part.trim()));
        }
        return winningNumbers;
    }

    private void validateWinningNumbers(String[] parts) {
        if (parts.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (String part : parts) {
            int number = Integer.parseInt(part.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private List<Integer> getBonusNumbers() {
        String input = view.getInput("\n보너스 번호를 입력해 주세요.");
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해야 합니다.");
        }
        String[] parts = input.split(",");
        List<Integer> bonusNumbers = new ArrayList<>();
        for (String part : parts) {
            bonusNumbers.add(Integer.parseInt(part.trim()));
        }
        return bonusNumbers;
    }

    private int[] calculatePrizes(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, List<Integer> bonusNumbers) {
        int[] prizeCounts = new int[5];
        for (List<Integer> userLotto : lottoNumbers) {
            long matchCount = userLotto.stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = userLotto.stream().anyMatch(bonusNumbers::contains);
            updatePrizeCounts(matchCount, bonusMatch, prizeCounts);
        }
        return prizeCounts;
    }

    private void updatePrizeCounts(long matchCount, boolean bonusMatch, int[] prizeCounts) {
        switch ((int) matchCount) {
            case 6 -> prizeCounts[0]++;
            case 5 -> {
                if (bonusMatch) {
                    prizeCounts[1]++;
                } else {
                    prizeCounts[2]++;
                }
            }
            case 4 -> prizeCounts[3]++;
            case 3 -> prizeCounts[4]++;
        }
    }
}
