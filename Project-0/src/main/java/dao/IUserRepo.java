package dao;

public interface IUserRepo {
    void addUser(String name, String password);
	void deleteUser(int id);
	void viewAllUsers();
}
