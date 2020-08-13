/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candyvendingmachine;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 *
 * @author shristi
 */

//this class processes everything in the vending machine like taking money, vending item , returning money,
//  populating machine, updating the queue, etc.
public class CandyVendingMachine implements ICandyVendingMachine {
   
    //==========================================================================
    //Properties
    //==========================================================================
    
    
    // Scanner in = new Scanner(System.in); 
     String selection = ""; 
     
     public String GetSelection(){
         return selection;
     }
     
      public  void SetSelection(String val){// sets the user input selection
         selection =val;
     }
    
    protected Queue<CandyType> Skittles = new LinkedList<>();// queue of Skittles
    protected Queue<CandyType> Snickers = new LinkedList<>();// queue of Snickers
    protected Queue<CandyType> MnMs = new LinkedList<>(); //queue of MnMs
    
    /*public Queue GetName(){return Skittles;}
    public void SetName(Queue val){Skittles= (Queue<CandyType>) val; }*/
    
    double price=0;
    public double GetPrice(){return price;}
    public void SetPrice(double val){price=val;}
    
    
    //==========================================================================
    //Constructors
    //==========================================================================
    
    /**
     * Default Constructor
     */
    
    // populating the CandVendingMachine with respective candies
    
         public CandyVendingMachine(){
         for(int i=0; i<2;i++){
         CandyType c1= new CandyType("Skittles",4.20);
         Skittles.add(c1);
          }
                 
         for(int i=0; i<5;i++){
         CandyType c1= new CandyType("Snickers",1.42);
         Snickers.add(c1);
          }
               
         CandyType c1= new CandyType("MnMs",42.42);
         MnMs.add(c1);      
          }
    
         //=====================================================================
         //Methods
         //=====================================================================
         
         
         //checking to see if the candy is present in the vending machine and returns false is no candy is present.
         
         public boolean checkCandy(String selection){
             
         if(Skittles.isEmpty() && selection.equals("A")){
         System.out.println("NO CANDY!!!!");
         return false;
         }
         
         if(Snickers.isEmpty() && selection.equals("B")){
         System.out.println("NO CANDY!!!!");
        return false;
         
         }
         
         if(MnMs.isEmpty() && selection.equals("C")){
         System.out.println("NO CANDY!!!!");
         return false;
         }
         return true;
         } 
     
     double amtGiven=0;
     double amtToReturn=0;
     double totalAmountGiven=0;

     
     /**
      * 
      * @param amount amount that the user need to enter to purchase the candy
      */
 @Override
/**
 * asks the user to insert money
 */
    public void TakeMoney(double amount) {
     price=amount;
/**
 * asks the user to insert money
 */
      System.out.printf("Please insert $ %.2f to buy this candy!", price);
      System.out.println("");
     
       // System.out.println("Please insert $"+ price +"  to buy this candy!");
       Scanner in = new Scanner(System.in);
       if(in.hasNextDouble()){  // only accepts the double else prints out the input is invalid.
            double amtGiven=in.nextDouble();
            
            if (amtGiven>=0){   // prevents negative doubles from being entered, if so, dispalys that the price is negative
                
                totalAmountGiven=totalAmountGiven+ amtGiven;    //total amount given by the user
                amount= GetPrice()-amtGiven;
                amtToReturn= amtGiven- GetPrice();
                
                /**
                 * if amount to return >0, then vends the item and also returns the money, and updates the total amount as 0
                 * if amount to return ==0, then vends the item and updates the total amount as 0
                 * else, notifies the user how much money was the user out of for this purchase and 
                 *          allows the user to decide if they want to still purchase and pay more 
                 *          or cancel the transaction and get back the money entered.
                 */
                
                  if(amtToReturn>0){
                     
                            System.out.println("Purchase Successful!");
                            VendItem(selection);
                            ReturnMoney(amtToReturn);
                             totalAmountGiven=0;
                  }

                  else if(amtToReturn==0){
                            System.out.println("Purchase Successful!");
                            VendItem(selection);
                            totalAmountGiven=0;

                  }
                  else {
                            System.out.printf("\nYou will need $ %.2f more to complete your purchase!\n", -amtToReturn);
                             //  System.out.println("You will need $"+ -amtToReturn+ " to complete your purchase!");
                             
                       boolean purchase=true;      
                      // loops over until the user decides if he wants to cancel the transaction or purchase the candy
                            while(purchase){
                                
                                 System.out.println("\nDo you want to:  ");
                            System.out.println("P. Purchase the Candy!");
                            System.out.println("C. Cancel the transaction!");
                                System.out.println("\nEnter P OR C");
                            Scanner pc =new Scanner(System.in);
                            String cp= pc.next().toUpperCase();
                                
                                if(cp.equals("P")){
                                    TakeMoney(amount);
                                    purchase=false;
                                }

                                else if(cp.equals("C"))
                                {
                                    ReturnMoney(totalAmountGiven);
                                    purchase=false;
                                }
                               
                                else{
                                      System.out.println(cp);
                                 System.out.println("Invalid Input");
                                }
                          }
                     }   
            }
            else {
           System.out.println("You entered negative number!");
       }
      
       }
       else{
           System.out.println("Invalid input!");
       }
    }
/**
 * 
 * @param amount the amount to be returned to the user by machine
 */
    @Override
public void ReturnMoney(double amount) {
     System.out.printf("\nBe sure to take your %.2f that you paid extra! " , amount);
     totalAmountGiven=0;
    }

/**
 * 
 * @param slotCode the code of the CandyVendingMachine
 * @return vends the item and also removes it from the Candy Queue
 */
    @Override
 public CandyType VendItem(String slotCode){
     switch(slotCode){
          case "A":
         if(Skittles.size()>0){
         System.out.println("Removing Skittles! ");
         System.out.println("Enjoy your candy!");
         
         return Skittles.poll();
         
         }
         /*   case "A":
         if(Skittles.size()>1){
         System.out.println("Removing Skittles ");
         return Skittles.poll();
         }
         
         else if(Skittles.size()==1){
         System.out.println("Removing Skittles ");
         return Skittles.remove();
         }*/
         
        case"B":
            if(Snickers.size()>0){
                System.out.println("Removing Snickers ");
                 System.out.println("Enjoy your candy!");
             return Snickers.poll();
            }
             
              case"C":
            if(MnMs.size()>0){
                System.out.println("Removing  M & M’s  ");
                 System.out.println("Enjoy your candy!");
             return MnMs.poll();
            } 
        }
        return null;
 }
    @Override
    public String GetMachineInfo() {
        return null;  
    }
/**
 * If the candy is present, Display the contents to the user 
 * else, display that there is no candy with the option to quit the CanduVendingMachine
 */
    @Override
     public void DisplayContents(){
        System.out.println("Please enter your choice (A, B, C, or Q) ");          
     
        
         if(Skittles.size()>0 ){
             System.out.println("A. "+ Skittles.peek().GetName()+" ( "+ Skittles.size()+" ) - $"+ Skittles.peek().GetPrice());
         }
         else
         {
         System.out.println("A. No candy!!");
         }
         
          if(Snickers.size()>0){
             System.out.println("B. "+Snickers.peek().GetName()+" ( "+ Snickers.size()+" ) - $"+ Snickers.peek().GetPrice());
         }
         else{
             System.out.println("B. No candy!!");  
         }
          
           if(MnMs.size()>0){
             System.out.println("C. "+MnMs.peek().GetName()+" ( "+ MnMs.size()+" ) - $"+ MnMs.peek().GetPrice());
         }
         else{
             System.out.println("C. No candy!!"); 
         }
           
            System.out.println("Q.  Quit");
     }
    
}

