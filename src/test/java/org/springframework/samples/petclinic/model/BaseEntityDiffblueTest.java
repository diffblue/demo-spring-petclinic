package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseEntityDiffblueTest {
  /**
   * Test {@link BaseEntity#isNew()}.
   * <ul>
   *   <li>Given {@link BaseEntity} (default constructor) Id is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEntity#isNew()}
   */
  @Test
  @DisplayName("Test isNew(); given BaseEntity (default constructor) Id is one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseEntity.isNew()"})
  void testIsNew_givenBaseEntityIdIsOne_thenReturnFalse() {
    // Arrange
    BaseEntity baseEntity = new BaseEntity();
    baseEntity.setId(1);

    // Act and Assert
    assertFalse(baseEntity.isNew());
  }

  /**
   * Test {@link BaseEntity#isNew()}.
   * <ul>
   *   <li>Given {@link BaseEntity} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEntity#isNew()}
   */
  @Test
  @DisplayName("Test isNew(); given BaseEntity (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseEntity.isNew()"})
  void testIsNew_givenBaseEntity_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BaseEntity()).isNew());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BaseEntity}
   *   <li>{@link BaseEntity#setId(Integer)}
   *   <li>{@link BaseEntity#getId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseEntity.<init>()", "Integer BaseEntity.getId()", "void BaseEntity.setId(Integer)"})
  void testGettersAndSetters() {
    // Arrange and Act
    BaseEntity actualBaseEntity = new BaseEntity();
    actualBaseEntity.setId(1);

    // Assert
    assertEquals(1, actualBaseEntity.getId().intValue());
  }
}
