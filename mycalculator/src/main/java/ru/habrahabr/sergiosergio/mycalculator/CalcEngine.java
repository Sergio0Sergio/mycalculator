/**
 * Класс является движком калькулятора, те
 * содержит набор методов, в которые передаются
 * операторы и операнды в формате char, при
 * этом возвращается содержимое индикатора калькулятора
 * в формате String.
 * 
 */
package ru.habrahabr.sergiosergio.mycalculator;

/**
 *
 * @author Sergei Grimanov
 * @version 1.0
 */
public class CalcEngine {
    
   private StringBuilder display = new StringBuilder("0");
   private char operator;
   private double operandA;
   //private double operandB;
   private double result;
   private boolean displayFlag = false;
   private boolean operandAFlag = false;
   
   /**
    * Принимает число, возвращает содержимое дисплея калькулятора.
    * Является частью API.
    * @param c передаваемое для вычислений число (кроме дробной точки).
    * @return 
    */
   public String numberInput(char c){
       
       if (displayFlag == false){
          
           display.delete(0, display.length());
           display.append('0');
       }
       
       if (display.toString().equals("0")){
           
           display.deleteCharAt(0);
       }
       
       display.append(c);
       displayFlag = true;
       return display.toString();
   }
   
   /**
    * Принимает оператор (+,-,*,/) и возвращает содержимое 
    * дисплея калькулятора. Является частью API. 
    * @param c передаваемый оператор для вычислений (+,-,*,/)
    * @return 
    */
   public String operatorInput(char c){
       
       if(operandAFlag == true){
           
           if(displayFlag == true){
               
               result = calculateResult(c);
               operandA = result;
               display.delete(0, display.length());
               display.append(String.valueOf(result));
               displayFlag = false;
               operator = c;
            }
           
           else{
               
               operator = c;
           }
       }
       
       else{
           
           operator = c;
           operandA = Double.parseDouble(display.toString());
           operandAFlag = true;
           displayFlag = false;
       }
       return display.toString();
    }
   
   /**
    * Метод производит вычисления над операндами и возвращает содержимое экрана
    * в формате String. Является элементом API
    * @return 
    */
   public String equalInput(){
       
       if(displayFlag == true && operandAFlag == true){
           
           result = calculateResult(operator);
           operandA = result;
           display.delete(0, display.length());
           display.append(String.valueOf(result));
           displayFlag = false;
       }
       return display.toString();
   }
   
   /**
    * Метод добавляет дробную точку и возвращает содержимое индикатора
    * калькулятора в формате String. Является частью API.
    * @return 
    */
   public String dotInput(){
       
      if(displayFlag == false){
          
          display.delete(0, display.length());
          display.append('0');
          displayFlag = true;
      } 
      
      if (!display.toString().contains(".")){
          
          display.append('.');
      }
      return display.toString();
          
   }
   
   /**
    * Метод получает символ 'C' и очищает экран, операторы и операнды,
    * сбрасывает все флаги, возвращает содержимое экрана калькулятора.
    * Является частью API.
    * @return 
    */
   public String clearInput(){
       
       display.delete(0, display.length());
       display.append('0');
       operandA = 0;
       result = 0;
       displayFlag = false;
       operandAFlag = false;
       return display.toString();
   }
   
   /**
    * Метод делает отрицательные числа положительными и положительные
    * отрицательными
    * @return 
    */
   public String reverseInput(){
       
       if(display.charAt(0) == '-'){
           
           display.deleteCharAt(0);
       }
       else{
           
           display.insert(0, '-');
       }
       return display.toString();
   }
   
   private double calculateResult(char c){
       
       switch (c){
           case '+': 
               return operandA + Double.parseDouble(display.toString());
           case '-': 
               return operandA - Double.parseDouble(display.toString());
           case '*': 
               return operandA * Double.parseDouble(display.toString());
           case '/': 
               if (operandA == 0){
                   return 0;
               }
                   
               else {return operandA / Double.parseDouble(display.toString());}
            
           default: return 0;
       }
   }
    
}
