package lotto.util;

import static lotto.constant.core.ParserConstant.*;
import static lotto.constant.message.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.domain.Lotto;

public class Parser {

    public static Integer parseInputToInt(String input) {
        String trimmedInput = trimWhitespace(input);
        return convertStringToInteger(trimmedInput);
    }

    public static List<Integer> parseInputsToIntList(String inputs) {
        List<Integer> parsedInputs = new ArrayList<>();
        List<String> separatedInputs = separateBySeparator(inputs);
        for (String input : separatedInputs) {
            String trimmedInput = trimWhitespace(input);
            Integer convertedInput = convertStringToInteger(trimmedInput);
            parsedInputs.add(convertedInput);
        }
        return parsedInputs;
    }

    public static List<String> formatLottoTickets(List<Lotto> lottoTickets, String joiner) {
        List<String> formattedLottoTickets = new ArrayList<>();
        for (Lotto lottoTicket : lottoTickets) {
            String formattedLottoTicket = formatLottoTicket(lottoTicket, joiner);
            formattedLottoTickets.add(formattedLottoTicket);
        }
        return formattedLottoTickets;
    }

    private static String trimWhitespace(String input) {
        return input.trim();
    }

    private static Integer convertStringToInteger(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_NULL.getMessage());
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.getMessage());
        }
    }

    private static List<String> separateBySeparator(String inputs) {
        String[] separatedInputs = inputs.split(PLURAL_INPUT_SEPARATOR.getStringValue());
        return Arrays.asList(separatedInputs);
    }

    private static String formatLottoTicket(Lotto lottoTicket, String joiner) {
        String joinedNumbers = String.join(joiner, lottoTicket.getStringNumbers());
        return "[" + joinedNumbers + "]";
    }
}
