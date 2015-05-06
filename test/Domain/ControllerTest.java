
package Domain;

import DataSource.FacadeStub;
import Domain.Partner;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {
  
 @Test
 public void testGetAllPartners() throws Exception {
    Controller controller = new Controller(new FacadeStub());
     
    final String userId = "7";     
     
    ArrayList<Partner> partners = controller.getAllPartners();
    
    //Partner result = controller.getPartner(userId);
     //assertNotNull(partners);
    assertThat(partners.size(), is(1));
    assertThat(partners.get(0).getUserid(), is(userId));
    assertThat(partners.get(0).getPartnerid(), is(17));
    assertThat(partners.get(0).getPartnername(), is("Kurt"));
    assertThat(partners.get(0).getAddress(), is ("Hjemme"));
    assertThat(partners.get(0).getCvr(), is (1234567891));
    assertThat(partners.get(0).getPhone(), is(123456));
    assertThat(partners.get(0).getZip(), is (8000));
   
 } 

}
