package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PetTypeFormatter.class})
@ExtendWith(SpringExtension.class)
class PetTypeFormatterDiffblueTest {
  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private PetTypeFormatter petTypeFormatter;
  /**
   * Method under test: {@link PetTypeFormatter#print(PetType, Locale)}
   */
  @Test
  void testPrint() {
    // Arrange
    PetType petType = new PetType();
    petType.setId(1);
    petType.setName("Dog");

    // Act and Assert
    assertEquals("Dog", petTypeFormatter.print(petType, Locale.getDefault()));
  }

  /**
   * Method under test: {@link PetTypeFormatter#print(PetType, Locale)}
   */
  @Test
  void testPrint2() {
    // Arrange
    PetType petType = mock(PetType.class);
    when(petType.getName()).thenReturn("Bella");
    doNothing().when(petType).setId(Mockito.<Integer>any());
    doNothing().when(petType).setName(Mockito.<String>any());
    petType.setId(1);
    petType.setName("Dog");

    // Act
    String actualPrintResult = petTypeFormatter.print(petType, Locale.getDefault());

    // Assert
    verify(petType).setId(Mockito.<Integer>any());
    verify(petType).getName();
    verify(petType).setName(Mockito.<String>any());
    assertEquals("Bella", actualPrintResult);
  }

  /**
   * Method under test: {@link PetTypeFormatter#parse(String, Locale)}
   */
  @Test
  void testParse() throws ParseException {
    // Arrange
    when(ownerRepository.findPetTypes()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(ParseException.class, () -> petTypeFormatter.parse("Dog", Locale.getDefault()));
    verify(ownerRepository).findPetTypes();
  }

  /**
   * Method under test: {@link PetTypeFormatter#parse(String, Locale)}
   */
  @Test
  void testParse2() throws ParseException {
    // Arrange
    PetType petType = new PetType();
    petType.setId(1);
    petType.setName("Dog");

    ArrayList<PetType> petTypeList = new ArrayList<>();
    petTypeList.add(petType);
    when(ownerRepository.findPetTypes()).thenReturn(petTypeList);

    // Act
    PetType actualParseResult = petTypeFormatter.parse("Dog", Locale.getDefault());

    // Assert
    verify(ownerRepository).findPetTypes();
    assertSame(petType, actualParseResult);
  }

  /**
   * Method under test: {@link PetTypeFormatter#parse(String, Locale)}
   */
  @Test
  void testParse3() throws ParseException {
    // Arrange
    PetType petType = new PetType();
    petType.setId(1);
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setId(2);
    petType2.setName("Bella");

    ArrayList<PetType> petTypeList = new ArrayList<>();
    petTypeList.add(petType2);
    petTypeList.add(petType);
    when(ownerRepository.findPetTypes()).thenReturn(petTypeList);

    // Act
    PetType actualParseResult = petTypeFormatter.parse("Dog", Locale.getDefault());

    // Assert
    verify(ownerRepository).findPetTypes();
    assertSame(petType, actualParseResult);
  }
}
