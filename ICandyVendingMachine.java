/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candyvendingmachine;

/**
 *
 * @author shristi
 */
// Candy Vending Machine Interface
public interface ICandyVendingMachine<Candy> {
    
 // Accepts the amount of money from the user
 public void TakeMoney(double amount);
 
 // Returns the amount of money to the user
 public void ReturnMoney(double amount);
 
 // Spits out an item based on the vending slot chosen by the user
 // Each vending machine should have SlotA, SlotB, and SlotC
 // Up to 5 items can be placed in each slot of the vending machine
 public Candy VendItem(String slotCode);
 
 // Displays what kind of vending machine it is
 public String GetMachineInfo();
 
 // Shows the item name and price for each Slot of the machine
 public void DisplayContents();
}
