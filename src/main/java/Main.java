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


        // userService.deleteOfId(93);
        //System.out.println(userService.findOfName("Pasha"));
        // System.out.println(userService.CountUniqueName("Pasha"));
        // System.out.println(userService.findAllUsers());
        // System.out.print(userService.findUser(90));
        //System.out.print(userService.findAllAuto());
        userService.findUsersCars();


    }
}