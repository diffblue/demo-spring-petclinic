package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {VetRepository.class})
@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.springframework.samples.petclinic.vet"})
class VetRepositoryDiffblueTest {
  @Autowired
  private VetRepository vetRepository;

  /**
   * Test {@link VetRepository#findAll()}.
   * <p>
   * Method under test: {@link VetRepository#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection VetRepository.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange and Act
    Collection<Vet> actualFindAllResult = vetRepository.findAll();

    // Assert
    assertTrue(actualFindAllResult instanceof List);
    assertEquals(6, actualFindAllResult.size());
    Vet getResult = ((List<Vet>) actualFindAllResult).get(0);
    assertEquals("Carter", getResult.getLastName());
    Vet getResult2 = ((List<Vet>) actualFindAllResult).get(2);
    assertEquals("Douglas", getResult2.getLastName());
    Vet getResult3 = ((List<Vet>) actualFindAllResult).get(1);
    assertEquals("Helen", getResult3.getFirstName());
    Vet getResult4 = ((List<Vet>) actualFindAllResult).get(4);
    assertEquals("Henry", getResult4.getFirstName());
    assertEquals("James", getResult.getFirstName());
    Vet getResult5 = ((List<Vet>) actualFindAllResult).get(5);
    assertEquals("Jenkins", getResult5.getLastName());
    assertEquals("Leary", getResult3.getLastName());
    assertEquals("Linda", getResult2.getFirstName());
    Vet getResult6 = ((List<Vet>) actualFindAllResult).get(3);
    assertEquals("Ortega", getResult6.getLastName());
    assertEquals("Rafael", getResult6.getFirstName());
    assertEquals("Sharon", getResult5.getFirstName());
    assertEquals("Stevens", getResult4.getLastName());
    assertEquals(0, getResult.getNrOfSpecialties());
    assertEquals(0, getResult5.getNrOfSpecialties());
    assertEquals(1, getResult.getId().intValue());
    List<Specialty> specialties = getResult3.getSpecialties();
    assertEquals(1, specialties.size());
    assertEquals(1, getResult6.getSpecialties().size());
    Set<Specialty> specialtiesInternal = getResult3.getSpecialtiesInternal();
    assertEquals(1, specialtiesInternal.size());
    assertEquals(1, getResult6.getSpecialtiesInternal().size());
    assertEquals(1, getResult3.getNrOfSpecialties());
    assertEquals(1, getResult6.getNrOfSpecialties());
    assertEquals(1, getResult4.getNrOfSpecialties());
    assertEquals(2, getResult3.getId().intValue());
    assertEquals(2, getResult2.getSpecialties().size());
    assertEquals(2, getResult2.getSpecialtiesInternal().size());
    assertEquals(2, getResult2.getNrOfSpecialties());
    assertEquals(3, getResult2.getId().intValue());
    assertEquals(4, getResult6.getId().intValue());
    assertEquals(5, getResult4.getId().intValue());
    assertEquals(6, getResult5.getId().intValue());
    assertFalse(getResult.isNew());
    assertFalse(getResult3.isNew());
    assertFalse(getResult2.isNew());
    assertFalse(getResult6.isNew());
    assertFalse(getResult4.isNew());
    assertFalse(getResult5.isNew());
    assertTrue(getResult.getSpecialties().isEmpty());
    assertTrue(getResult5.getSpecialties().isEmpty());
    assertTrue(getResult.getSpecialtiesInternal().isEmpty());
    assertTrue(getResult5.getSpecialtiesInternal().isEmpty());
    assertEquals(specialties, getResult4.getSpecialties());
    assertEquals(specialtiesInternal, getResult4.getSpecialtiesInternal());
  }

  /**
   * Test {@link VetRepository#findAll(Pageable)} with {@code Pageable}.
   * <p>
   * Method under test: {@link VetRepository#findAll(Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Pageable) with 'Pageable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page VetRepository.findAll(Pageable)"})
  void testFindAllWithPageable() throws DataAccessException {
    // Arrange and Act
    Page<Vet> actualFindAllResult = vetRepository.findAll(Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    assertEquals(6, actualFindAllResult.toList().size());
  }
}
