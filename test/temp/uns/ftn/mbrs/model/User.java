package uns.ftn.mbrs.model;

public class User { 

	 
      private String firstName;
      private String lastName;
      private Library library;

      public User(){}
      
      public String getFirstName(){
           return firstName;
      }
      
      public void setFirstName(String firstName){
           this.firstName = firstName;
      }
      
      public String getLastName(){
           return lastName;
      }
      
      public void setLastName(String lastName){
           this.lastName = lastName;
      }
      
      public Library getLibrary(){
           return library;
      }
      
      public void setLibrary(Library library){
           this.library = library;
      }
      

}
