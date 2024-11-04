package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import lotto.domains.Lotto;
import lotto.enums.ErrorCode;
import lotto.enums.LottoRank;
import lotto.service.LottoService;

public class Application {

    private static LottoService lottoService = new LottoService();
    private static List<Lotto> lottos;
    private static Lotto winningLotto = null;
    private static int bonusNumber;

    public static void main(String[] args) {
        executeUntilNoException(Application::setLottos);
        printIssueLottos();
        executeUntilNoException(Application::setWinningLotto);
        executeUntilNoException(Application::setBonusNumber);
        int[] winningCount = lottoService.getWinningCount(lottos, winningLotto, bonusNumber);
        printLottoResult(winningCount);
        printIncomePercent(winningCount);
    }

    private static void executeUntilNoException(Supplier<Void> method) {
        while (true) {
            try {
                method.get();
                break;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static Void setLottos() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        issueLottos(Console.readLine());
        return null;
    }

    private static void issueLottos(String inputValue) {
        try {
            int cost = Integer.parseInt(inputValue);
            lottos = lottoService.issueLotto(cost);
        } catch (IllegalArgumentException exception) {
            if (exception.getClass() == NumberFormatException.class) {
                throw new IllegalArgumentException(ErrorCode.NOT_NUMBERS_INPUT.getMessage());
            }

            throw exception;
        }
    }

    private static void printIssueLottos() {
        String separator = System.lineSeparator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottos.size()).append("개를 구매했습니다.").append(separator);

        for (Lotto lotto: lottos) {
            stringBuilder.append(lotto.getNumbersString()).append(separator);
        }

        System.out.println(stringBuilder.toString());
    }

    private static Void setWinningLotto() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningLotto = lottoService.setWinningLotto(Console.readLine());
        return null;
    }

    private static Void setBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputValue = Console.readLine();
        checkBonusNumber(inputValue);
        bonusNumber = Integer.parseInt(inputValue.strip());
        return null;
    }

    private static void checkBonusNumber(String inputValue) {
        try {
            int inputNumber = Integer.parseInt(inputValue.strip());
            if (1 > inputNumber || 45 < inputNumber) {
                throw new IllegalArgumentException(ErrorCode.OUT_OF_BOUNDS_LOTTO_NUMBER.getMessage());
            }
            if (winningLotto.existsNumber(inputNumber)) {
                throw new IllegalArgumentException(ErrorCode.ALREADY_EXISTS_BONUS_NUMBER.getMessage());
            }
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ErrorCode.NOT_NUMBERS_INPUT.getMessage());
        }
    }

    private static void printLottoResult(int[] winningCount) {
        String Separator = System.lineSeparator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계").append(Separator);
        stringBuilder.append("---").append(Separator);

        setResult(winningCount, stringBuilder);

        System.out.println(stringBuilder.toString());

    }

    private static void setResult(int[] winningCount, StringBuilder stringBuilder) {
        List<LottoRank> lottoRanks = setPrintLottoRanks();
        String[] resultStrings = {"3개 일치", "4개 일치", "5개 일치", "5개 일치, 보너스 볼 일치", "6개 일치"};

        for(int i = 1; i < lottoRanks.size(); i++) {
            LottoRank rank = lottoRanks.get(i);
            int prize = rank.getGetPrize();
            stringBuilder.append(resultStrings[i-1]).append(" ");
            stringBuilder.append("(").append(setPrizeString(prize)).append("원)");
            stringBuilder.append(" - ").append(winningCount[rank.ordinal()]).append("개");
            if (i != lottoRanks.size() - 1) {
                stringBuilder.append(System.lineSeparator());
            }
        }
    }

    private static List<LottoRank> setPrintLottoRanks() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        Collections.reverse(lottoRanks);

        return lottoRanks;
    }

    private static String setPrizeString(int prize) {
        StringBuilder stringBuilder = new StringBuilder();
        String prizeString = Integer.toString(prize);

        for (int i = 0; i < prizeString.length(); i++) {
            stringBuilder.append(prizeString.charAt(i));
            if (i % 3 == (prizeString.length() + 2) % 3 && i != prizeString.length() - 1) {
                stringBuilder.append(",");
            }
        }

        return stringBuilder.toString();
    }

    private static void printIncomePercent(int[] winningCount) {
        int issueCost = lottos.size() * lottoService.getLottoCost();
        long income = lottoService.getWinningCost(winningCount);
        double incomePercent = Math.round((double)income / issueCost * 100 * 100) / 100.0;

        System.out.println("총 수익률은 " + incomePercent + "%입니다.");
    }
}
