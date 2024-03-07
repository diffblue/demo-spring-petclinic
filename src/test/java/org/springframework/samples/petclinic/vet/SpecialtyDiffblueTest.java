package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SpecialtyDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Specialty}
   */
  @Test
  void testNewSpecialty() {
    // Arrange and Act
    Specialty actualSpecialty = new Specialty();

    // Assert
    assertNull(actualSpecialty.getId());
    assertNull(actualSpecialty.getName());
    assertTrue(actualSpecialty.isNew());
  }
}
