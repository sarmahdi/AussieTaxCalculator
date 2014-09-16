/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author sarm
 */
public enum Currency {
AUD("Australian Dollar"),
CAD("Canadian Dollar"),
GBP("Great British Pound"),
JPY("Japanese Yen"),
USD("United States Dollar"),
XEU("European Euro");

 private String value;
   /**
    * This is the String Argument constructor.
    * @param value 
    */
   private Currency(String value){
   this.value =  value;
   }
   
   public String getValue(){
   return value;}
}