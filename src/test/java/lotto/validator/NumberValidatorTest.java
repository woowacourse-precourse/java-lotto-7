package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    private NumberValidator numberValidator = new NumberValidator();

    @Test
    @DisplayName("당첨 번호 입력 검증 테스트")
    void testValidateWinningNumbers() {
        String wrongInput1 = "";
        String wrongInput2 = " ";
        String wrongInput3 = "1,45,4,5";
        String wrongInput4 = "abcd";
        String wrongInput5 = "1,2,3,4,5,46";
        String wrongInput6 = "1,2,3,4,5,6,7";
        String wrongInput7 = "1;2;3;4;5;6";
        String wrongInput8 = "a,b,c,d,e,f";
        String wrongInput9 = "1,2,3,4,5,-6";
        String wrongInput10 = "1,2,3,4,5,5";
        String wrongInput11 = "1,2,3,4,5,\t6";
        String wrongInput12 = "1,2,3,4,5,@";
        String wrongInput13 = "1,2,3,4,5,,6";

        String rightInput1 = "1,10,20,30,40,45";
        String rightInput2 = "1, 15, 25, 35,40 ,45 ";
        String rightInput3 = "1,2,3,4,5,6,";

        boolean wrongResult1 = numberValidator.validateWinningNumbers(wrongInput1);
        boolean wrongResult2 = numberValidator.validateWinningNumbers(wrongInput2);
        boolean wrongResult3 = numberValidator.validateWinningNumbers(wrongInput3);
        boolean wrongResult4 = numberValidator.validateWinningNumbers(wrongInput4);
        boolean wrongResult5 = numberValidator.validateWinningNumbers(wrongInput5);
        boolean wrongResult6 = numberValidator.validateWinningNumbers(wrongInput6);
        boolean wrongResult7 = numberValidator.validateWinningNumbers(wrongInput7);
        boolean wrongResult8 = numberValidator.validateWinningNumbers(wrongInput8);
        boolean wrongResult9 = numberValidator.validateWinningNumbers(wrongInput9);
        boolean wrongResult10 = numberValidator.validateWinningNumbers(wrongInput10);
        boolean wrongResult11 = numberValidator.validateWinningNumbers(wrongInput11);
        boolean wrongResult12 = numberValidator.validateWinningNumbers(wrongInput12);
        boolean wrongResult13 = numberValidator.validateWinningNumbers(wrongInput13);

        boolean rightResult1 = numberValidator.validateWinningNumbers(rightInput1);
        boolean rightResult2 = numberValidator.validateWinningNumbers(rightInput2);
        boolean rightResult3 = numberValidator.validateWinningNumbers(rightInput3);

        Assertions.assertFalse(wrongResult1);
        Assertions.assertFalse(wrongResult2);
        Assertions.assertFalse(wrongResult3);
        Assertions.assertFalse(wrongResult4);
        Assertions.assertFalse(wrongResult5);
        Assertions.assertFalse(wrongResult6);
        Assertions.assertFalse(wrongResult7);
        Assertions.assertFalse(wrongResult8);
        Assertions.assertFalse(wrongResult9);
        Assertions.assertFalse(wrongResult10);
        Assertions.assertFalse(wrongResult11);
        Assertions.assertFalse(wrongResult12);
        Assertions.assertFalse(wrongResult13);

        Assertions.assertTrue(rightResult1);
        Assertions.assertTrue(rightResult2);
        Assertions.assertTrue(rightResult3);
    }

    @Test
    @DisplayName("보너스 번호 입력 검증 테스트")
    void testValidateBonusNumber() {

        String wrongInput1 = "";
        String wrongInput2 = " ";
        String wrongInput3 = "abc";
        String wrongInput4 = "  abc";

        String wrongInput5 = "-1";
        String wrongInput6 = "-45";
        String wrongInput7 = "46";
        String wrongInput8 = "0";

        String rightInput1 = " 1";
        String rightInput2 = "1";
        String rightInput3 = "45";
        String rightInput4 = "45 ";

        boolean wrongResult1 = numberValidator.validateBonusNumber(wrongInput1);
        boolean wrongResult2 = numberValidator.validateBonusNumber(wrongInput2);
        boolean wrongResult3 = numberValidator.validateBonusNumber(wrongInput3);
        boolean wrongResult4 = numberValidator.validateBonusNumber(wrongInput4);
        boolean wrongResult5 = numberValidator.validateBonusNumber(wrongInput5);
        boolean wrongResult6 = numberValidator.validateBonusNumber(wrongInput6);
        boolean wrongResult7 = numberValidator.validateBonusNumber(wrongInput7);
        boolean wrongResult8 = numberValidator.validateBonusNumber(wrongInput8);

        boolean rightResult1 = numberValidator.validateBonusNumber(rightInput1);
        boolean rightResult2 = numberValidator.validateBonusNumber(rightInput2);
        boolean rightResult3 = numberValidator.validateBonusNumber(rightInput3);
        boolean rightResult4 = numberValidator.validateBonusNumber(rightInput4);

        Assertions.assertFalse(wrongResult1);
        Assertions.assertFalse(wrongResult2);
        Assertions.assertFalse(wrongResult3);
        Assertions.assertFalse(wrongResult4);
        Assertions.assertFalse(wrongResult5);
        Assertions.assertFalse(wrongResult6);
        Assertions.assertFalse(wrongResult7);
        Assertions.assertFalse(wrongResult8);

        Assertions.assertTrue(rightResult1);
        Assertions.assertTrue(rightResult2);
        Assertions.assertTrue(rightResult3);
        Assertions.assertTrue(rightResult4);
    }
}