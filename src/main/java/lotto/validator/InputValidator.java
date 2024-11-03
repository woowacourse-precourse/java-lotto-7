package lotto.validator;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputValidator<T> {

    private static final String ERROR = "[ERROR] ";
    private static final String NULL_MESSAGE = ERROR + "빈 문자열을 입력할 수 없습니다.";
    private static final String NOT_INT_MESSAGE = ERROR + "숫자 형식을 입력해야 합니다.";

    protected abstract T parse(String input);

    public T validate(){
        try{
            String input = Console.readLine();
            return parse(input);
        } catch (NullPointerException e){
            throw new IllegalArgumentException(NULL_MESSAGE);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_INT_MESSAGE);
        }
    }


}
