package projectjobs.app.com.br.service;

import java.util.Map;

import projectjobs.app.com.br.model.Candidates;
import projectjobs.app.com.br.model.CandidatesSync;
import projectjobs.app.com.br.model.JobsSync;
import projectjobs.app.com.br.util.Commom;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IJobsRest {

    @GET("jobs")
    Call<JobsSync> getJobs();

    @Headers({"Content-Type: application/json"})
    @POST("jobs/{id}/candidates")
    Call<CandidatesSync> getCandidates(@HeaderMap Map<String, String> headers , @Path("id") String id);

    @GET("candidates/{id}")
    Call<Candidates> getDetailCandidate(@HeaderMap Map<String, String> headers , @Path("id") String id);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Commom.STRING_URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
