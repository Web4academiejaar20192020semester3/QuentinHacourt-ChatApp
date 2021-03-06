package domain;

import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();

	public PersonService(){
	}

	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}

	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setStatus(String personId, String status){
		personRepository.setStatus(personId,status);
	}

    public void addFriend(String personId, String friendId){
        personRepository.addFriend(personId, friendId);
    }

    public List<Person> getFriends(String userId){
        return getPerson(userId).getFriends();
    }

    public String getFriendInfo(String userID, String friendID){
        return personRepository.getFriendInfo(userID, friendID);
    }
}
