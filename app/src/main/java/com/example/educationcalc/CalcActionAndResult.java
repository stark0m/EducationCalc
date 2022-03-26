package com.example.educationcalc;

public class CalcActionAndResult {

    private ActionEnum currentAction ;

    protected StringBuilder currentStringValue = new StringBuilder();
    float currentValue = 0;

    public CalcActionAndResult(ActionEnum currentAction) {
        this.currentAction = currentAction;
    }
    public CalcActionAndResult() {
        this.currentAction = ActionEnum.EMPTY;
    }

    public void setAction(ActionEnum value){
        currentAction = value;
    }
    private float plus(float num){
       return currentValue+num;

    }

    private float minus(float num){
        return currentValue-num;

    }
    private float miltiply(float num){
        return currentValue*num;

    }
    public float divide(float num){
        return currentValue/num;

    }

    public float action(float num){

        switch (currentAction){
            case PLUS:return plus(num);
            case MINUS: return minus(num);
            case MULTIPLY: return  miltiply(num);
            case DIVIDE: return divide(num);
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return currentValue +currentAction.value;
    }
}
enum ActionEnum {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"),EMPTY(""),RESULT("=");
    String value;

    ActionEnum(String value) {
        this.value = value;
    }
}
