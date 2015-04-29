/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.FacadeStub;
import Domain.Partner;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolaiharbo
 */
public class ControllerTest {
  
 @Test
 public void testGetAllPartners() throws Exception {
     Controller controller = new Controller(new FacadeStub());
     
     final String userId = "7";     
     
     ArrayList<Partner> partners = controller.getAllPartners();
     partners = controller.getAllPartners();
     Partner result = controller.getPartners(userId);
     
    assertThat(result.getUserid() , is(userId));
    assertThat(result.getPartnerid(), is(17));
    assertThat(result.getPartnername(), is("Kurt"));
    assertThat(result.getAddress(), is ("Hjemme"));
    assertThat(result.getCvr(), is (1234567891));
    assertThat(result.getPhone(), is(123456));
    assertThat(result.getZip(), is (8000));
    
 } 
    
}
