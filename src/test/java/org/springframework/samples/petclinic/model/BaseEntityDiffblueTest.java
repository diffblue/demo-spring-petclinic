package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BaseEntityDiffblueTest {
  /**
   * Methods under test:
   * 
   * <ul>
   *   <li>default or parameterless constructor of {@link BaseEntity}
   *   <li>{@link BaseEntity#setId(Integer)}
   *   <li>{@link BaseEntity#getId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BaseEntity actualBaseEntity = new BaseEntity();
    actualBaseEntity.setId(1);

    // Assert that nothing has changed
    assertEquals(1, actualBaseEntity.getId().intValue());
  }

  /**
   * Method under test: {@link BaseEntity#isNew()}
   */
  @Test
  void testIsNew() {
    // Arrange, Act and Assert
    assertTrue((new BaseEntity()).isNew());
  }

  /**
   * Method under test: {@link BaseEntity#isNew()}
   */
  @Test
  void testIsNew2() {
    // Arrange
    BaseEntity baseEntity = new BaseEntity();
    baseEntity.setId(1);

    // Act and Assert
    assertFalse(baseEntity.isNew());
  }
}
