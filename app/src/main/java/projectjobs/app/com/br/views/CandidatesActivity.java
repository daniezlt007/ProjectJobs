package projectjobs.app.com.br.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import projectjobs.app.com.br.R;
import projectjobs.app.com.br.adapter.CandidatesRecyclerAdapter;
import projectjobs.app.com.br.model.Candidates;
import projectjobs.app.com.br.model.CandidatesSync;
import projectjobs.app.com.br.service.IJobsRest;
import projectjobs.app.com.br.util.Commom;
import projectjobs.app.com.br.util.InternetAvailable;
import projectjobs.app.com.br.util.InternetExcpecion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CandidatesActivity extends AppCompatActivity {

    ProgressDialog dialog;
    String id = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates);

    }

    @Override
    protected void onStart() {
        super.onStart();
        final RecyclerView listCandidates = findViewById(R.id.listCandidates);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        listCandidates.setLayoutManager(mLayoutManager);
        Intent intent = getIntent();
        id = intent.getStringExtra(Commom.CHAVE_ID);
        if (!InternetAvailable.isConnectionAvailable(this)) {
            new InternetExcpecion("Verifique sua conexão");
        } else {
            dialog = new ProgressDialog(CandidatesActivity.this);
            dialog.setMessage("Carregando...");
            dialog.setCancelable(false);
            dialog.show();


            IJobsRest iJobsRest = IJobsRest.retrofit.create(IJobsRest.class);

            if (!id.equals("") || !id.isEmpty()) {
                Call<CandidatesSync> call = iJobsRest.getCandidates(Commom.headers(), id);
                call.enqueue(new Callback<CandidatesSync>() {
                    @Override
                    public void onResponse(Call<CandidatesSync> call, Response<CandidatesSync> response) {
                        if (dialog.isShowing())
                            dialog.dismiss();
                        final List<Candidates> candidatesSync = response.body().getCandidates();

                        CandidatesRecyclerAdapter adapter = new CandidatesRecyclerAdapter(candidatesSync, CandidatesActivity.this);
                        if (candidatesSync != null) {
                            listCandidates.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<CandidatesSync> call, Throwable t) {
                        System.out.println("Erro: " + t.getMessage());
                    }
                });
            }
        }
    }
}
