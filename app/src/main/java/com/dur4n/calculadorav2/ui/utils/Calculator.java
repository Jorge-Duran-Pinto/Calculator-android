package com.dur4n.calculadorav2.ui.utils;

import com.dur4n.calculadorav2.ui.operations.OperationsContract;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    static Calculator calculator;

    final Pattern patSuma = Pattern.compile("^([0-9]+)\\+([0-9]+)");
    final Pattern patResta = Pattern.compile("^([0-9]+)-([0-9]+)$");
    final Pattern patMultiplicacion = Pattern.compile("^([0-9]+)x([0-9]+)$");
    final Pattern patDivision = Pattern.compile("^([0-9]+)/([0-9]+)$");

    Matcher m;

    public static Calculator getInstance(){
        if(calculator == null)
            calculator = new Calculator();

        return calculator;
    }

    public void doOperation(String cadena, OperationsContract.InteractorListener listener){
        if((m = patSuma.matcher(cadena)).find()){
            operate(m, listener, cadena, "+");
        } else if((m = patResta.matcher(cadena)).find()){
            operate(m, listener, cadena, "-");
        }else if((m = patMultiplicacion.matcher(cadena)).find()){
            operate(m, listener, cadena, "x");
        }else if((m = patDivision.matcher(cadena)).find()){
            operate(m, listener, cadena, "/");
        }else {
            listener.onFailure("Format error");
        }
    }

    public void operate(Matcher m, OperationsContract.InteractorListener listener, String cadena, String flag){
            String numUno = m.group(1);
            String numDos = m.group(2);

            Integer num1 = Integer.parseInt(numUno);
            Integer num2 = Integer.parseInt(numDos);
            Integer result = null;
            switch (flag){
                case "+":
                    try{
                        result = num1 + num2;
                    }catch (Exception e){
                        listener.onFailure("Format error");
                    }
                    listener.onOperationSuccess(cadena+"="+result);
                    break;
                case "-":
                    try{
                        result = num1 - num2;
                    }catch (Exception e){
                        listener.onFailure("Format error");
                    }
                    listener.onOperationSuccess(cadena+"="+result);
                    return;
                case "x":
                    try{
                        result = num1 * num2;
                    }catch (Exception e){
                        listener.onFailure("Format error");
                    }
                    listener.onOperationSuccess(cadena+"="+result);
                    return;
                case "/":
                    try{
                        result = num1 / num2;
                    }catch (Exception e){
                        listener.onFailure("Format error");
                    }
                    listener.onOperationSuccess(cadena+"="+result);
                    return;
                default:
                    listener.onFailure("Format error");
            }
    }
}
