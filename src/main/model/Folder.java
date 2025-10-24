package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

public class Folder implements Writable {

    private List<Plant> folder;

    public Folder() {
        this.folder = new ArrayList<Plant>();
    }

    /*
     * REQUIRES: a valid plant
     * MODIFIES: this
     * EFFECTS: adds plant to the folder
     */
    public void addPlant(Plant p) {
        folder.add(p);
    }

    /*
     * REQUIRES: a valid plant
     * MODIFIES: this
     * EFFECTS: removes plant to the folder based on index pos
     */
    public void removePlant(int i) {
        folder.remove(i);
    }

    /*
     * REQUIRES: a valid plant
     * MODIFIES: this
     * EFFECTS: removes plant based on plant id
     */
    public void removeByPlantId(int id) {
        Plant suspect = null;
        for (Plant p : this.folder) {
            if (p.getPlantId() == id) {
                suspect = p;
            }

        }
        this.folder.remove(suspect);
    }

    /*
     * EFFECTS: checks if folder is empty
     */
    public boolean isFolderEmpty() {
        return folder.isEmpty();
    }

    /*
     * REQUIRES: a valid integer
     * MODIFIES: this
     * EFFECTS: gets plant
     */
    public Plant getPlant(int g) {
        return folder.get(g);
    }

    /*
     * MODIFIES: this
     * EFFECTS: returns folder size
     */
    public int folderSize() {
        return folder.size();
    }

    /*
     * REQUIRES: a non-empty list
     * MODIFIES: folder
     * EFFECTS: sort list by date descending order
     */
    public void sortListByDateAdded() {
        Collections.sort(this.folder, new Comparator<Plant>() {
            public int compare(Plant p1, Plant p2) {
                return Integer.valueOf(p2.getDateAdded()).compareTo(p1.getDateAdded());
            }
        });

    }

    /*
     * REQUIRES: a non-empty folder
     * MODIFIES: folder
     * EFFECTS: sort list by plantId ascending order
     */
    public void sortListByPlantId() {
        Collections.sort(this.folder, new Comparator<Plant>() {
            public int compare(Plant p1, Plant p2) {
                return Integer.valueOf(p1.getPlantId()).compareTo(p2.getPlantId());
            }
        });

    }

    /*
     * REQUIRES: a non-empty folder & existing plant Id
     * EFFECTS: returns plant object with corresponding plant id
     */
    public Plant getPlantByPlantId(int id) {
        for (Plant p : this.folder) {
            if (p.getPlantId() == id) {
                return p;
            }
        }
        return null;

    }

    /*
     * EFFECTS: returns folder field
     */
    public List<Plant> getFolder() {
        return this.folder;
    }
    
    //EFFECTS: returns this as JSON Object
    @Override
    public JSONObject toJson() {
        return null;
    }

    // EFFECTS: returns plants in this folder as a JSON array
    private JSONArray plantsToJson() {
        return null;
    }

}
