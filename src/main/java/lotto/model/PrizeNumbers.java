package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PrizeNumbers {

    private List<Integer> prizeNumberList;

    public PrizeNumbers(String prizeNumbersInput) {
        hasSpecialCharAnotherComma(prizeNumbersInput);
        hasConsecutiveCommas(prizeNumbersInput);


        settingToInstance(prizeNumbersInput);
        prizeNumberSizeCheck();
        prizeNumberListLengthCheck();
        hasSameNumber();
    }

    private void hasConsecutiveCommas(String prizeNumbersInput) {
        if (prizeNumbersInput.startsWith(",") || prizeNumbersInput.endsWith(",") || prizeNumbersInput.matches(".*,,.*")) {
            throw new IllegalArgumentException("[ERROR] 양 끝에 ,가 있거나 ,가 연속으로 2개가 있는지 확인해주세요");
        }
    }

    /**
     * , 외에 특수문자가 입력값에 존재하는지
     * 당첨 번호만을 점검하는 용도
     *
     * @param prizeNumbersInput
     */
    private void hasSpecialCharAnotherComma(String prizeNumbersInput) {
        prizeNumbersInput = prizeNumbersInput.replaceAll("\\s", "");
        Pattern prizePattern = Pattern.compile("[^,0-9]");

        if (prizePattern.matcher(prizeNumbersInput).find()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에는 ,와 숫자값만 입력해주세요");
        }
    }

    private void prizeNumberSizeCheck() {
        for (Integer prizeNum : this.prizeNumberList) {
            if (prizeNum > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 45를 넘을 수 없습니다.");
            }
        }
    }

    private void prizeNumberListLengthCheck() {
        if (prizeNumberList.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개의 숫자가 있어야합니다.");
        }
    }

    private void settingToInstance(String prizeNumbersInput) {
        this.prizeNumberList = Arrays.stream(prizeNumbersInput.split(","))
                .mapToInt(prizeNum -> {
                    return Integer.parseInt(prizeNum.trim());
                })
                .boxed()
                .toList();

    }

    private void hasSameNumber() {
        if (prizeNumberList.stream().distinct().count() != prizeNumberList.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호중 동일한 번호가 존재합니다");
        }
    }

    public List<Integer> getPrizeNumberList() {
        return prizeNumberList;
    }

}
