package uns.ftn.mbrs.model;

public class Library { 

	 
      private String name;
      private Set<Book> books = new HashSet<Book>();
      private Set<User> users = new HashSet<User>();

      public Library(){}
      
      public String getName(){
           return name;
      }
      
      public void setName(String name){
           this.name = name;
      }
      
      public Set<Book> getBooks(){
           return books;
      }
      
      public void setBooks( Set<Book> books){
           this.books = books;
      }
      
      public Set<User> getUsers(){
           return users;
      }
      
      public void setUsers( Set<User> users){
           this.users = users;
      }
      

}
