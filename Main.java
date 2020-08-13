/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candyvendingmachine;

import java.util.Scanner;

/**
 *
 * @author shristi
 */
public class Main {
  
    
    public static void main(String[] args) {
        
        //instantiate CandyVendingMchine
    CandyVendingMachine machine= new CandyVendingMachine();
       
 
  boolean check=true;
  
//Introductory message
      System.out.println("Welcome to the Candy Vending Machine|");
      System.out.println("");
      System.out.println("");
  
  while(check){
      //loops the program until the user presses q/Q to quit the first time or n/N-no candy
     
     machine.DisplayContents();//dispaly the candies present in the vending machine
     
     Scanner in = new Scanner(System.in); // asks the user to input the candy from the contents displayed
     String input=in.next().toUpperCase();
     machine.SetSelection(input);
     
      String selection=machine.GetSelection();// gets the user's selection of candy choice
      
       // checks the selections and the cases possible
      switch(selection){
          // for Skittles
             case "A":{
             if(machine.checkCandy("A")){   
             machine.SetSelection("A");
             machine.TakeMoney(4.20);
             }
             break; 
          }
             
            case "B":{
                //for Snickers
            if(machine.checkCandy("B")){
            machine.SetSelection("B");
            machine.TakeMoney(1.42);
           
          }
             break;
            }
              
            case "C":{
                //for M&Ms
            if(machine.checkCandy("C")){
            machine.SetSelection("C");
            machine.TakeMoney(42.42);
            }
            break; 
           }
            
           case "Q":{
            System.out.println("Thank you for coming!");
            System.exit(0);// Quits the program if the user the user presses Q
            break;
           }
           
           default:
               System.out.println("Invalid input!");// displays invalid input if the selection is other than a,b,c,and q
           }  
      
             System.out.println("\n");
             System.out.println("Do you want to purchase more Candy? Press Y/N");//allows users another option to choose candy
             Scanner a= new Scanner(System.in);
             String again= a.next().toUpperCase();
             
             /**
              * asks for input, 
              * if the input is y/Y, then displays the contents again
              * is the input is n/N, then quits the program
              * else displays that the input is not valid and displays if the user wants to purchase any candy
              */
             
             if (again.equals("Y")){
                 check=true;
             }
             else if (again.equals("N")){
                 System.out.println("Thank you for coming!");
                check=false;
             }
             else
             {
                 System.out.println("Sorry not valid input!");
                 check=true;
             }
             
        }
   
}
    
     
}  

