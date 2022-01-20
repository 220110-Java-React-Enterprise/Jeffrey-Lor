package dao;

public interface IUserRepo {
    void addUser(String username, String password);
	void deleteUser(int id);
	void viewAllUsers();
}
