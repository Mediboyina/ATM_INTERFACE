/*library_management class lies inside main method.Book,User,Admin and library classes are defined.*/
import java.util.*;
class Book{
    private String name;
    private String author;
    private int num;
    public Book(String name,String author,int num){//constructor with 3 parameters.
        this.name=name;
        this.author=author;
        this.num=num;
    }
    //Methods inside Book Class.
    public String Name(){
        return name;
    }
    public String Author(){
        return author;
    }
    public int Num(){
        return num;
    }
}
class Library{//Library class adds,searches,and removes books from the library.
    private ArrayList<Book>books=new ArrayList<Book>();//Array list of books is a private variable
    public void addBook(Book book){//addBook method to add books into arrayList
        books.add(book);
        System.out.println(book.Name()+" "+"with number"+ book.Num()+" "+"has been added to library");
    }
    public void searchBook(String name){
        for(Book i:books){//iterate in arraylist and search for required book.
            if(name.equals(i.Name())){
                System.out.println("Book found");
                System.out.println("Name:"+i.Name());
                System.out.println("Author:"+i.Author());
                System.out.println("Number:"+i.Num());
            }
            else{
            System.out.println("Book not found");
            break;
            }
        }
       
    }
    public void removeBook(String title){
        for(Book i:books){//search for book in arraylist and remove it.
            if(title.equals(i.Name())){
                books.remove(i);
                System.out.println(i.Name()+"has been removed from library");
            }
            else{
                System.out.println("Book not found");
                break;
            }
        }
    }
}
class Admin{//admin class can add and remove a book.
    private Library library;//library is a private variable.
    public Admin(Library library){//constructor
        this.library=library;
    }
    public void addBook(){//
        Scanner obj=new Scanner(System.in);
        System.out.print("Enter the book title");
        String title=obj.nextLine();
        System.out.print("Enter the author name");
        String author=obj.nextLine();
        System.out.print("Enter the book number");
        int num=obj.nextInt();
        Book book=new Book(title,author,num);
        library.addBook(book);//fun call to addBook in library class
    }
    public void removeBook(){
        Scanner obj=new Scanner(System.in);
        System.out.print("Enter the book title to remove");
        String title=obj.nextLine();
        library.removeBook(title);//fun call to removeBook in library class
    }
}
class User{//User class can search or write a query.
    private Library library;
    public User(Library library){
        this.library=library;
    }
    public void searchBook(){
        Scanner obj=new Scanner(System.in);
        System.out.print("Enter the book title to search for:");
        String title=obj.nextLine();
        library.searchBook(title);

    }
    public void query(){
        System.out.print("Contact to abc@gmail.com");
    }
}
public class library_management{//main fun
    public static void main(String args[]){
        Scanner obj=new Scanner(System.in);
        Library library=new Library();//Instance of Library class.
        Admin admin=new Admin(library);//Instance of Admin class.
        User user=new User(library);//Instance of User class.
       while(true){
            System.out.println("\nEnter 1. Admin module");
            System.out.println("Enter 2.User module");
            System.out.println("Enter 3.To exit");
            int choice=obj.nextInt();
            switch(choice){
                case 1: 
                    System.out.println("\nEnter 1 to add book");
                    System.out.println("Enter 2 to remove book");
                    int adminchoice=obj.nextInt();
                    switch(adminchoice){
                        case 1:
                            admin.addBook();
                            break;
                        case 2:
                            admin.removeBook();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Enter a valid one");
                            break;
                        
                    }
                case 2:
                System.out.println("\nEnter 1 to search for book");
                System.out.print("Enter 2 to write a query");
                int userchoice=obj.nextInt();
                switch(userchoice){
                    case 1:
                        user.searchBook();
                        break;
                    case 2:
                        user.query();
                        break;
                    }
                    break;
                    default:
                    System.out.print("Enter a valid one");
                    break;
            }

        }
    }
}