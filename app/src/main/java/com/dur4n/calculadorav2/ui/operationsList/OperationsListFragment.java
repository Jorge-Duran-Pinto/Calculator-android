package com.dur4n.calculadorav2.ui.operationsList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dur4n.calculadorav2.R;
import com.dur4n.calculadorav2.data.model.Operacion;
import com.dur4n.calculadorav2.databinding.FragmentOperationsListBinding;

import java.util.ArrayList;
import java.util.List;

public class OperationsListFragment extends Fragment implements OperationsListContract.View, OperationAdapter.OnManageOperationListener{

    FragmentOperationsListBinding binding;
    OperationsListContract.Presenter presenter;
    //v1
    OperationAdapter adapter;
    //v2 RecyclerView rvOperation;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new OperationListPresenter(this);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        // way for situations that dont have async request
        binding = FragmentOperationsListBinding.inflate(getLayoutInflater());
        /*
        rvOperation = binding.contentMainOperationsList.rvOperations;
        //puede fallar
        rvOperation.setLayoutManager(new LinearLayoutManager(getContext()));
         */
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // RV way for situations that have async request
        initRv();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getOperations();
    }

    private void initRv() {
        //1. Será inicializar el Adapter
        // old - ticketLotAdapter = new TicketLotAdapter(this);
        adapter = new OperationAdapter(new ArrayList<>(), this, getActivity());
        //2. OBLIGATORIAMENTE se debe indicar que diseñó tendrá el recyclerview
        //TODO cambiar el diseño
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        //3. Asigno el layout al recyclerview
        binding.contentMainOperationsList.rvOperations.setLayoutManager(linearLayoutManager);
        //4. Asigno a la vista sus datos (modelo)
        binding.contentMainOperationsList.rvOperations.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_operations_list, menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mi_operations:
                //navegate operations
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showData(List<Operacion> operacionList){
        binding.imageView.setVisibility(View.INVISIBLE);
        adapter.update(operacionList);
    }
    public void showNoData(){
        binding.imageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void getOperations() {
        presenter.getOperations();
    }

    @Override
    public void onListSuccess(List<Operacion> operacionList) {
        Toast.makeText(getContext(), "Success load", Toast.LENGTH_SHORT).show();
        showData(operacionList);
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        showNoData();
    }

    @Override
    public void onShowInformationOperation(Operacion operacion) {
        Toast.makeText(getContext(), operacion.getOperacion(), Toast.LENGTH_SHORT).show();
    }
}