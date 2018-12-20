package projectjobs.app.com.br.model;

import java.util.List;


public class JobsSync {

    private List<Jobs> jobs;

    public JobsSync() {

    }

    public JobsSync(List<Jobs> jobs) {
        this.jobs = jobs;
    }

    public List<Jobs> getJobs() {
        return jobs;
    }

    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }

}
