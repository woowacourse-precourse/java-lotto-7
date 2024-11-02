package lotto.processor;

public abstract class Processor<T> {
    protected abstract T getInput();
    protected abstract void validate(T input);

    public final T process(){
        while(true){
            try{
                T input = getInput();
                validate(input);
                return input;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
