package validate;

public class Validator {

    private static final String NULL_VALUE_MESSAGE = "[ERROR] 입력한 값이 유효하지 않습니다.";

    private static final String NOT_INTEGER_VALUE_MESSAGE = "[ERROR] 입력한 값이 정수형 숫자가 아닙니다.";

    private static final String OUT_OF_RANGE_VALUE_MESSAGE = "[ERROR] 1000 이상의 숫자만 입력해야합니다.";

    private static final String NOT_UNIT_VALUE_MESSAGE = "[ERROR] 1000 단위의 숫자 입력만 가능합니다.";
    public Validator(){
    }

    private void validateNullValue(String purchaseCost){
        if(purchaseCost == null){
            throw new IllegalArgumentException(NULL_VALUE_MESSAGE);
        }
    }

    private void validateNotIntegerValue(String purchaseCost){
       if(!purchaseCost.matches("\\d+")){
           throw new IllegalArgumentException(NOT_INTEGER_VALUE_MESSAGE);
       }
    }

    private void validateRange(String purchaseCost){
        if(purchaseCost.length() < 4 || purchaseCost.charAt(0) == '-'){
            throw new IllegalArgumentException(OUT_OF_RANGE_VALUE_MESSAGE);
        }
    }

    private void validateUnit(String purchaseCost){
        int end_index = purchaseCost.length()-1;
        for(int index = end_index; index > end_index - 3; index--){
            if(purchaseCost.charAt(index) != '0'){
                throw new IllegalArgumentException(NOT_UNIT_VALUE_MESSAGE);
            }
        }
    }

    public void validatePurchaseCost(String purchaseCost){
        validateNullValue(purchaseCost);
        validateNotIntegerValue(purchaseCost);
        validateRange(purchaseCost);
        validateUnit(purchaseCost);
    }



}
