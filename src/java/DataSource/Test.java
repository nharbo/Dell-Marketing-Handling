
package DataSource;

import Domain.Campaign;
import Domain.Controller;
import java.sql.Date;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        DBfacade db = new DBfacade();
        Controller control = new Controller();
        
        db.getPOE(4444);
        
    }
}
