package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

class PetValidatorDiffblueTest {
  /**
   * Method under test: {@link PetValidator#validate(Object, Errors)}
   */
  @Test
  void testValidate() {
    // Arrange
    PetValidator petValidator = new PetValidator();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);

    // Act
    petValidator.validate(pet, new BindException(pet, "org.springframework.samples.petclinic.owner.Pet"));

    // Assert that nothing has changed
    assertEquals("1970-01-01", pet.getBirthDate().toString());
    assertEquals("Bella", pet.getName());
    assertFalse(pet.isNew());
    assertTrue(pet.getVisits().isEmpty());
    assertSame(type, pet.getType());
  }

  /**
   * Method under test: {@link PetValidator#validate(Object, Errors)}
   */
  @Test
  void testValidate2() {
    // Arrange
    PetValidator petValidator = new PetValidator();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(null);
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);
    BindException errors = new BindException(pet, "org.springframework.samples.petclinic.owner.Pet");

    // Act
    petValidator.validate(pet, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("birthDate", fieldError.getField());
    assertEquals("org.springframework.samples.petclinic.owner.Pet", fieldError.getObjectName());
    assertNull(fieldError.getRejectedValue());
    assertFalse(fieldError.isBindingFailure());
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult.hasErrors());
    assertSame(errors.getPropertyEditorRegistry(), ((BeanPropertyBindingResult) bindingResult).getPropertyAccessor());
  }

  /**
   * Method under test: {@link PetValidator#validate(Object, Errors)}
   */
  @Test
  void testValidate3() {
    // Arrange
    PetValidator petValidator = new PetValidator();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(null);
    pet.setName("Bella");
    pet.setType(type);

    // Act
    petValidator.validate(pet, new BindException(pet, "org.springframework.samples.petclinic.owner.Pet"));

    // Assert that nothing has changed
    assertEquals("1970-01-01", pet.getBirthDate().toString());
    assertEquals("Bella", pet.getName());
    assertTrue(pet.getVisits().isEmpty());
    assertTrue(pet.isNew());
    assertSame(type, pet.getType());
  }

  /**
   * Method under test: {@link PetValidator#validate(Object, Errors)}
   */
  @Test
  void testValidate4() {
    // Arrange
    PetValidator petValidator = new PetValidator();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName(null);
    pet.setType(type);
    BindException errors = new BindException(pet, "org.springframework.samples.petclinic.owner.Pet");

    // Act
    petValidator.validate(pet, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("name", fieldError.getField());
    assertEquals("org.springframework.samples.petclinic.owner.Pet", fieldError.getObjectName());
    assertNull(fieldError.getRejectedValue());
    assertFalse(fieldError.isBindingFailure());
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult.hasErrors());
    assertSame(errors.getPropertyEditorRegistry(), ((BeanPropertyBindingResult) bindingResult).getPropertyAccessor());
  }

  /**
   * Method under test: {@link PetValidator#validate(Object, Errors)}
   */
  @Test
  void testValidate5() {
    // Arrange
    PetValidator petValidator = new PetValidator();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("");
    pet.setType(type);
    BindException errors = new BindException(pet, "org.springframework.samples.petclinic.owner.Pet");

    // Act
    petValidator.validate(pet, errors);

    // Assert
    FieldError fieldError = errors.getFieldError();
    assertEquals("", fieldError.getRejectedValue());
    assertEquals("name", fieldError.getField());
    assertEquals("org.springframework.samples.petclinic.owner.Pet", fieldError.getObjectName());
    assertFalse(fieldError.isBindingFailure());
    BindingResult bindingResult = errors.getBindingResult();
    assertTrue(bindingResult.hasErrors());
    assertSame(errors.getPropertyEditorRegistry(), ((BeanPropertyBindingResult) bindingResult).getPropertyAccessor());
  }

  /**
   * Method under test: {@link PetValidator#supports(Class)}
   */
  @Test
  void testSupports() {
    // Arrange
    PetValidator petValidator = new PetValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(petValidator.supports(clazz));
  }

  /**
   * Method under test: {@link PetValidator#supports(Class)}
   */
  @Test
  void testSupports2() {
    // Arrange
    PetValidator petValidator = new PetValidator();
    Class<Pet> clazz = Pet.class;

    // Act and Assert
    assertTrue(petValidator.supports(clazz));
  }
}
