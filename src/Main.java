import input.file.FileEntryParser;
import model.Tondeuse;
import controller.TondeuseMovementController;
import model.Terrain;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Get input test.txt file
        FileEntryParser fileEntryParser = new FileEntryParser();
        fileEntryParser.setFilePath("test.txt");
        fileEntryParser.parse();

        //Map data to models
        Terrain terrain = fileEntryParser.getTerrain();
        List<Tondeuse> tondeuseList = fileEntryParser.getTondeuseList();
        List<String> tonduseMovements = fileEntryParser.getMovements();

        //create a playground
        TondeuseMovementController tondeuseMovementController = new TondeuseMovementController(terrain , tondeuseList, tonduseMovements);

        //execute the movements
        tondeuseMovementController.runMovements();

        //Print results
        for (Tondeuse tondeuse : tondeuseList) {
            System.out.println(tondeuse.toString());
        }

    }
}