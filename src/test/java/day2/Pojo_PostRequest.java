package day2;

public class Pojo_PostRequest {

     String id;
     String name;
     String country;
     int age;
     String courses[];


     public String getId() {
         return id;
     }
     public String getName() {
         return name;
     }
     public String getCountry() {
         return country;
     }

     public int getAge() {
         return age;
     }

     public String[] getCourses() {
         return courses;
     }

     public void setId(String id) {
         this.id = id;
     }
     public void setName(String name) {
         this.name = name;
     }

     public void setCountry (String country) {
         this.country = country;
     }

     public void setAge (int age) {
         this.age = age;
     }

     public void setCourses (String[] courses ) {
         this.courses = courses;
     }
}
