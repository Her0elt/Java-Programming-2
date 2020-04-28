package no.ntnu.idata2001.contacts.handlers;

import no.ntnu.idata2001.contacts.Config;
import no.ntnu.idata2001.contacts.repositories.ContactDetailsRepository;
import no.ntnu.idata2001.contacts.model.ContactDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class AddressBookDBHandler implements AdressBook{
    private  EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("contacts",Config.DBProperties);

    private  EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

    private ContactDetailsRepository contactDetailsRepository;

    public AddressBookDBHandler() {
        this.contactDetailsRepository = new ContactDetailsRepository(em);
    }


    public void addContact(ContactDetails contact){
        contactDetailsRepository.save(contact);
    }

    public void removeContact(ContactDetails contactDetails){
        contactDetailsRepository.delete(contactDetails);
    }

    public List<ContactDetails> getAllContacts() {
       return contactDetailsRepository.findAll();
    }
    public Iterator<ContactDetails> iterator() {

        return this.contactDetailsRepository.findAll().iterator();
    }
    public void close(){
        em.close();
        ENTITY_MANAGER_FACTORY.close();
    }


}
