package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PrizeNumbers {

    private List<Integer> prizeNumberList;

    private Integer bonusPrizeNumber;

    public PrizeNumbers(String prizeNumbersInput, String bonusPrizeNumber) {
        hasSpecialCharAnotherComma(prizeNumbersInput);
        bonusValidation(bonusPrizeNumber);
        hasConsecutiveCommas(prizeNumbersInput);

        settingToInstance(prizeNumbersInput, bonusPrizeNumber);

        bonusSizeCheck();
        prizeNumberSizeCheck();
        prizeNumberListLengthCheck();

        hasSameNumberCheckPrizeAndBonus();
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

    /**
     * 당첨번호와 보너스 번호를 통합해서 같은번호가 존재하는지
     */
    private void hasSameNumberCheckPrizeAndBonus() {
        if (prizeNumberList.stream().distinct().count() != prizeNumberList.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호중 동일한 번호가 존재합니다");
        }

        for (int i = 0; i < prizeNumberList.size(); i++) {
            if (prizeNumberList.get(i).equals(bonusPrizeNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호 중 하나와 동일합니다.");
            }
        }
    }

    /**
     * 보너스 번호는 단일 숫자여야한다.
     * 때문에 정규식에서 숫자값이 아니면 죄다 예외를 던져야한다.
     *
     * @param bonusPrizeNumber
     */
    private void bonusValidation(String bonusPrizeNumber) {
        bonusPrizeNumber = bonusPrizeNumber.replaceAll("\\s", "");
        Pattern bonusPattern = Pattern.compile("[\\D]");
        if (bonusPattern.matcher(bonusPrizeNumber).find()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자값만 입력해야합니다.");
        }
    }

    private void bonusSizeCheck() {
        if (this.bonusPrizeNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 45를 넘을 수 없습니다.");
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

    private void settingToInstance(String prizeNumbersInput, String bonusPrizeNumber) {
        this.prizeNumberList = Arrays.stream(prizeNumbersInput.split(","))
                .mapToInt(prizeNum -> {
                    return Integer.parseInt(prizeNum.trim());
                })
                .boxed()
                .toList();

        this.bonusPrizeNumber = Integer.parseInt(bonusPrizeNumber.replaceAll("\\s", ""));
    }

    public List<Integer> getPrizeNumberList() {
        return prizeNumberList;
    }

    public Integer getBonusPrizeNumber() {
        return bonusPrizeNumber;
    }
}
