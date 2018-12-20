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
import projectjobs.app.com.br.model.Candidates;
import projectjobs.app.com.br.util.Commom;
import projectjobs.app.com.br.views.CandidatesActivity;
import projectjobs.app.com.br.views.CandidatesDetailActivity;

class CandidatesRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    TextView txtNameCandidate;
    TextView txtEmailCandidate;
    TextView txtIdCandidate;
    TextView txtDetalhes;

    private ItemClickListener itemClickListener;


    public CandidatesRecyclerViewHolder(View itemView) {
        super(itemView);
        txtNameCandidate = itemView.findViewById(R.id.txtNameCandidate);
        txtEmailCandidate = itemView.findViewById(R.id.txtEmailCandidate);
        txtIdCandidate = itemView.findViewById(R.id.txtIdCandidate);
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
public class CandidatesRecyclerAdapter extends RecyclerView.Adapter<CandidatesRecyclerViewHolder>{

    private List<Candidates> elements;
    private Context context;

    public CandidatesRecyclerAdapter(List<Candidates> elements, Context context) {
        this.elements = elements;
        this.context = context;
    }

    @NonNull
    @Override
    public CandidatesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row_candidates, parent, false);
        return new CandidatesRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidatesRecyclerViewHolder holder, int position) {
        holder.txtNameCandidate.setText("Nome: " + elements.get(position).getNome());
        holder.txtEmailCandidate.setText("Email: " + elements.get(position).getEmail());
        holder.txtIdCandidate.setText("Id: " + elements.get(position).getId());
        holder.txtDetalhes.setText("Detalhes Candidato +");
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, CandidatesDetailActivity.class);
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
