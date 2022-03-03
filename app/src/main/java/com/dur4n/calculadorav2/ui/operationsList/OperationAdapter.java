package com.dur4n.calculadorav2.ui.operationsList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dur4n.calculadorav2.R;
import com.dur4n.calculadorav2.data.model.Operacion;
import com.dur4n.calculadorav2.databinding.FragmentOperationsListBinding;
import com.dur4n.calculadorav2.databinding.ItemOperationBinding;

import java.util.List;

public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.ViewHolder> {

    List<Operacion> operacionList;
    OnManageOperationListener listener;
    Context context;

    interface OnManageOperationListener {
        void onShowInformationOperation(Operacion operacion);
    }

    public OperationAdapter(
            List<Operacion> operacionList,
            OnManageOperationListener listener,
            Context context
    ) {
        this.operacionList = operacionList;
        this.listener = listener;
        this.context = context;
    }

    /**
     * Create the view
     *
     * @param parent
     * @param viewType
     * @return
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_operation, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Apply data and functionality
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvOperation.setText(this.operacionList.get(position).getOperacion());
        holder.bind(operacionList.get(position), listener);
    }

    /**
     * Get the count of the list
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return operacionList.size();
    }

    public void update(List<Operacion> operacionList) {
        this.operacionList.clear();
        this.operacionList.addAll(operacionList);
        notifyDataSetChanged();
    }

    /**
     * Construct, apply data and functionality of each item of the rv
     */
    /*
    public class ViewHolder extends RecyclerView.ViewHolder {

        //v2 create a databinding
        private ItemOperationBinding itemBinding;
        public ViewHolder(ItemOperationBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
            itemBinding.setHandler(this);
        }
        //bind para aplicar funcionalidad
        public void bind(Operacion operacion, OnManageOperationListener listener){
            itemBinding.setOperacion(operacion);

            // async method
            itemView.setOnClickListener(view -> {
                listener.onShowInformationOperation(operacion);
            });
        }
    }

     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvOperation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOperation = itemView.findViewById(R.id.tvOperation);
        }
        public void bind(Operacion operacion, OnManageOperationListener listener){
            // async method
            itemView.setOnClickListener(view -> {
                listener.onShowInformationOperation(operacion);
            });
        }
    }
}