package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();

	public PersonRepositoryStub () {
		Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", "other", 150);
		add(administrator);
		Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", "man", 25);
		add(jan);
		Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", "vrouw", 23);
		add(an);
	}

	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}

	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());
	}

	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}

	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getUserId(), person);
	}

	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}

	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);

		if (person != null && person.isCorrectPassword(password)) {
			return person;
		}
		else {
			return null;
		}
	}

	public void setStatus(String personId, String status) {
        if(personId == null || personId.isEmpty() || status == null || status.isEmpty()){
            throw new IllegalArgumentException("no id or status given");
        }
        persons.get(personId).setStatus(status);
	}

    public void addFriend(String personId, String friendId){
        persons.get(personId).addFriend(persons.get(friendId));
    }

	@Override
	public String getFriendInfo(String personID, String friendID) {
		return persons.get(personID).getFriendInfo(friendID);
	}
}
