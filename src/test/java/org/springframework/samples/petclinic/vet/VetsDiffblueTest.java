package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class VetsDiffblueTest {
  /**
   * Method under test: {@link Vets#getVetList()}
   */
  @Test
  void testGetVetList() {
    // Arrange, Act and Assert
    assertTrue((new Vets()).getVetList().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Vets}
   */
  @Test
  void testNewVets() {
    // Arrange, Act and Assert
    assertTrue((new Vets()).getVetList().isEmpty());
  }
}
