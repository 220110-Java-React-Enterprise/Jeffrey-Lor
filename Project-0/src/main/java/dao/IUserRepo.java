package dao;

public interface IUserRepo {
    void addUser(String email, String password);
	void deleteUser(int id);
	void viewAllUsers();
	boolean checkDuplicate(String email);
}
