package com.dur4n.calculadorav2.ui.operations;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dur4n.calculadorav2.R;
import com.dur4n.calculadorav2.data.model.Operacion;
import com.dur4n.calculadorav2.databinding.FragmentOperationsBinding;

public class OperationsFragment extends Fragment implements OperationsContract.View {

    OperationsPresenter presenter;
    FragmentOperationsBinding binding;

    Operacion operacion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new OperationsPresenter(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentOperationsBinding.inflate(inflater);

        initBtn();

        return binding.getRoot();
    }

    private void initBtn() {

        binding.btnUno.setOnClickListener(listener -> {
            /*
            Log.d("boton", "pulsado");
            Operacion op = binding.getOperation();
            op.setOperacion(op.getOperacion()+"1");
            binding.setOperation(op);
            */
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+1);
        });
        binding.btnDos.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+2);
        });
        binding.btnTres.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+3);
        });
        binding.btnCuatro.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+4);
        });
        binding.btnCinco.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+5);
        });
        binding.btnSeis.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+6);
        });
        binding.btnSiete.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+7);
        });
        binding.btnOcho.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+8);
        });
        binding.btnNueve.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+9);
        });
        binding.btnSuma.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+"+");
        });
        binding.btnResta.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+"-");
        });
        binding.btnMultiplicacion.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+"x");
        });
        binding.btnDivision.setOnClickListener(listener -> {
            binding.tvOperations.setText(binding.tvOperations.getText().toString()+"/");
        });

        binding.btnResult.setOnClickListener(listener -> {
            String operation = binding.tvOperations.getText().toString();
            doOperation(operation);
        });
        binding.btnClear.setOnClickListener(listener -> {
            binding.tvOperations.setText("");
        });
    }

    public void writeView(View view) {
        Log.d("boton", "pulsado");
        switch (view.getId()){
            case R.id.btnUno:
                //binding.tvOperations.setText(binding.getOperation().getOperacion()+1);
                Operacion op = binding.getOperation();
                op.setOperacion(op.getOperacion()+"2");
                binding.setOperation(op);
                break;
            case R.id.btnDos:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+2);
                break;
            case R.id.btnTres:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+3);
                break;
            case R.id.btnCuatro:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+4);
                break;
            case R.id.btnCinco:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+5);
                break;
            case R.id.btnSeis:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+6);
                break;
            case R.id.btnSiete:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+7);
                break;
            case R.id.btnOcho:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+8);
                break;
            case R.id.btnNueve:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+9);
                break;
            case R.id.btnSuma:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+"+");
                break;
            case R.id.btnResta:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+"-");
                break;
            case R.id.btnMultiplicacion:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+"x");
                break;
            case R.id.btnDivision:
                binding.tvOperations.setText(binding.getOperation().getOperacion()+"/");
                break;
        }
    }
    public void getResult(View view) {
        String operation = binding.getOperation().getOperacion();
        doOperation(operation);
    }

    public void doOperation(String message) {
        presenter.doOperation(message);
    }

    @Override
    public void onInsertSuccess(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOperationSuccess(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOnOperationSuccess(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOnOperationInsertSuccess(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOnFailure(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


}