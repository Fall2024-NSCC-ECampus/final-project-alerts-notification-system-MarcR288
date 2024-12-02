package com.example.alertsnotificationsystem;

import com.example.alertsnotificationsystem.model.Address;
import com.example.alertsnotificationsystem.model.FireStation;
import com.example.alertsnotificationsystem.model.Person;
import com.example.alertsnotificationsystem.repository.AddressRepository;
import com.example.alertsnotificationsystem.repository.FireStationRepository;
import com.example.alertsnotificationsystem.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class AlertsNotificationSystemApplication implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;



    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private FireStationRepository fireStationRepository;

    public AlertsNotificationSystemApplication(
            PersonRepository personRepository,
            AddressRepository addressRepository,
            FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.fireStationRepository = fireStationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AlertsNotificationSystemApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (personRepository.count() == 0) {
            for (int i = 0; i < 40; i++) {
                Random random = new Random();

                // Predefined lists
                List<String> cities = List.of("Halifax", "Ottawa", "Toronto");
                List<String> streetNames = List.of(
                        "Main", "Sesame", "West", "North", "South", "East", "Windsor",
                        "Pine", "Oak", "Maple", "Cedar", "Elm", "River", "Broadway", "Sunset", "King", "Queen", "Park", "Church"
                );
                List<String> possibleMedications = List.of("None", "Heart Medication", "Arthritis Medication", "Diabetes Medication");
                List<String> allergies = List.of("None", "Dust", "Pollen", "Gluten", "Nuts");
                List<String> possibleDosages = List.of("1 pill per day", "2 pills per day");
                List<String> firstNames = List.of(
                        "John", "Jane", "Anna", "George", "Bob", "Edna", "Jim", "Ashley", "Jacob",
                        "Michael", "Emily", "David", "Sarah", "William", "Sophie", "Chris"
                );
                List<String> lastNames = List.of(
                        "Smith", "Jones", "Brown", "Doe", "Kim",
                        "Taylor", "Williams", "Johnson", "Lee", "Davis",
                        "Miller", "Wilson", "Moore", "Anderson", "Thomas",
                        "Jackson"
                );

                String dosage;

                // Generate random address
                int addressNumber = random.nextInt(300) + 1; // Random number between 1 and 300
                String city = cities.get(random.nextInt(cities.size()));
                String streetName = streetNames.get(random.nextInt(streetNames.size()));
                Address address = new Address();
                address.setAddressLine(addressNumber + " " + streetName + " Street");
                address.setCity(city);

                // Save the address to the database
                address = entityManager.merge(address);
                addressRepository.save(address);

                // Create random Person
                String firstName = firstNames.get(random.nextInt(firstNames.size()));
                String adultFirstName = firstNames.get(random.nextInt(firstNames.size()));
                String lastName = lastNames.get(random.nextInt(lastNames.size()));
                int age = random.nextInt(79) + 1;

                // Set phone number based on city
                String areaCode;
                switch (city) {
                    case "Halifax":
                        areaCode = "902";
                        break;
                    case "Ottawa":
                        areaCode = "613";
                        break;
                    case "Toronto":
                        areaCode = "519";
                        break;
                    default:
                        areaCode = "902"; // Default area code, you can change as needed
                }

                // Generate random phone number with the appropriate area code
                String phone = areaCode + "-" + String.format("%03d", random.nextInt(1000)) + "-" + String.format("%04d", random.nextInt(10000)); // Random phone number
                String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@outlook.com"; // Generate random email
                String medications = possibleMedications.get(random.nextInt(possibleMedications.size()));
                if (medications.equals("None")) {
                    dosage = "N/a";
                } else {
                    dosage = possibleDosages.get(random.nextInt(possibleDosages.size()));
                }

                Person person = new Person();
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setAge(age);
                person.setPhone(phone);
                person.setEmail(email);
                person.setAddress(address);
                person.setMedications(medications);
                person.setDosages(dosage);
                person.setAllergies(allergies.get(random.nextInt(allergies.size()))); // Random allergy

                // Save the Person to the database
                person = personRepository.save(person);

                // Check if the person is under 18, and if so, create a new person who is 20 years older
                if (person.getAge() < 18) {
                    // Create a new person who is 20 years older with the same last name and address
                    Person adultPerson = new Person();
                    adultPerson.setFirstName(adultFirstName);
                    adultPerson.setLastName(lastName);
                    adultPerson.setAge(person.getAge() + 20); // 20 years older
                    adultPerson.setPhone(phone); // Same phone number as the child (or generate a new one if needed)
                    adultPerson.setEmail(firstName.toLowerCase() + "." + lastName.toLowerCase() + "@outlook.com"); // Same email, or generate new
                    adultPerson.setAddress(address);
                    adultPerson.setMedications(medications);
                    adultPerson.setDosages(dosage);
                    adultPerson.setAllergies(allergies.get(random.nextInt(allergies.size()))); // Random allergy

                    // Save the adult person to the database
                    adultPerson = personRepository.save(adultPerson);
                }

                // Create and save FireStation
                FireStation fireStation = new FireStation(person, address, random.nextInt(6) + 1); // Create FireStation with Person and Address
                fireStationRepository.save(fireStation); // Save FireStation to the database

                System.out.println("Random person with medications, address, and fire station saved to the database.");
            }
        }
    }
}
