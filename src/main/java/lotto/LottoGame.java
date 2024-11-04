package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    public List<Lotto> lottos = new ArrayList<>();
    private Printer printer = new Printer();
    LottoGameValidator lottoGameValidate = new LottoGameValidator();

    int amount;
    int lottoQuantity;
    int bonusNumber;

    public void inputAmount() {
        // 로또 구매액 설정
        this.amount = lottoGameValidate.readAmount(LOTTO_PRICE);
        this.lottoQuantity = amount / LOTTO_PRICE;
        printer.printLottoPurchaseCount(lottoQuantity);     }

    public void buyLotto() {
        // 로또 구매
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> ref = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(ref); // 오름차순 정렬
            Lotto lotto = new Lotto(ref);
            lottos.add(lotto);
        }
    }

    public void setWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                printer.promptWinningNumbers();
                String input = Console.readLine();
                winningNumbers = lottoGameValidate.parseWinningNumbers(input);
                break;
            } catch (NumberFormatException e) {
                printer.printError("[ERROR] 숫자 형식이 올바르지 않습니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                printer.printError(e.getMessage());
            }
        }
        setBonusNumber(winningNumbers);
        checkWinningNumbers(winningNumbers);
    }

    public void setBonusNumber(List<Integer> winningNumbers) {
        // 보너스 번호 설정
        while (true) {
            try {
                printer.promptBonusNumber();
                int bonusNumber = Integer.parseInt(Console.readLine());
                lottoGameValidate.validateBonusNumber(bonusNumber, winningNumbers);
                this.bonusNumber = bonusNumber;
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다. 숫자로만 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void checkWinningNumbers(List<Integer> winningNumbers) {
        // 당첨 번호 비교
        List<Integer> prizeCount = new ArrayList<>(Collections.nCopies(Prize.values().length, 0));

        showMyLotto();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = countMatches(lottoNumbers, winningNumbers);
            createLottoStatistics(matchCount, lottoNumbers, prizeCount);
        }
        finalResult(prizeCount);
        profitabilityCalculation(prizeCount);
    }

    public void showMyLotto() {
        // 로또 번호 출력
        for (Lotto lotto : lottos) {
            printer.print(lotto.getNumbers().toString());
        }
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public void createLottoStatistics(int matchCount, List<Integer> lottoNumbers, List<Integer> prizeCount) {
        // 당첨 갯수 별 정리
        for (int i = 3; i <= 6; i++) {
            if (matchCount == i) {
                if (i == 6) {
                    updatePrizeCount(prizeCount, Prize.SIX_MATCH);
                }
                if (i == 5) {
                    updatePrizeCount(prizeCount, lottoNumbers.contains(bonusNumber) ? Prize.FIVE_MATCH_BONUS : Prize.FIVE_MATCH);
                }
                if (i == 4) {
                    updatePrizeCount(prizeCount, Prize.FOUR_MATCH);
                }
                if (i == 3) {
                    updatePrizeCount(prizeCount, Prize.THREE_MATCH);
                }
            }
        }
    }

    private void updatePrizeCount(List<Integer> prizeCount, Prize prize) {
        prizeCount.set(prize.ordinal(), prizeCount.get(prize.ordinal()) + 1);
    }

    public void finalResult(List<Integer> prizeCount) {
        // 결과 출력
        printer.printWinningStatistics(prizeCount);
    }

    public void profitabilityCalculation(List<Integer> prizeCount) {
        // 수익률 출력
        int totalSpent = amount;
        double yield;
        double totalRevenue = 0;

        for (Prize prize : Prize.values()) {
            totalRevenue += prize.getPrizeMoney() * prizeCount.get(prize.ordinal());
        }

        yield = (double) totalRevenue / totalSpent * 100;
        printer.printProfitability(yield);
    }
}
