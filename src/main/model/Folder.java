package model;

import java.util.ArrayList;
import java.util.List;

public class Folder {

    public List<Plant> folder;

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
     * EFFECTS: removes plant to the folder
     */
    public void removePlant(int i) {
        folder.remove(i);
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


}
