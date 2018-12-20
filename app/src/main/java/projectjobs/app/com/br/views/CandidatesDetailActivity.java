package projectjobs.app.com.br.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import projectjobs.app.com.br.R;
import projectjobs.app.com.br.model.Candidates;
import projectjobs.app.com.br.model.CandidatesSync;
import projectjobs.app.com.br.service.IJobsRest;
import projectjobs.app.com.br.util.Commom;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CandidatesDetailActivity extends AppCompatActivity {

    private TextView txtId, txtNome, txtEmail, txtExperiencia, txtResumo;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtId = findViewById(R.id.txtIdCandidate);
        txtNome = findViewById(R.id.txtNameCandidate);
        txtEmail = findViewById(R.id.txtEmailCandidate);
        txtExperiencia = findViewById(R.id.txtExperiencia);
        txtResumo = findViewById(R.id.txtResumo);

        Intent intent = getIntent();
        String id = intent.getStringExtra(Commom.CHAVE_ID);

        IJobsRest iJobsRest = IJobsRest.retrofit.create(IJobsRest.class);
        dialog = new ProgressDialog(CandidatesDetailActivity.this);
        dialog.setMessage("Carregando...");
        dialog.setCancelable(false);
        dialog.show();
        if (!id.equals("") || !id.isEmpty()) {
            Call<Candidates> call = iJobsRest.getDetailCandidate(Commom.headers(), id);
            call.enqueue(new Callback<Candidates>() {
                @Override
                public void onResponse(Call<Candidates> call, Response<Candidates> response) {
                    if (dialog.isShowing())
                        dialog.dismiss();
                    Candidates candidates = response.body();
                    if(candidates != null){
                        txtId.setText("Id: " + candidates.getId());
                        txtNome.setText("Nome: " +candidates.getNome());
                        txtEmail.setText("Email: " + candidates.getEmail());
                        txtExperiencia.setText("Experiência: " + candidates.getExperiencia());
                        txtResumo.setText("Resumo: " + candidates.getResumo());
                    }else{
                        txtId.setText("Não possui registros");
                    }
                }

                @Override
                public void onFailure(Call<Candidates> call, Throwable t) {
                    if (dialog.isShowing())
                        dialog.dismiss();
                    Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
                    System.out.println("Erro: " + t.getMessage());
                }
            });
        }




    }
}
