package com.saojose.estudoapi.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.saojose.estudoapi.Dialogos.FuncionarioDialog;
import com.saojose.estudoapi.Model.Funcionario;
import com.saojose.estudoapi.Model.Pais;
import com.saojose.estudoapi.R;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioAdapter extends RecyclerView.Adapter<FuncionarioAdapter.FuncionarioViewHolder> {

    ArrayList<Funcionario> funcionarios;
    Activity activity;

    public FuncionarioAdapter(ArrayList<Funcionario> funcionarios , Activity  a)
    {
        this.funcionarios = funcionarios;
        this.activity = a;
    }

    @Override
    public int getItemCount() {
        return funcionarios.size();
    }


    @Override
    public FuncionarioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.funcionario_card, viewGroup, false);
        FuncionarioViewHolder fvh = new FuncionarioViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(final FuncionarioViewHolder funcionarioViewHolder,final int i) {

        funcionarioViewHolder.PrimeiroNome.setText(funcionarios.get(i).getNome());
        funcionarioViewHolder.Nascimento.setText(funcionarios.get(i).getNascimento());
        //funcionarioViewHolder.Foto
        //Pegar imagem da URL

        funcionarioViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clique do card

                Toast.makeText(activity, "Clicou", Toast.LENGTH_SHORT).show();

                FuncionarioDialog dialogo = new FuncionarioDialog();
                dialogo.show(activity.getFragmentManager(),null);

            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    static class FuncionarioViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView PrimeiroNome, Nascimento;
        ImageView Foto;

        FuncionarioViewHolder(View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.card_funcionario);
            PrimeiroNome = itemView.findViewById(R.id.primeiroNome_card);
            Nascimento = itemView.findViewById(R.id.nascimento_card);
            Foto = itemView.findViewById(R.id.fotoFuncionario_card);

        }
    }
}