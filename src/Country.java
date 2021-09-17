

public class Country {
    private String name;
    private long population = 1;
    private long cases = 1;
    Virus virus = new Virus();


    public Country() {
    }

    public Country(String name, long population) {
        virus.start();
        this.name = name;
        this.population = population;
        this.cases = cases;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public long getCases() {
        this.cases = this.getPopulation() > virus.getVirusProgress()/10 ? virus.getVirusProgress()/10 : getPopulation();
        return this.cases;
    }

    public Virus getVirus() {
        return virus;
    }
}
