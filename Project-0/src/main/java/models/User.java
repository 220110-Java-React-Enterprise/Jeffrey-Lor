package models;

public class User {
    private String email;
    private int id;

    public User(String email, int id)
	{
		this.email = email;
		this.id = id;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}