/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.FacadeStub;
import java.util.ArrayList;
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
     
     ArrayList<Partner> partners = controller.getAllPartners();
     
     
 } 
    
}
