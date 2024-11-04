package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public int inputPurchaseAmount() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(reader.readLine());
    }

    public List<Integer> inputLottoNumbers() throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = reader.readLine();
        return parseLottoNumbers(input);
    }

    public int inputBonusNumber() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(reader.readLine());
    }

    private List<Integer> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
