package lotto.util;

public class StringUtil {
    public static Integer parseToPositiveInt(String strNum){
        try{
            // 입력 값 앞 뒤 공백 제거
            strNum = strNum.strip();

            // 공백 제거 후에도 공백이 있거나 쉼표가 포함 되어 있으면 에러 발생
            if(strNum.contains(" ") || strNum.contains(",")){
                throw new IllegalArgumentException("[ERROR] 하나의 숫자만 입력 할 수 있습니다.");
            }

            int num = Integer.parseInt(strNum);
            if (num <= 0) {
                throw new IllegalArgumentException("[ERROR] 0 또는 음수 값을 입력 할 수 없습니다.");
            }
            return num;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. 다시 시도해주세요.");
        }
    }

    public static void checkIfNull(String str) {
        if (str == null) {
            throw new IllegalArgumentException("[ERROR] 입력값은 null일 수 없습니다.");
        }
    }
}
