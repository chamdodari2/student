package student.dto;

public class User {
	
	private int id;
	private String pass;
	private boolean grants;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(int id, String pass, boolean grants) {
		this.id = id;
		this.pass = pass;
		this.grants = grants;
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public boolean isGrants() {
		return grants;
	}


	public void setGrants(boolean grants) {
		this.grants = grants;
	}


	@Override
	public String toString() {
		return String.format("User [id=%s, pass=%s, grants=%s]", id, pass, grants);
	}
	
	

}
