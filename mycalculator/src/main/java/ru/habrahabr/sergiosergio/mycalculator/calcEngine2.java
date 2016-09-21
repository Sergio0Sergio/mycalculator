package ru.habrahabr.sergiosergio.mycalculator;

public class calcEngine2 {
	
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
				lastSymbol = 'c';
				return  display.toString();
								
			case 1:
				
				checkLastSymbol();
				checkZero();
				display.append('c');
				lastSymbol = 'c';
				return  display.toString();
				
			case 2:
				
				state = 1;
				display.delete(0, display.length());
				display.append(c);
				return  display.toString();
				
				
		}
		return "error";
		
		
		
		
	}
	
	private void checkZero(){
		
		if(display.toString().equals("0")){
			
			display.deleteCharAt(0);
		}
		
	}
	
	private void checkLastSymbol(){
		
		if (lastSymbol == '+' || lastSymbol == '-' || lastSymbol == '*' || lastSymbol == '/' || lastSymbol == '='){
			
			display.delete(0, display.length());
			display.append("0");
		}
	}

}
