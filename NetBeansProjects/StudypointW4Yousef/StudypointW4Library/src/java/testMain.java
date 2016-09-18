
import entity.Book;
import newController.NewController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yousinho
 */
public class testMain {
 public static void main(String [] args){
    NewController con = new NewController();
     System.out.println("listsize"+con.getBooks().size());
     
     for (Book book : con.getBooks()) {
         System.out.println(book.toString()+"\n"); 
     }
     
    
    
    }
    
}
