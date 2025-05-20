package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VetDiffblueTest {
  /**
   * Test {@link Vet#getSpecialtiesInternal()}.
   * <ul>
   *   <li>Given {@link Specialty} (default constructor) Id is one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Vet#getSpecialtiesInternal()}
   */
  @Test
  @DisplayName("Test getSpecialtiesInternal(); given Specialty (default constructor) Id is one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Vet.getSpecialtiesInternal()"})
  void testGetSpecialtiesInternal_givenSpecialtyIdIsOne_thenReturnSizeIsOne() {
    // Arrange
    Specialty specialty = new Specialty();
    specialty.setId(1);
    specialty.setName("Canines");

    Vet vet = new Vet();
    vet.addSpecialty(specialty);

    // Act and Assert
    assertEquals(1, vet.getSpecialtiesInternal().size());
  }

  /**
   * Test {@link Vet#getSpecialtiesInternal()}.
   * <ul>
   *   <li>Given {@link Vet} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Vet#getSpecialtiesInternal()}
   */
  @Test
  @DisplayName("Test getSpecialtiesInternal(); given Vet (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Vet.getSpecialtiesInternal()"})
  void testGetSpecialtiesInternal_givenVet_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new Vet()).getSpecialtiesInternal().isEmpty());
  }

  /**
   * Test {@link Vet#getSpecialties()}.
   * <ul>
   *   <li>Given {@link Specialty} (default constructor) Id is one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Vet#getSpecialties()}
   */
  @Test
  @DisplayName("Test getSpecialties(); given Specialty (default constructor) Id is one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Vet.getSpecialties()"})
  void testGetSpecialties_givenSpecialtyIdIsOne_thenReturnSizeIsOne() {
    // Arrange
    Specialty specialty = new Specialty();
    specialty.setId(1);
    specialty.setName("Canines");

    Vet vet = new Vet();
    vet.addSpecialty(specialty);

    // Act
    List<Specialty> actualSpecialties = vet.getSpecialties();

    // Assert
    assertEquals(1, actualSpecialties.size());
    assertSame(specialty, actualSpecialties.get(0));
  }

  /**
   * Test {@link Vet#getSpecialties()}.
   * <ul>
   *   <li>Given {@link Vet} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Vet#getSpecialties()}
   */
  @Test
  @DisplayName("Test getSpecialties(); given Vet (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Vet.getSpecialties()"})
  void testGetSpecialties_givenVet_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new Vet()).getSpecialties().isEmpty());
  }

  /**
   * Test {@link Vet#getNrOfSpecialties()}.
   * <ul>
   *   <li>Given {@link Specialty} (default constructor) Id is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Vet#getNrOfSpecialties()}
   */
  @Test
  @DisplayName("Test getNrOfSpecialties(); given Specialty (default constructor) Id is one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Vet.getNrOfSpecialties()"})
  void testGetNrOfSpecialties_givenSpecialtyIdIsOne_thenReturnOne() {
    // Arrange
    Specialty specialty = new Specialty();
    specialty.setId(1);
    specialty.setName("Canines");

    Vet vet = new Vet();
    vet.addSpecialty(specialty);

    // Act and Assert
    assertEquals(1, vet.getNrOfSpecialties());
  }

  /**
   * Test {@link Vet#getNrOfSpecialties()}.
   * <ul>
   *   <li>Given {@link Vet} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Vet#getNrOfSpecialties()}
   */
  @Test
  @DisplayName("Test getNrOfSpecialties(); given Vet (default constructor); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Vet.getNrOfSpecialties()"})
  void testGetNrOfSpecialties_givenVet_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new Vet()).getNrOfSpecialties());
  }

  /**
   * Test {@link Vet#addSpecialty(Specialty)}.
   * <ul>
   *   <li>Given {@link Specialty} (default constructor) Id is one.</li>
   *   <li>Then {@link Vet} (default constructor) Specialties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Vet#addSpecialty(Specialty)}
   */
  @Test
  @DisplayName("Test addSpecialty(Specialty); given Specialty (default constructor) Id is one; then Vet (default constructor) Specialties size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Vet.addSpecialty(Specialty)"})
  void testAddSpecialty_givenSpecialtyIdIsOne_thenVetSpecialtiesSizeIsTwo() {
    // Arrange
    Specialty specialty = new Specialty();
    specialty.setId(1);
    specialty.setName("Canines");

    Vet vet = new Vet();
    vet.addSpecialty(specialty);

    Specialty specialty2 = new Specialty();
    specialty2.setId(1);
    specialty2.setName("Canines");

    // Act
    vet.addSpecialty(specialty2);

    // Assert
    assertEquals(2, vet.getSpecialties().size());
    assertEquals(2, vet.getSpecialtiesInternal().size());
    assertEquals(2, vet.getNrOfSpecialties());
  }

  /**
   * Test {@link Vet#addSpecialty(Specialty)}.
   * <ul>
   *   <li>Given {@link Vet} (default constructor).</li>
   *   <li>Then {@link Vet} (default constructor) Specialties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Vet#addSpecialty(Specialty)}
   */
  @Test
  @DisplayName("Test addSpecialty(Specialty); given Vet (default constructor); then Vet (default constructor) Specialties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Vet.addSpecialty(Specialty)"})
  void testAddSpecialty_givenVet_thenVetSpecialtiesSizeIsOne() {
    // Arrange
    Vet vet = new Vet();

    Specialty specialty = new Specialty();
    specialty.setId(1);
    specialty.setName("Canines");

    // Act
    vet.addSpecialty(specialty);

    // Assert
    List<Specialty> specialties = vet.getSpecialties();
    assertEquals(1, specialties.size());
    assertEquals(1, vet.getSpecialtiesInternal().size());
    assertEquals(1, vet.getNrOfSpecialties());
    assertSame(specialty, specialties.get(0));
  }

  /**
   * Test new {@link Vet} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Vet}
   */
  @Test
  @DisplayName("Test new Vet (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Vet.<init>()"})
  void testNewVet() {
    // Arrange and Act
    Vet actualVet = new Vet();

    // Assert
    assertNull(actualVet.getId());
    assertNull(actualVet.getFirstName());
    assertNull(actualVet.getLastName());
    assertTrue(actualVet.getSpecialtiesInternal().isEmpty());
  }
}
