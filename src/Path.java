/**
 * Path Data Structure.
 *
 * @author Mandy Zammit {@literal <zammit.mandy@gmail.com>}
 */
public class Path {

    private String path = "";
    private int pathValue;


    public Path(String path, int pathValue){
        this.path = path;
        this.pathValue = pathValue;
    }

    public int getPathValue() {
        return pathValue;
    }

    public void setPathValue(int pathValue) {
        this.pathValue = pathValue;
    }

    public String getPath() {
        return path;
    }

    /**
     * Appends to this path in reverse order.
     *
     * @param s
     */
    public void appendPathReverse(String s){
        if(path.equals("")){
            path += s;
        } else {
            path = s + " + " + path;
        }

    }
}
