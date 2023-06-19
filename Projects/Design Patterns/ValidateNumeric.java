public class ValidateNumeric implements StrategyInterface{
    public Boolean validate(String input){
        try{
            Integer.valueOf(input);
        } catch(Exception e){
            return false;
        }

        return true;
    }
}
