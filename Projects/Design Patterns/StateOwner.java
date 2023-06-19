public class StateOwner {
    private String state;

    public StateRecord saveSate(){
        return new StateRecord(state);
    }

    public void restoreState(StateRecord record){
        state = record.getState();
    }

    public void setState(String s){
        state = s;
    }

    public void printState(){
        System.out.println(state);
    }

    public class StateRecord {
        private final String state;

        public StateRecord(String state){
            this.state = state;
        }

        private String getState(){
            return state;
        }

    }


}
