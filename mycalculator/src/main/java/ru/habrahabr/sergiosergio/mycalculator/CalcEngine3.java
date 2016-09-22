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
				lastSymbol = c;
				return  display.toString();
								
			case 1:
				
				checkLastSymbol();
				checkZero();
				display.append(c);
				lastSymbol = c;
				return  display.toString();
				
			case 2:
				
				state = 1;
				display.delete(0, display.length());
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
				lastSymbol = c;
				state = 1;
				
			case 1:
				
				
		}
		
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
