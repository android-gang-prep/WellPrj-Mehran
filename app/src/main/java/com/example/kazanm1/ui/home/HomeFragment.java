package com.example.kazanm1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.kazanm1.R;
import com.example.kazanm1.databinding.HomeFragmentBinding;
import com.example.kazanm1.models.WellModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;

    private HomeViewModel viewModel;


    private List<WellModel> wellModels;

    private WellModel wellModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        adapter.setNotifyOnChange(false);
        wellModels = new ArrayList<>();
        viewModel.getWells().observe(getViewLifecycleOwner(), wellModels -> {
            this.wellModels = new ArrayList<>(wellModels);
            adapter.clear();
            for (int i = 0; i < wellModels.size(); i++) {
                adapter.add(wellModels.get(i).getWell().getWellName());
            }
            adapter.notifyDataSetChanged();
            if (wellModel == null) {
                wellModel = wellModels.get(0);
                binding.setModel(wellModel);
            }

        });

        binding.well.setAdapter(adapter);
        binding.well.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (wellModel == wellModels.get(position))
                    return;
                wellModel = wellModels.get(position);
                binding.setModel(wellModel);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.floatingActionButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_addFragment);
        });

        binding.edit.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putLong("id",wellModels.get(binding.well.getSelectedItemPosition()).getWell().getID());
            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_addFragment,bundle);
        });

    }
}
