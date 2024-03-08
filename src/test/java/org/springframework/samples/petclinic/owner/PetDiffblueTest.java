package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class PetDiffblueTest {
  /**
   * Method under test: {@link Pet#addVisit(Visit)}
   */
  @Test
  void testAddVisit() {
    // Arrange
    Pet pet = new Pet();

    Visit visit = new Visit();
    visit.setDate(LocalDate.of(1970, 1, 1));
    visit.setDescription("The characteristics of someone or something");
    visit.setId(1);

    // Act
    pet.addVisit(visit);

    // Assert
    assertEquals(1, pet.getVisits().size());
  }

  /**
   * Methods under test:
   * 
   * <ul>
   *   <li>default or parameterless constructor of {@link Pet}
   *   <li>{@link Pet#setBirthDate(LocalDate)}
   *   <li>{@link Pet#setType(PetType)}
   *   <li>{@link Pet#getBirthDate()}
   *   <li>{@link Pet#getType()}
   *   <li>{@link Pet#getVisits()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Pet actualPet = new Pet();
    LocalDate birthDate = LocalDate.of(1970, 1, 1);
    actualPet.setBirthDate(birthDate);
    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");
    actualPet.setType(type);
    LocalDate actualBirthDate = actualPet.getBirthDate();
    PetType actualType = actualPet.getType();
    actualPet.getVisits();

    // Assert that nothing has changed
    assertSame(type, actualType);
    assertSame(birthDate, actualBirthDate);
  }
}
