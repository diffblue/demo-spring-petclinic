package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class OwnerDiffblueTest {
  /**
   * Method under test: {@link Owner#addPet(Pet)}
   */
  @Test
  void testAddPet() {
    // Arrange
    Owner owner = new Owner();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);

    // Act
    owner.addPet(pet);

    // Assert that nothing has changed
    assertEquals("1970-01-01", pet.getBirthDate().toString());
    assertEquals("Bella", pet.getName());
    assertFalse(pet.isNew());
    assertTrue(pet.getVisits().isEmpty());
    assertTrue(owner.getPets().isEmpty());
    assertTrue(owner.isNew());
    assertSame(type, pet.getType());
  }

  /**
   * Method under test: {@link Owner#getPet(Integer)}
   */
  @Test
  void testGetPet() {
    // Arrange, Act and Assert
    assertNull((new Owner()).getPet(1));
    assertNull((new Owner()).getPet("Bella"));
    assertNull((new Owner()).getPet("Bella", true));
  }

  /**
   * Methods under test:
   * 
   * <ul>
   *   <li>default or parameterless constructor of {@link Owner}
   *   <li>{@link Owner#setAddress(String)}
   *   <li>{@link Owner#setCity(String)}
   *   <li>{@link Owner#setTelephone(String)}
   *   <li>{@link Owner#toString()}
   *   <li>{@link Owner#getAddress()}
   *   <li>{@link Owner#getCity()}
   *   <li>{@link Owner#getPets()}
   *   <li>{@link Owner#getTelephone()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Owner actualOwner = new Owner();
    actualOwner.setAddress("42 Main St");
    actualOwner.setCity("Oxford");
    actualOwner.setTelephone("6625550144");
    actualOwner.toString();
    String actualAddress = actualOwner.getAddress();
    String actualCity = actualOwner.getCity();
    actualOwner.getPets();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("6625550144", actualOwner.getTelephone());
    assertEquals("Oxford", actualCity);
  }
}
