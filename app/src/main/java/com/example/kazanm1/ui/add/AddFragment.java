package com.example.kazanm1.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.kazanm1.database.entities.RockTypeEntity;
import com.example.kazanm1.database.entities.WellEntity;
import com.example.kazanm1.database.entities.WellLayerEntity;
import com.example.kazanm1.databinding.AddFragmentBinding;
import com.example.kazanm1.databinding.HomeFragmentBinding;
import com.example.kazanm1.models.WellLayerItem;
import com.example.kazanm1.models.WellLayerModel;
import com.example.kazanm1.models.WellModel;
import com.example.kazanm1.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AddFragment extends Fragment {

    private AddFragmentBinding binding;

    private AddViewModel viewModel;


    private List<RockTypeEntity> rocks;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AddViewModel.class);
        binding = AddFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        adapter.setNotifyOnChange(false);
        binding.rockType.setAdapter(adapter);
        viewModel.getRock().observe(getViewLifecycleOwner(), rockTypeEntities -> {
            rocks = new ArrayList<>(rockTypeEntities);
            adapter.clear();
            for (int i = 0; i < rockTypeEntities.size(); i++) {
                adapter.add(rockTypeEntities.get(i).getName());
            }
            adapter.notifyDataSetChanged();
        });

        List<WellLayerItem> rLayerItems = new ArrayList<>();
        AdapterWellLayer adapterWellLayer = new AdapterWellLayer(rLayerItems, rLayerItems::remove);
        binding.rec.setAdapter(adapterWellLayer);
        binding.rec.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.addL.setOnClickListener(v -> {
            if (binding.fromD.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Please Fill From Depth", Toast.LENGTH_SHORT).show();
                return;
            }
            if (binding.toD.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Please Fill To Depth", Toast.LENGTH_SHORT).show();
                return;
            }

            rLayerItems.add(new WellLayerItem(Long.parseLong(binding.fromD.getText().toString().trim()), Long.parseLong(binding.toD.getText().toString().trim()), rocks.get(binding.rockType.getSelectedItemPosition()).getID(), rocks.get(binding.rockType.getSelectedItemPosition()).getName()));
            adapterWellLayer.notifyDataSetChanged();
        });

        binding.appCompatButton.setOnClickListener(v -> {
            if (binding.wellName.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Please Fill All", Toast.LENGTH_SHORT).show();
                return;
            }
            if (binding.wellCapacity.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Please Fill All", Toast.LENGTH_SHORT).show();
                return;
            }
            if (binding.depthOfGas.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Please Fill All", Toast.LENGTH_SHORT).show();
                return;
            }
            if (rLayerItems.isEmpty()){
                Toast.makeText(getContext(), "Please Fill All", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                viewModel.addLayerWell(rLayerItems,viewModel.addWell(new WellEntity(0,1,binding.wellName.getText().toString().trim(),Long.parseLong(binding.depthOfGas.getText().toString().trim()),Long.parseLong(binding.wellCapacity.getText().toString().trim()))));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

            Navigation.findNavController(v).popBackStack();
        });

        binding.back.setOnClickListener(v -> {
            Navigation.findNavController(v).popBackStack();
        });
    }
}
