public class Games {

    private String name;
    private String year;
    private Integer maxPlaytime;
    private Integer minPlaytime;
    // private Integer gameDuration;

    public Games(String name, String year, Integer maxPlaytime, Integer minPlaytime) {
        this.name = name;
        this.year = year;
        this.maxPlaytime = maxPlaytime;
        this.minPlaytime = minPlaytime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public Integer getMaxPlaytime() {
        return maxPlaytime;
    }
    public void setMaxPlaytime(Integer maxPlaytime) {
        this.maxPlaytime = maxPlaytime;
    }
    public Integer getMinPlaytime() {
        return minPlaytime;
    }
    public void setMinPlaytime(Integer minPlaytime) {
        this.minPlaytime = minPlaytime;
    }

    public Integer getDuration () {
        int dur = maxPlaytime - minPlaytime;
        if (0 == dur){
            double v = Math.floor ((maxPlaytime + minPlaytime)/2);
            dur =(int)v;
        }
        return dur;

    }
    
}
