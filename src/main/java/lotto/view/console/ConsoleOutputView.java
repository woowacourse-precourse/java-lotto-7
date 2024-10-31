package lotto.view.console;


import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumber;
import lotto.dto.WinningRecipe;
import lotto.view.OutputView;

public class ConsoleOutputView implements OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ASK_MONEY = "구입금액을 입력해 주세요.";
    private static final String LOTTOS_TITLE = LINE_SEPARATOR + "%d개를 구매했습니다.";
    private static final String ASK_WINNING_NUMBER = LINE_SEPARATOR + "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = LINE_SEPARATOR + "보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT_TITLE = LINE_SEPARATOR + "당첨 통계";
    private static final String RESULT_LINE = "---";
    private static final String WINNING_RECIPE = "%d개 일치 (%,d원) - %d개";
    private static final String WINNING_RECIPE_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String PROFIT_RATIO = "총 수익률은 %,.1f%%입니다.";

    @Override
    public void printAskMoney() {
        printlnMessage(ASK_MONEY);
    }

    @Override
    public void printAskWinningNumber() {
        printlnMessage(ASK_WINNING_NUMBER);
    }

    @Override
    public void printLottoNumber(final List<LottoNumber> lottoNumbers) {
        printlnMessage(String.format(LOTTOS_TITLE, lottoNumbers.size()));
        final String message = lottoNumbers.stream()
                .map(Record::toString)
                .collect(Collectors.joining(LINE_SEPARATOR));
        printlnMessage(message);
    }

    @Override
    public void printAskBonusNumber() {
        printlnMessage(ASK_BONUS_NUMBER);
    }

    @Override
    public void printWinningResultTitle() {
        printlnMessage(WINNING_RESULT_TITLE);
        printlnMessage(RESULT_LINE);
    }

    @Override
    public void printWinningResult(final List<WinningRecipe> winningRecipes) {
        final String message = winningRecipes.stream()
                .map(this::createWinningRecipeMessage)
                .collect(Collectors.joining(LINE_SEPARATOR));
        printlnMessage(message);
    }

    @Override
    public void printProfitResult(final double ratio) {
        final String message = String.format(PROFIT_RATIO, ratio);
        printMessage(message);
    }

    private String createWinningRecipeMessage(final WinningRecipe winningRecipe) {
        String message = WINNING_RECIPE;
        if (isRankTwo(winningRecipe)) {
            message = WINNING_RECIPE_WITH_BONUS;
        }
        return String.format(message, winningRecipe.matchCount(), winningRecipe.price().intValue(),
                winningRecipe.matchQuantity());
    }

    private boolean isRankTwo(final WinningRecipe winningRecipe) {
        return winningRecipe.rank() == 2;
    }

    private void printlnMessage(final String message) {
        System.out.println(message);
    }

    private void printMessage(final String message) {
        System.out.print(message);

    }
}
