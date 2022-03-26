package com.example.educationcalc;

public class CalcActionAndResult {

    private ActionEnum currentAction ;

    float currentValue = 0;


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
            case Minus: return minus(num);
            case Multiply: return  miltiply(num);
            case Divide: return divide(num);
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return currentValue +currentAction.value;
    }
}
enum ActionEnum {
    PLUS("+"),Minus("-"), Multiply("*"),Divide("/");
    String value;

    ActionEnum(String value) {
        this.value = value;
    }
}
