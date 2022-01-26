package dao;

public interface IUserRepo {

	// Adds a user entry with the given email and password
    void addUser(String email, String password);

	// Removes a user entry with the given id
	void deleteUser(int id);

	// Prints all users to console
	void viewAllUsers();

	// Checks if given email already exists
	boolean checkDuplicate(String email);
}
