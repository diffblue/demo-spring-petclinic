package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PetTypeDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link PetType}
   */
  @Test
  void testNewPetType() {
    // Arrange and Act
    PetType actualPetType = new PetType();

    // Assert
    assertNull(actualPetType.getId());
    assertNull(actualPetType.getName());
    assertTrue(actualPetType.isNew());
  }
}
