package input.file;

import model.Position;
import input.IEntryMapper;
import model.Tondeuse;
import model.Terrain;

import java.util.ArrayList;
import java.util.List;

public class FileEntryParser implements IEntryMapper {
    private final static int TERRAIN_CORNER_COORDINATES_FILE_INDEX = 0;
    private final List<Tondeuse> tondeuseList;

    private final List<String> movements;
    private final Terrain terrain;
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
        List<String> fileLines = FileReaderService.readFileInList(this.filePath);
        String[] terrainRightCornerInput = fileLines.get(TERRAIN_CORNER_COORDINATES_FILE_INDEX).split(" ");
        Position terrainCornerPosition = new Position(Integer.parseInt(terrainRightCornerInput[0]), Integer.parseInt(terrainRightCornerInput[1]));
        this.terrain.setRightUpCornerPoint(terrainCornerPosition);

        List<String> tondeuseEntryList = fileLines.subList(1,fileLines.size());
        for (int i = 0; i < tondeuseEntryList.size(); i += 2) {
            String[] tondusePosition = tondeuseEntryList.get(i).split(" ");
            Position tonduseInitialPosition = new Position(Integer.parseInt(tondusePosition[0]), Integer.parseInt(tondusePosition[1]));
            char tonduseOrientation = tondusePosition[2].charAt(0);
            Tondeuse tondeuse = new Tondeuse(tonduseInitialPosition, tonduseOrientation);
            this.tondeuseList.add(tondeuse);
            this.movements.add(tondeuseEntryList.get(i + 1));

        }
    }


}
