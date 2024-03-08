package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {OwnerRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.springframework.samples.petclinic.owner"})
@DataJpaTest
class OwnerRepositoryDiffblueTest {
  @Autowired
  private OwnerRepository ownerRepository;
  /**
   * Method under test: {@link OwnerRepository#findPetTypes()}
   */
  @Test
  void testFindPetTypes() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act and Assert
    assertEquals(6, ownerRepository.findPetTypes().size());
  }

  /**
   * Method under test: {@link OwnerRepository#findByLastName(String, Pageable)}
   */
  @Test
  void testFindByLastName() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act and Assert
    assertEquals(1, ownerRepository.findByLastName("Doe", Pageable.unpaged()).toList().size());
  }

  /**
   * Method under test: {@link OwnerRepository#findById(Integer)}
   */
  @Test
  void testFindById() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    ownerRepository.save(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner2);

    Owner owner3 = new Owner();
    owner3.setAddress("42 Main St");
    owner3.setCity("Oxford");
    owner3.setFirstName("Jane");
    owner3.setLastName("Doe");
    owner3.setTelephone("6625550144");
    ownerRepository.save(owner3);

    // Act and Assert
    assertSame(owner3, ownerRepository.findById(owner3.getId()));
  }

  /**
   * Method under test: {@link OwnerRepository#save(Owner)}
   */
  @Test
  void testSave() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    // Act
    ownerRepository.save(owner);

    // Assert
    List<PetType> findPetTypesResult = ownerRepository.findPetTypes();
    assertEquals(6, findPetTypesResult.size());
    PetType getResult = findPetTypesResult.get(0);
    assertEquals("bird", getResult.getName());
    PetType getResult2 = findPetTypesResult.get(1);
    assertEquals("cat", getResult2.getName());
    PetType getResult3 = findPetTypesResult.get(2);
    assertEquals("dog", getResult3.getName());
    PetType getResult4 = findPetTypesResult.get(3);
    assertEquals("hamster", getResult4.getName());
    PetType getResult5 = findPetTypesResult.get(4);
    assertEquals("lizard", getResult5.getName());
    PetType getResult6 = findPetTypesResult.get(5);
    assertEquals("snake", getResult6.getName());
    assertEquals(1, getResult2.getId().intValue());
    assertEquals(2, getResult3.getId().intValue());
    assertEquals(3, getResult5.getId().intValue());
    assertEquals(4, getResult6.getId().intValue());
    assertEquals(5, getResult.getId().intValue());
    assertEquals(6, getResult4.getId().intValue());
    assertFalse(getResult.isNew());
    assertFalse(getResult2.isNew());
    assertFalse(getResult3.isNew());
    assertFalse(getResult4.isNew());
    assertFalse(getResult5.isNew());
    assertFalse(getResult6.isNew());
  }

  /**
   * Method under test: {@link OwnerRepository#findAll(Pageable)}
   */
  @Test
  void testFindAll() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");
    ownerRepository.save(owner);
    ownerRepository.save(owner2);

    // Act and Assert
    assertEquals(12, ownerRepository.findAll(Pageable.unpaged()).toList().size());
  }
}
