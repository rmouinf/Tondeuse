package input.file;

import model.Position;
import input.IEntryMapper;
import model.Tondeuse;
import model.Terrain;

import java.util.ArrayList;
import java.util.List;

public class FileEntryParser implements IEntryMapper {
    private List<Tondeuse> tondeuseList;

    private List<String> movements;
    private Terrain terrain;
    private String filePath;

    public FileEntryParser() {
        this.tondeuseList = new ArrayList<>();
        this.terrain = new Terrain();
        this.filePath = "";
        this.movements = new ArrayList<>();
    }



    public List<Tondeuse> getTondeuseList() {
        return tondeuseList;
    }

    public List<String> getMovements() {
        return movements;
    }


    public Terrain getTerrain() {
        return terrain;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void parse() {
        List<String> entryList = FileReaderService.readFileInList(this.filePath);
        String[] terrainRightCornerInput = entryList.get(0).split(" ");
        Position terrainCornerPosition = new Position(Integer.parseInt(terrainRightCornerInput[0]), Integer.parseInt(terrainRightCornerInput[1]));
        this.terrain.setRightUpCornerPoint(terrainCornerPosition);

        for (int i = 1; i < entryList.size(); i += 2) {
            String[] tondusePosition = entryList.get(i).split(" ");
            Position tonduseInitialPosition = new Position(Integer.parseInt(tondusePosition[0]), Integer.parseInt(tondusePosition[1]));
            char tonduseOrientation = tondusePosition[2].charAt(0);
            Tondeuse tondeuse = new Tondeuse(tonduseInitialPosition, tonduseOrientation);
            this.tondeuseList.add(tondeuse);
            this.movements.add(entryList.get(i + 1));

        }
    }


}
