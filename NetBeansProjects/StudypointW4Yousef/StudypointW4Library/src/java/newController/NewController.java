/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newController;

import Data.DB;
import entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yousinho
 */
public class NewController {
        
private  ArrayList<Book> books = new ArrayList();
    public NewController() {
  //     toDelete();
   loadBooks();
    }

   

    public ArrayList<Book> getBooks() {
        return books;
    }
    
    
    
    
    public void addBook(Book book){
    
    books.add(book);
    
    }
    
    public String bookListToString(){
    String result = "";
        for (Book book : books) {
           result+= book.toString();
        }
    
    
    return result;}

    private void toDelete() {
//books.add(new Book("Epic of Gilgamesh", "Unknown", 12, 70));
//books.add(new Book("Det evige liv", "Fernando Savater", 270, 50));
//books.add(new Book("Staten", "Platon", 321, 68));
 }
    
    
    public void loadBooks() {
        try {
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM books");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //int id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                int pages = rs.getInt(4);
                int price = rs.getInt(5);
                books.add(new Book(title,author,pages,price));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
