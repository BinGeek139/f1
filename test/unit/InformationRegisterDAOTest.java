/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit;

import com.ptit.managef1.dao.InformationRegisterDAO;
import com.ptit.managef1.model.InformationRegister;
import com.ptit.managef1.model.Race;
import com.ptit.managef1.model.Racer;
import com.ptit.managef1.model.RacingTeam;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ngocq
 */
public class InformationRegisterDAOTest {
    Race race=new Race();
    Racer racer1=new Racer();
    Racer racer2=new Racer();
    RacingTeam racingTeam=new RacingTeam();
    
    @Test
    public void testRegister(){
        race.setId(2);
        racingTeam.setId(1);
        racer1.setId(10);
        racer2.setId(3);
        List<InformationRegister> informationRegisters=new ArrayList<>();
        Date date=new Date(System.currentTimeMillis());
        informationRegisters.add(new InformationRegister( race, racingTeam, racer1,date));
         informationRegisters.add(new InformationRegister(race, racingTeam, racer2,date));
         InformationRegisterDAO aO=new InformationRegisterDAO();
             boolean result=aO.register(informationRegisters);
         Assert.assertTrue(result);
         Assert.assertEquals(result, true);
//         Assert.assertEquals(false, result);
         Assert.assertNotNull(result);
         
    }
}
