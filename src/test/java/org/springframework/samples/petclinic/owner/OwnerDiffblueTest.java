package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.BaseEntity;

class OwnerDiffblueTest {
  /**
   * Test {@link Owner#addPet(Pet)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Pet} {@link BaseEntity#isNew()} return {@code true}.</li>
   *   <li>Then {@link Owner} (default constructor) Pets size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Owner#addPet(Pet)}
   */
  @Test
  @DisplayName("Test addPet(Pet); given 'true'; when Pet isNew() return 'true'; then Owner (default constructor) Pets size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Owner.addPet(Pet)"})
  void testAddPet_givenTrue_whenPetIsNewReturnTrue_thenOwnerPetsSizeIsOne() {
    // Arrange
    Owner owner = new Owner();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");
    Pet pet = mock(Pet.class);
    when(pet.isNew()).thenReturn(true);
    doNothing().when(pet).setId(Mockito.<Integer>any());
    doNothing().when(pet).setName(Mockito.<String>any());
    doNothing().when(pet).setBirthDate(Mockito.<LocalDate>any());
    doNothing().when(pet).setType(Mockito.<PetType>any());
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);

    // Act
    owner.addPet(pet);

    // Assert
    verify(pet).isNew();
    verify(pet).setId(eq(1));
    verify(pet).setName(eq("Bella"));
    verify(pet).setBirthDate(isA(LocalDate.class));
    verify(pet).setType(isA(PetType.class));
    List<Pet> pets = owner.getPets();
    assertEquals(1, pets.size());
    assertSame(pet, pets.get(0));
  }

  /**
   * Test {@link Owner#addPet(Pet)}.
   * <ul>
   *   <li>When {@link Pet} (default constructor) BirthDate is {@link LocalDate} with {@code 1970} and one and one.</li>
   *   <li>Then {@link Owner} (default constructor) Pets Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Owner#addPet(Pet)}
   */
  @Test
  @DisplayName("Test addPet(Pet); when Pet (default constructor) BirthDate is LocalDate with '1970' and one and one; then Owner (default constructor) Pets Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Owner.addPet(Pet)"})
  void testAddPet_whenPetBirthDateIsLocalDateWith1970AndOneAndOne_thenOwnerPetsEmpty() {
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
    assertTrue(owner.getPets().isEmpty());
  }

  /**
   * Test {@link Owner#getPet(Integer)} with {@code id}.
   * <p>
   * Method under test: {@link Owner#getPet(Integer)}
   */
  @Test
  @DisplayName("Test getPet(Integer) with 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(Integer)"})
  void testGetPetWithId() {
    // Arrange, Act and Assert
    assertNull((new Owner()).getPet(1));
  }

  /**
   * Test {@link Owner#getPet(String)} with {@code name}.
   * <p>
   * Method under test: {@link Owner#getPet(String)}
   */
  @Test
  @DisplayName("Test getPet(String) with 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String)"})
  void testGetPetWithName() {
    // Arrange, Act and Assert
    assertNull((new Owner()).getPet("Bella"));
  }

  /**
   * Test {@link Owner#getPet(String, boolean)} with {@code name}, {@code ignoreNew}.
   * <p>
   * Method under test: {@link Owner#getPet(String, boolean)}
   */
  @Test
  @DisplayName("Test getPet(String, boolean) with 'name', 'ignoreNew'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String, boolean)"})
  void testGetPetWithNameIgnoreNew() {
    // Arrange, Act and Assert
    assertNull((new Owner()).getPet("Bella", true));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Owner.<init>()", "String Owner.getAddress()", "String Owner.getCity()",
      "List Owner.getPets()", "String Owner.getTelephone()", "void Owner.setAddress(String)",
      "void Owner.setCity(String)", "void Owner.setTelephone(String)", "String Owner.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    Owner actualOwner = new Owner();
    actualOwner.setAddress("42 Main St");
    actualOwner.setCity("Oxford");
    actualOwner.setTelephone("6625550144");
    actualOwner.toString();
    String actualAddress = actualOwner.getAddress();
    String actualCity = actualOwner.getCity();
    List<Pet> actualPets = actualOwner.getPets();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("6625550144", actualOwner.getTelephone());
    assertEquals("Oxford", actualCity);
    assertNull(actualOwner.getId());
    assertNull(actualOwner.getFirstName());
    assertNull(actualOwner.getLastName());
    assertTrue(actualPets.isEmpty());
  }
}
