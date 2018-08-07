package be.bo.booking.api;
import be.bo.user.User;

public interface IUserService {
 void addUser(String name);
 User getUser(int id);
 void deleteUser(int id);
 void updateUser(int id, String name);
}
