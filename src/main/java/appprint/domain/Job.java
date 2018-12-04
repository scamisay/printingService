package appprint.domain;

public class Job {

    private int totalPages;
    private int colorPages;
    private boolean isDouble;

    public Job(String s) {
        String[] values = s.split(",");
        this.totalPages = Integer.parseInt(values[0].trim());
        this.colorPages = Integer.parseInt(values[1].trim());;
        this.isDouble = Boolean.parseBoolean(values[2].trim());
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getColorPages() {
        return colorPages;
    }

    public void setColorPages(int colorPages) {
        this.colorPages = colorPages;
    }

    public boolean isDouble() {
        return isDouble;
    }

    public void setDouble(boolean aDouble) {
        isDouble = aDouble;
    }

    @Override
    public String toString() {
        return String.format("T:%d - C:%d - D:%b",
                getTotalPages(), getColorPages(),isDouble());
    }
}
