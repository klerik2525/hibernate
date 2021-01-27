import models.Auto;
import models.User;
import services.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

      UserService userService = new UserService();
      /*   User user = new User("Pasha", 26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        Auto ford = new Auto("Ford", "black");
        user.addAuto(ferrari);
        Auto opel = new Auto("Opel", "red");
        Auto bmw = new Auto("BMW", "blue");
        user.addAuto(opel);
        user.addAuto(bmw);
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);*/


        //System.out.print(userService.findUser(81).getAutos() + user.getName());

        //System.out.println(userService.deleteOfName("Masha"));
      // userService.deleteOfName("Masha");

       // System.out.println(userService.findOfName("Misha"));
       System.out.println(userService.findOfName("Pisha"));
       System.out.println( userService.CountUniqueName("Pasha"));


    }
}