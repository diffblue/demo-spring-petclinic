package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {VetRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.springframework.samples.petclinic.vet"})
@DataJpaTest
class VetRepositoryDiffblueTest {
  @Autowired
  private VetRepository vetRepository;
  /**
   * Method under test: {@link VetRepository#findAll()}
   */
  @Test
  void testFindAll() throws DataAccessException {
    // Arrange, Act and Assert
    assertEquals(6, vetRepository.findAll().size());
    assertEquals(6, vetRepository.findAll(Pageable.unpaged()).toList().size());
  }
}
