package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class VetDiffblueTest {
  /**
   * Method under test: {@link Vet#getSpecialtiesInternal()}
   */
  @Test
  void testGetSpecialtiesInternal() {
    // Arrange
    Vet vet = new Vet();

    // Act
    Set<Specialty> actualSpecialtiesInternal = vet.getSpecialtiesInternal();

    // Assert
    assertEquals(0, vet.getNrOfSpecialties());
    assertTrue(actualSpecialtiesInternal.isEmpty());
  }

  /**
   * Method under test: {@link Vet#getSpecialtiesInternal()}
   */
  @Test
  void testGetSpecialtiesInternal2() {
    // Arrange
    Vet vet = new Vet();
    vet.setFirstName("Jane");
    vet.setId(1);
    vet.setLastName("Doe");
    HashSet<Specialty> specialties = new HashSet<>();
    vet.setSpecialtiesInternal(specialties);

    // Act
    Set<Specialty> actualSpecialtiesInternal = vet.getSpecialtiesInternal();

    // Assert
    assertTrue(actualSpecialtiesInternal.isEmpty());
    assertSame(specialties, actualSpecialtiesInternal);
  }

  /**
   * Method under test: {@link Vet#getSpecialties()}
   */
  @Test
  void testGetSpecialties() {
    // Arrange
    Vet vet = new Vet();

    // Act and Assert
    assertTrue(vet.getSpecialties().isEmpty());
    assertTrue(vet.getSpecialtiesInternal().isEmpty());
  }

  /**
   * Method under test: {@link Vet#getSpecialties()}
   */
  @Test
  void testGetSpecialties2() {
    // Arrange
    Vet vet = new Vet();
    vet.setFirstName("Jane");
    vet.setId(1);
    vet.setLastName("Doe");
    vet.setSpecialtiesInternal(new HashSet<>());

    // Act and Assert
    assertTrue(vet.getSpecialties().isEmpty());
  }

  /**
   * Method under test: {@link Vet#getNrOfSpecialties()}
   */
  @Test
  void testGetNrOfSpecialties() {
    // Arrange
    Vet vet = new Vet();

    // Act and Assert
    assertEquals(0, vet.getNrOfSpecialties());
    assertTrue(vet.getSpecialtiesInternal().isEmpty());
  }

  /**
   * Method under test: {@link Vet#getNrOfSpecialties()}
   */
  @Test
  void testGetNrOfSpecialties2() {
    // Arrange
    Vet vet = new Vet();
    vet.setFirstName("Jane");
    vet.setId(1);
    vet.setLastName("Doe");
    vet.setSpecialtiesInternal(new HashSet<>());

    // Act and Assert
    assertEquals(0, vet.getNrOfSpecialties());
  }

  /**
   * Method under test: {@link Vet#addSpecialty(Specialty)}
   */
  @Test
  void testAddSpecialty() {
    // Arrange
    Vet vet = new Vet();

    Specialty specialty = new Specialty();
    specialty.setId(1);
    specialty.setName("Canines");

    // Act
    vet.addSpecialty(specialty);

    // Assert
    assertEquals(1, vet.getSpecialties().size());
    assertEquals(1, vet.getSpecialtiesInternal().size());
  }

  /**
   * Method under test: {@link Vet#addSpecialty(Specialty)}
   */
  @Test
  void testAddSpecialty2() {
    // Arrange
    Vet vet = new Vet();
    vet.setFirstName("Jane");
    vet.setId(1);
    vet.setLastName("Doe");
    vet.setSpecialtiesInternal(new HashSet<>());

    Specialty specialty = new Specialty();
    specialty.setId(1);
    specialty.setName("Canines");

    // Act
    vet.addSpecialty(specialty);

    // Assert
    assertEquals(1, vet.getSpecialtiesInternal().size());
  }

  /**
   * Methods under test:
   * 
   * <ul>
   *   <li>default or parameterless constructor of {@link Vet}
   *   <li>{@link Vet#setSpecialtiesInternal(Set)}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Vet actualVet = new Vet();
    HashSet<Specialty> specialties = new HashSet<>();
    actualVet.setSpecialtiesInternal(specialties);

    // Assert
    assertSame(specialties, actualVet.getSpecialtiesInternal());
  }
}
