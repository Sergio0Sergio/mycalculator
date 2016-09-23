/*
 * Copyright (C) 2016 sgrimanov
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package ru.habrahabr.sergiosergio.mycalculator;

/**
 *
 * @author sgrimanov
 */
public class CalcEngine3 {
    
	private double result;
    private char lastSymbol = '0';
	private char operator;
	private double operandA;
	private int state = 0;
	private StringBuilder display = new StringBuilder("0");
	
	public String numberInput (char c){
		
		switch (state){
		
			case 0:
								
				checkZero();
				display.append(c);
				return  display.toString();
								
			case 1:
				
				
				checkZero();
				display.append(c);
				return  display.toString();
				
			case 2:
				
                                checkZero();
				state = 1;
				display.append(c);
				return  display.toString();
				
                        case 3:
                                
                                checkZero();
                                state = 0;
				display.append(c);
				return  display.toString();
				
		}
		
		return "error";		
	}
	
	public String operatorInput(char c){
		
		switch (state){
		
			case 0:
				
				operator = c;
				operandA = Double.parseDouble(display.toString());
				state = 1;
                                display.delete(0, display.length());
                                display.append("0");
				return String.valueOf(operandA);
				
			case 1:
				
				result = calculateResult(operator);
				operandA = result;
				display.delete(0, display.length());
                                display.append("0");
				operator = c;
				state = 2;
				return String.valueOf(operandA);
				
			case 2:
				
				operator = c;
				return String.valueOf(operandA);
                                
                        case 3:
                            
                                operator = c;
				operandA = Double.parseDouble(display.toString());
				state = 1;
                                display.delete(0, display.length());
				return String.valueOf(operandA);
							
				
		}
		return "error";
		
	}
	
	public String dotInput(){
		
		switch (state){
		
			case 0:
				
				if (!display.toString().contains(".")){
			          
			          display.append('.');
			      }
			      return display.toString();
			      
			case 1:
				
				if (!display.toString().contains(".")){
			          
			          display.append('.');
			      }
			      return display.toString();
			      			      
			case 2:
				
				return String.valueOf(operandA);
                                
                        case 3:
                            
                                return String.valueOf(operandA);
		}
		return "error";
	}
	
	public String equalInput(){
		
		switch (state){
		
			case 0:
				
                            return display.toString();
				
			case 1:
                            
                                result = calculateResult(operator);
				operandA = result;
				display.delete(0, display.length());
                                display.append("0");
				state = 3;
				return String.valueOf(operandA);
                                
                        case 2:
                                
                                return String.valueOf(operandA);
                                
                        case 3:
                            
                                return String.valueOf(operandA);
                }
                return "error";
	}
        
        public String reverseInput(){
            
                    if(display.charAt(0) == '-'){
           
                        display.deleteCharAt(0);
                    }
                    else{
           
                         display.insert(0, '-');
                    }
                    return display.toString();
        }
        
        public String clearInput(){
       
            display.delete(0, display.length());
            display.append('0');
            operandA = 0;
            result = 0;
            state = 0;
            return display.toString();
        }
	
	private void checkZero(){
		
		if(display.toString().equals("0") || display.toString().equals("0.0") || display.toString().equals("-0") || display.toString().equals("-0.0")){
			
			display.delete(0, display.length());
			
		}
		
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
