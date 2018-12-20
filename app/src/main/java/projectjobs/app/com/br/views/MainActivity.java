package projectjobs.app.com.br.views;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import projectjobs.app.com.br.R;
import projectjobs.app.com.br.adapter.JobsRecyclerAdapter;
import projectjobs.app.com.br.model.Jobs;
import projectjobs.app.com.br.model.JobsSync;
import projectjobs.app.com.br.service.IJobsRest;
import projectjobs.app.com.br.util.InternetAvailable;
import projectjobs.app.com.br.util.InternetExcpecion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private RecyclerView listJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listJobs = findViewById(R.id.listJobs);
        listJobs.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        listJobs.setLayoutManager(mLayoutManager);

        if (!InternetAvailable.isConnectionAvailable(this)) {
            new InternetExcpecion("Verifique sua conexão");
        } else {

            IJobsRest iJobsRest = IJobsRest.retrofit.create(IJobsRest.class);
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Carregando...");
            dialog.setCancelable(false);
            dialog.show();

            Call<JobsSync> call = iJobsRest.getJobs();
            call.enqueue(new Callback<JobsSync>() {
                @Override
                public void onResponse(Call<JobsSync> call, Response<JobsSync> response) {
                    if (dialog.isShowing())
                        dialog.dismiss();
                    final List<Jobs> lista = response.body().getJobs();

                    if (lista != null) {
                        JobsRecyclerAdapter mAdapter = new JobsRecyclerAdapter(lista, MainActivity.this);
                        listJobs.setAdapter(mAdapter);
                    }
                }

                @Override
                public void onFailure(Call<JobsSync> call, Throwable t) {
                    if (dialog.isShowing())
                        dialog.dismiss();
                    Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
                    System.out.println("Erro: " + t.getMessage());
                }
            });

        }
    }

}
