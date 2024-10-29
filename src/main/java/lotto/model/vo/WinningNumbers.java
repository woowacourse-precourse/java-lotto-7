package lotto.model.vo;

import lotto.util.LottoUtils;

public record WinningNumbers(int[] nums) { 

    private static final String MESSAGE = "당첨 번호는";

    public static WinningNumbers fromString(String input) {
        String[] winnigNumbers = LottoUtils.splitInput(input); 
        
        LottoUtils.validateInputNumbersCount(winnigNumbers,MESSAGE); 
        int[] nums = new int[winnigNumbers.length]; 

        for (int i = 0; i < winnigNumbers.length; i++) {
            LottoUtils.validatePositiveNumber(winnigNumbers[i],MESSAGE); 
            nums[i] = Integer.parseInt(winnigNumbers[i]);
            LottoUtils.validateNumberRange(nums[i],MESSAGE);
        }

        return new WinningNumbers(nums); 
    }
}
