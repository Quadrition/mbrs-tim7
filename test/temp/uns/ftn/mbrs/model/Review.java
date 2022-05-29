package uns.ftn.mbrs.model;

public class Review { 

	 
      private Book book;
      private String comment;

      public Review(){}
      
      public Book getBook(){
           return book;
      }
      
      public void setBook(Book book){
           this.book = book;
      }
      
      public String getComment(){
           return comment;
      }
      
      public void setComment(String comment){
           this.comment = comment;
      }
      

}
