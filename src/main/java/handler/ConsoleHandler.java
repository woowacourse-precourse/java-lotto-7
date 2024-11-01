package handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import model.Lotto;

public class ConsoleHandler {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public static final String CANT_PARSE_INT_ERROR_MESSAGE = "int형 범위의 숫자로 입력해주세요.";

    public static int inputIntValue(String message) {
        output(message + "\n");
        final String input = Console.readLine();
        output("\n");

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(CANT_PARSE_INT_ERROR_MESSAGE);
        }
    }

    public static String inputStringValue(String message) {
        output(message + "\n");
        final String input = Console.readLine();
        output("\n");

        return input;
    }

    public static void announceBuyLottos(List<Lotto> lottos) {
        final String lottoCountAnnounceMessage = lottos.size() + "개를 구매했습니다.";
        final String lottosInfo = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));

        output(lottoCountAnnounceMessage + "\n");
        output(lottosInfo + "\n");
    }

    public static void announceError(String message) {
        output(ERROR_MESSAGE_PREFIX + message);
    }

    private static void output(final String message) {
        System.out.print(message);
    }
}
