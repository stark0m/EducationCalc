package com.example.educationcalc;

public class CalcActionAndResult {

    private String intermediateAction ="" ;
    private float intermediateValue = 0;
    private boolean lastActionCalculation = false;

    public boolean isLastActionCalculation() {
        return lastActionCalculation;
    }

    public void setLastActionCalculation(boolean lastActionCalculation) {
        this.lastActionCalculation = lastActionCalculation;
    }

    protected StringBuilder currentStringValue;



    public CalcActionAndResult() {
        currentStringValue = new StringBuilder("0");
        this.intermediateAction = "";
    }

    public void setAction(String value){
        intermediateAction = value;
    }
    private float plus(float num){
       return intermediateValue +num;

    }

    private float minus(float num){
        return intermediateValue -num;

    }
    private float miltiply(float num){
        return intermediateValue *num;

    }
    public float divide(float num){
        return intermediateValue /num;

    }

    public float action(float num){


        switch (intermediateAction){
            case "+":return plus(num);
            case "-": return minus(num);
            case "*": return  miltiply(num);
            case "/": return divide(num);
            default: return this.getIntermediateValue();
        }
    }



    @Override
    public String toString() {
        return intermediateValue + intermediateAction;
    }

    public String getIntermediateAction() {
        return intermediateAction;
    }

    public float getIntermediateValue() {
        return intermediateValue;
    }
    public void setIntermediateValue(float value) {
        this.intermediateValue=value;
    }
}
