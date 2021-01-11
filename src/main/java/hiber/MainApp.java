package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User(new Car(122223, "MERSEDE BENS"),"User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User(new Car(615566, "Mazda"),"User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User(new Car(999999, "BMW"),"User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User(new Car(893321, "Audi"),"User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();

      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().getModel());
         System.out.println();
      }

      User user1 = userService.listUsers("BMW", 999999);
      System.out.println("Id = "+user1.getId());
      System.out.println("First Name = "+user1.getFirstName());
      System.out.println("Last Name = "+user1.getLastName());
      System.out.println("Email = "+user1.getEmail());
      System.out.println("Car = "+user1.getCar().getModel());
      System.out.println();


      context.close();
   }
}
