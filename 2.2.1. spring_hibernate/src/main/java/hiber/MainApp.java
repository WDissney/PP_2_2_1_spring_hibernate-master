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

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Audi", 3)));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW", 5)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Suzuki", 12)));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Mercedes", 4)));
      User use = new User("User1", "lN1", "LN1@gmail.com");
      User use2 = new User("User2", "lN2", "LN2@gmail.com");
      Car car = new Car("BMW", 5);
      Car car2 = new Car("Audi", 100);
      use.setCar(car);
      use2.setCar(car2);
      userService.add(use);
      userService.add(use2);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }
      User user = userService.getUserByAuto("Audi", 100);
      System.out.println(user);
      context.close();
   }
}
