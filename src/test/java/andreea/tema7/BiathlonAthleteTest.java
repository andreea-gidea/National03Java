package andreea.tema7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static andreea.tema7.Main.*;

@RunWith(MockitoJUnitRunner.class)

public class BiathlonAthleteTest {

    @InjectMocks
    BiathlonAthlete biathlonAthleteMock = new BiathlonAthlete(1, "Ana Maria", "RO",LocalTime.of(0, 8, 23), LocalTime.of(0, 0, 0), "xxxxx", "xxxxx", "oooooo");
    @InjectMocks
    BiathlonAthlete biathlonAthleteMock2 = new BiathlonAthlete(2, "Raluca Postavaru", "RO", LocalTime.of(0, 8, 23), LocalTime.of(0, 0, 0), "xxxxx", "xxxxx", "xxxxx");



    @Test
    public void testFindFirstRunner() {

        List <BiathlonAthlete> list =new ArrayList<>();
        list.add(biathlonAthleteMock);
        list.add(biathlonAthleteMock2);
        System.out.println(list.indexOf(0));
        sortListByTotalTime(list);
        System.out.println(list.indexOf(0));
        Assert.assertEquals(biathlonAthleteMock2, list.get(0));

    }
    @Test
    public void testCSVParsing() throws IOException {
        File file = new File("src/main/resources/Athletes.csv");
        writer = getWriterInstance();
        writer.write("QUELQUECHOSE DE TITLU");
        writer.newLine();
        writeAthlete(writer, biathlonAthleteMock);
        writer.flush();
        List<BiathlonAthlete> athletesFromCVS = Main.makeListFromCVS(file);
        Assert.assertEquals(true, biathlonAthleteMock.equals(athletesFromCVS.get(0)));

    }
}
