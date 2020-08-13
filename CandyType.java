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

public class CandyType implements Cloneable{

//==============================================================================
//Properties
//==============================================================================
    
    protected String name= "";
    public String GetName(){
        return name;
    }
    public void SetName(String val){
        name= val;
    }
    
    
    protected double price= 0;
    public double GetPrice(){
        return price;
    }
    public void SetPrice(double val){
        price=val;
    }
   
//==============================================================================
//Constructors
//==============================================================================
    /**
     * Default Constructor
    */
    public CandyType(){}
    
    /**
     * @param name name of the candy
     * @param price  price of the candy
     */
    public CandyType(String name, double price){
        SetName(name);
        SetPrice(price);
    }
 
//==============================================================================
//Methods
//==============================================================================
    @Override
   public CandyType clone() throws CloneNotSupportedException{
       return new CandyType(name, price);
   }
    
}
     
     
    
    
    