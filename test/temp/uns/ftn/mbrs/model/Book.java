package uns.ftn.mbrs.model;

public class Book { 

	 
      private Library library;
      private Category category;
      private Set<Review> reviews = new HashSet<Review>();
      private String title;
      private int year;
      private Age ageRecommendation;

      public Book(){}
      
      public Library getLibrary(){
           return library;
      }
      
      public void setLibrary(Library library){
           this.library = library;
      }
      
      public Category getCategory(){
           return category;
      }
      
      public void setCategory(Category category){
           this.category = category;
      }
      
      public Set<Review> getReviews(){
           return reviews;
      }
      
      public void setReviews( Set<Review> reviews){
           this.reviews = reviews;
      }
      
      public String getTitle(){
           return title;
      }
      
      public void setTitle(String title){
           this.title = title;
      }
      
      public int getYear(){
           return year;
      }
      
      public void setYear(int year){
           this.year = year;
      }
      
      public Age getAgeRecommendation(){
           return ageRecommendation;
      }
      
      public void setAgeRecommendation(Age ageRecommendation){
           this.ageRecommendation = ageRecommendation;
      }
      

}
