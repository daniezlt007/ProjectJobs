package projectjobs.app.com.br.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import projectjobs.app.com.br.R;
import projectjobs.app.com.br.interfaces.ItemClickListener;
import projectjobs.app.com.br.model.Jobs;
import projectjobs.app.com.br.model.JobsSync;
import projectjobs.app.com.br.util.Commom;
import projectjobs.app.com.br.views.CandidatesActivity;

class JobsRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    protected TextView txtAreaDeAtuacao;
    protected TextView txtPosicao;
    protected TextView txtTitulo;
    protected TextView txtDetalhes;

    private ItemClickListener itemClickListener;

    public JobsRecyclerViewHolder(View itemView) {
        super(itemView);
        txtAreaDeAtuacao = itemView.findViewById(R.id.txtAreaDeAtuacao);
        txtPosicao = itemView.findViewById(R.id.txtPosicao);
        txtTitulo = itemView.findViewById(R.id.txtTitulo);
        txtDetalhes = itemView.findViewById(R.id.txtDetalhes);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }



    @Override
    public void onClick(View v) {
        itemClickListener.onItemClick(v, getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
public class JobsRecyclerAdapter extends RecyclerView.Adapter<JobsRecyclerViewHolder>{

    private List<Jobs> elements;
    private Context context;

    public JobsRecyclerAdapter(List<Jobs> elements, Context context) {
        this.elements = elements;
        this.context = context;
    }

    @NonNull
    @Override
    public JobsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row_jobs, parent, false);
        return new JobsRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final JobsRecyclerViewHolder holder, int position) {
        holder.txtAreaDeAtuacao.setText("Área de Atuação: " + elements.get(position).getArea_de_atuacao());
        holder.txtPosicao.setText("Posição: " + elements.get(position).getPosicao());
        holder.txtTitulo.setText("Título: " + elements.get(position).getTitulo());
        holder.txtDetalhes.setText("Candidatos +");
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, CandidatesActivity.class);
                intent.putExtra(Commom.CHAVE_ID, elements.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
