package projectjobs.app.com.br.model;

import java.util.List;

public class CandidatesSync {

    private List<Candidates> candidates;
    //private List<Paginador> paginador;

    public CandidatesSync() {

    }

    public CandidatesSync(List<Candidates> candidates) {
        this.candidates = candidates;
    }

    public List<Candidates> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidates> candidates) {
        this.candidates = candidates;
    }

}
