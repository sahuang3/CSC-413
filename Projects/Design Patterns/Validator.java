public class Validator {
    private StrategyInterface validationStrategy;

    public Validator(StrategyInterface s) {
        this.validationStrategy = s;
    }

    public Boolean validate(String input){
        return validationStrategy.validate(input);
    }

}
