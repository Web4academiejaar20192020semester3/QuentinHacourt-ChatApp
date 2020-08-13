package db;

import java.util.List;

import domain.Person;

public interface PersonRepository {

	public abstract void add(Person person);

	public abstract void delete(String userId);

	public abstract Person get(String userId);

	public abstract List<Person> getAll();

	public abstract Person getAuthenticatedUser(String email, String password);

	public abstract void update(Person person);

	public abstract void setStatus(String personId, String status);

    public abstract void addFriend(String personId, String friendId);

    public abstract String getFriendInfo(String personID, String freindID);
}
